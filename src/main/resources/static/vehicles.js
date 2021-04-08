/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var vehicles = [];
var clients = [];
var base_path = '/api/vehicles';
var base_client = '/api/client/public';
function findVehicle (id) {
  return vehicles[findVehicleKey(id)];
}

function findVehicleKey (id) {
  for (var key = 0; key < vehicles.length; key++) {
    if (vehicles[key].id === id) {
      return key;
    }
  }
}

var vehicleService = {
  findAll(fn) {
    axios
      .get(base_path)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  findById(id, fn) {
    axios
      .get(base_path + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  create(vehicle, fn) {
    axios
      .post(base_path, vehicle)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  update(id, vehicle, fn) {
    axios
      .put(base_path + id, vehicle)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  deleteVehicle(id, fn) {
    axios
      .delete(base_path + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  listClients(fn) {
    axios
      .get(base_client)
      .then(response => fn(response))
      .catch(error => console.log(error));
  }

};

var List = Vue.extend({
  template: '#vehicle-list',
  data: function () {
    return {vehicles: [], searchKey: ''};
  },
  computed: {
    filteredVehicles() {
        console.log(this.vehicles.length);
      return this.vehicles.filter((vehicle) => {
      	return vehicle.licensePlate.indexOf(this.searchKey) > -1
            || vehicle.manufactor.indexOf(this.searchKey) > -1
            || vehicle.model.indexOf(this.searchKey) > -1;
      });
    }
  },
  mounted() {
    vehicleService.findAll(r => {this.vehicles = r.data; vehicles = r.data})
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
      vehicle: {
        manufactor: '',
        model: '',
        madeYear: '',
        modelYear: '',
        licensePlate: '',
        clientOwner: 0,
        observations: '',
        status: true
      }
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

var ListClients = new Vue({
  el: 'add-clientOwner',
  data: () => ({
    clients: []
  }),
  methods: {
    async getClients () {
      await vehicleService.listClients(r => {this.clients = r.data; clients = r.data})
    }
  },
  created () {
    this.getClients
  }
})

new Vue({
  router
}).$mount('#app');