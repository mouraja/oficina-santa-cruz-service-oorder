/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var serviceOrders = [];

function findServiceOrder (serviceOrderId) {
  return serviceOrders[findServiceOrderKey(serviceOrderId)];
}

function findServiceOrderKey (serviceOrderId) {
  for (var key = 0; key < serviceOrders.length; key++) {
    if (serviceOrders[key].id === serviceOrderId) {
      return key;
    }
  }
}

var serviceOrderService = {
  findAll(fn) {
    axios
      .get('/api/services/order')
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  findById(id, fn) {
    axios
      .get('/api/services/order/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  create(serviceOrder, fn) {
    axios
      .post('/api/services/order', serviceOrder)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  update(id, serviceOrder, fn) {
    axios
      .put('/api/services/order/' + id, serviceOrder)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  deleteServiceOrder(id, fn) {
    axios
      .delete('/api/services/order/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  }
};

var List = Vue.extend({
  template: '#serviceOrder-list',
  data: function () {
    return {serviceOrders: [], searchKey: ''};
  },
  computed: {
    filteredServiceOrders() {
      return this.serviceOrders.filter((serviceOrder) => {
      	return serviceOrder.licensePlate.indexOf(this.searchKey) > -1
      	  || serviceOrder.entryVehicleDate.indexOf(this.searchKey) > -1
      	  || serviceOrder.serviceOrderYear.toString().indexOf(this.searchKey) > -1;
      });
    }
  },
  mounted() {
    serviceOrderService.findAll(r => {this.serviceOrders = r.data; serviceOrders = r.data})
  }
});

var ServiceOrder = Vue.extend({
  template: '#serviceOrder',
  data: function () {
    return {serviceOrder: findServiceOrder(this.$route.params.serviceOrder_id)};
  }
});

var ServiceOrderEdit = Vue.extend({
  template: '#serviceOrder-edit',
  data: function () {
    return {serviceOrder: findServiceOrder(this.$route.params.serviceOrder_id)};
  },
  methods: {
    updateServiceOrder: function () {
      serviceOrderService.update(this.serviceOrder.serviceOrderId, this.serviceOrder, r => router.push('/'))
    }
  }
});

var ServiceOrderDelete = Vue.extend({
  template: '#serviceOrder-delete',
  data: function () {
    return {serviceOrder: findServiceOrder(this.$route.params.serviceOrder_id)};
  },
  methods: {
    deleteServiceOrder: function () {
      serviceOrderService.deleteServiceOrder(this.serviceOrder.serviceOrderId, r => router.push('/'));
    }
  }
});

var AddServiceOrder = Vue.extend({
  template: '#add-serviceOrder',
  data() {
    return {
      serviceOrder: {name: '', description: '', price: 0}
    };
  },
  methods: {
    createServiceOrder() {
      serviceOrderService.create(this.serviceOrder, r => router.push('/'));
    }
  }
});

var router = new VueRouter({
	routes: [
		{path: '/', component: List},
		{path: '/serviceOrder/:serviceOrder_id', component: ServiceOrder, name: 'serviceOrder'},
		{path: '/add-serviceOrder', component: AddServiceOrder},
		{path: '/serviceOrder/:serviceOrder_id/edit', component: ServiceOrderEdit, name: 'serviceOrder-edit'},
		{path: '/serviceOrder/:serviceOrder_id/delete', component: ServiceOrderDelete, name: 'serviceOrder-delete'}
	]
});

new Vue({
  router
}).$mount('#app');