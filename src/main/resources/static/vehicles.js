/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var vehicle = [];

function findVehicle (id) {
  return vehicle[findVehicleKey(id)];
}

function findVehicleKey (id) {
  for (var key = 0; key < vehicle.length; key++) {
    if (vehicle[key].id === id) {
      return key;
    }
  }
}

var vehicleService = {
  findAll(fn) {
    axios
      .get('/api/vehicles')
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  findById(id, fn) {
    axios
      .get('/api/vehicles/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  create(vehicle, fn) {
    axios
      .post('/api/vehicles', vehicle)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  update(id, vehicle, fn) {
    axios
      .put('/api/vehicles/' + id, vehicle)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  deleteVehicle(id, fn) {
    axios
      .delete('/api/vehicles/' + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  }
};

var List = Vue.extend({
  template: '#vehicle-list',
  data: function () {
    return {vehicle: [], searchKey: ''};
  },
  computed: {
    filteredVehicles() {
      return this.vehicle.filter((vehicle) => {
      	return vehicle.licensePlate.indexOf(this.searchKey) > -1;
      });
    }
  },
  mounted() {
    vehicleService.findAll(r => {this.vehicle = r.data; vehicle = r.data})
  }
});

var Vehicle = Vue.extend({
  template: '#vehicle',
  data: function () {
    return {vehicle: findVehicle(this.$route.params.vehicle_id)};
  }
});

var VehicleEdit = Vue.extend({
  template: '#vehicle-edit',
  data: function () {
    return {vehicle: findVehicle(this.$route.params.vehicle_id)};
  },
  methods: {
    updateVehicle: function () {
      vehicleService.update(this.vehicle.id, this.vehicle, r => router.push('/'))
    }
  }
});

var VehicleDelete = Vue.extend({
  template: '#vehicle-delete',
  data: function () {
    return {vehicle: findVehicle(this.$route.params.vehicle_id)};
  },
  methods: {
    deleteVehicle: function () {
      vehicleService.deleteVehicle(this.vehicle.id, r => router.push('/'));
    }
  }
});

var AddVehicle = Vue.extend({
  template: '#add-vehicle',
  data() {
    return {
      vehicle: {name: '', description: '', price: 0}
    };
  },
  methods: {
    createVehicle() {
      vehicleService.create(this.vehicle, r => router.push('/'));
    }
  }
});

var router = new VueRouter({
	routes: [
		{path: '/', component: List},
		{path: '/vehicle/:vehicle_id', component: Vehicle, name: 'vehicle'},
		{path: '/add-vehicle', component: AddVehicle},
		{path: '/vehicle/:vehicle_id/edit', component: VehicleEdit, name: 'vehicle-edit'},
		{path: '/vehicle/:vehicle_id/delete', component: VehicleDelete, name: 'vehicle-delete'}
	]
});

new Vue({
  router
}).$mount('#app');