
vehicles: [];
owners: [];

function findVehicle(id) {
  return findVehicleKey(id);
};

function findVehicleKey(id) {
  return (this.vehicles.find(key => key.id === id));
};

function findItem(id, list) {
  return (list.find(key => key.id === id));
};

const VehicleService = {
  base_url: 'http://localhost:8080/api/manager/vehicle/',
  base_client: 'http://localhost:8080/api/manager/client/public/',

  findAll(fn) {
    axios
            .get(this.base_url, {
              'headers': {
                "Content-type": "application/json"
              }
            })
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  findById(id, fn) {
    axios
            .get(this.base_url + id, {
              'headers': {
                "Content-type": "application/json"
              }
            })
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  create(vehicle, fn) {
    axios
            .post(this.base_url, vehicle)
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  update(id, vehicle, fn) {
    axios
            .put(this.base_url + id, vehicle)
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  delete(id, fn) {
    axios
            .delete(this.base_url + id)
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  findClients(fn) {
    axios
            .get(this.base_client, {
              'headers': {
                'Content-type': 'application/json'
              }
            })
            .then(response => fn(response))
            .catch(error => console.log(error));
  }

};

const VehicleList = Vue.extend({
  template: '#vehicle-list',
  data: function () {
    return {vehicles: [], searchKey: ''};
  },
  computed: {
    filteredVehicles() {
      return this.vehicles.filter((vehicle) => {
        return  vehicle.status && (
                    vehicle.licensePlate.indexOf(this.searchKey) > -1 ||
                    vehicle.manufactor.indexOf(this.searchKey) > -1 ||
                    vehicle.model.indexOf(this.searchKey) > -1 ||
                    vehicle.clientOwner.publicFantasyName.indexOf(this.searchKey) > -1 ||
                    vehicle.clientOwner.publicName.indexOf(this.searchKey) > -1
                );
      });
    }
  },
  mounted() {
    this.$data.subtitle = "Vehicles List";
    VehicleService.findAll(r => {
      this.vehicles = r.data;
      vehicles = r.data;
    });
  }
});

const VehicleView = Vue.extend({
  template: '#vehicle-view',
  data: function () {
    return {vehicle: findVehicle(this.$route.params.vehicle_id)};
  },
  mounted() {
    this.$data.subtitle = "Vehicle View";
  }
});

const VehicleEdit = Vue.extend({
  template: '#vehicle-edit',
  data: function () {
    return {
      vehicle: findVehicle(this.$route.params.vehicle_id),
      owners: []
    };
  },
  methods: {
    updateVehicle: function () {
        VehicleService.update(this.vehicle.id, this.vehicle, r => router.push('/'));
    },
    async listClients() {
      await VehicleService.findClients(r => {
        this.owners = r.data;
        owners = r.data;
      });
    }
  },
  mounted() {
    this.$data.subtitle = "Vehicle Edit";
  },
  created() {
    this.listClients();
  }
});

const VehicleDelete = Vue.extend({
  template: '#vehicle-delete',
  data: function () {
    return {vehicle: findVehicle(this.$route.params.vehicle_id)};
  },
  methods: {
    deleteVehicle: function () {
      VehicleService.delete(this.vehicle.id, r => router.push('/'));
    }
  },
  mounted() {
    this.$data.subtitle = "Vehicle Delete";
  }
});

const VehicleAdd = Vue.extend({
  template: '#vehicle-add',
  data() {
    return {
      vehicle: {
        manufactor: '',
        model: '',
        madeYear: '',
        modelYear: '',
        licensePlate: '',
        clientOwner: {
            id: 0,
            publicName: '',
            publicFantasyName: '',
            observations: '',
            status: ''
        },
        observations: '',
        status: false
      },
      owners: []
    };
  },
  methods: {
    createVehicle() {
      VehicleService.create(this.vehicle, r => router.push('/'));
    },
    async listClients() {
      await VehicleService.findClients(r => {
        this.owners = r.data;
        owners = r.data;
      });
    }
  },
  created() {
    this.listClients();
  },
  mounted() {
    this.$data.subtitle = "Add Vehicle";
  }
});

const router = new VueRouter({
  routes: [
    {path: '/', component: VehicleList},
    {path: '/vehicle/view/:vehicle_id', component: VehicleView, name: 'vehicle-view'},
    {path: '/vehicle/add', component: VehicleAdd, name: 'vehicle-add'},
    {path: '/vehicle/edit/:vehicle_id', component: VehicleEdit, name: 'vehicle-edit'},
    {path: '/vehicle/edit/:vehicle_id', component: VehicleDelete, name: 'vehicle-delete'}
  ]
});

/*
 const ClientList = new Vue({
 el: 'add-client-owner',
 data: () => ({
 clients: []
 }),
 methods: {
 async getClients() {
 await VehicleService.listClients(r => {
 this.clients = r.data;
 clients = r.data;
 });
 }
 },
 created() {
 this.getClients;
 }
 });
 */

new Vue({
  el: '#app',
  data: {
    company: "Oficina Santa Cruz",
    title: "Vehicle Managment",
    subtitle: ""
  },
  router: router
});
