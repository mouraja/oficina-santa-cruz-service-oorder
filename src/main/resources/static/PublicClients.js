//var publicClients = [
  /*{id: 1, name: 'Laravel', description: 'Provide Laravel Information.', price: 100},
  {id: 2, name: 'AngularJS', description: 'Provide AngularJS Information.', price: 100},
  {id: 3, name: 'PHP', description: 'Provide PHP Information.', price: 100}*/
//];

publicClients: [];
            
function findPublicClient (id) {
  return this.publicClients[findPublicClientKey(id)];
};

function findPublicClientKey (id) {
  for (var key = 0; key < publicClients.length; key++) {
    if (publicClients[key].id === id) {
      return key;
    }
  }
};

var PublicClientService = {

  api_path: 'http://localhost:8080/api/manager/client/public',

  findAll(fn) {
    axios
      .get(this.api_path, {
          'headers': {
            "Content-type": "application/json"
          }
      })
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  findById(id, fn) {
    console.info("Procurando um Mané");
    console.info(this.api_path); 
    axios
      .get(this.api_path + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  create(publicClient, fn) {
    axios
      .post(this.api_path, publicClient)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  update(id, publicClient, fn) {
    axios
      .put(this.api_path + id, publicClient)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

  deleteVehicle(id, fn) {
    axios
      .delete(this.api_path + id)
      .then(response => fn(response))
      .catch(error => console.log(error));
  },

};

var List = Vue.extend({
  template: '#public-client-list',
  data: function () {
    return {publicClients: [], searchKey: ''};
  },
  computed: {
    filteredPublicClients() {
      return this.publicClients.filter((publicClient) => {
      	return publicClient.publicName.indexOf(this.searchKey) > -1
      	  || publicClient.primaryContact.indexOf(this.searchKey) > -1
      	  || publicClient.primaryEmail.indexOf(this.searchKey) > -1
      	  || publicClient.publicFantasyName.toString().indexOf(this.searchKey) > -1;
      });
    }
  },
  mounted() {
    PublicClientService.findAll(r => {this.publicClients = r.data; publicClients = r.data})
  }
});

var publicClient = Vue.extend({
  template: '#public-client',
  data: function () {
    return {publicClient: findPublicClient(this.$route.params.publicClient_id)};
  }
});

var publicClientEdit = Vue.extend({
  template: '#public-client-edit',
  data: function () {
    return {publicClient: findPublicClient(this.$route.params.publicClient_id)};
  },
  methods: {
    updatePublicClient: function () {
      var publicClient = this.publicClient;
      publicClients[findPublicClientKey(publicClient.id)] = {
        id: publicClient.id,
        publicName: publicClient.publicName,
        publicFantasyName: publicClient.publicFantasyName,
        addressDelivery: publicClient.addressDelivery,
        addressBilling: publicClient.addressBilling,
        primaryContact: publicClient.primaryContact,
        primaryEmail: publicClient.primaryEmail,
        primaryPhoneNumber: publicClient.primaryPhoneNumber,
        primarySupportContact: publicClient.primarySupportContact,
        observations: publicClient.observations,
        status: publicClient.status
      };
      router.push('/');
    }
  }
});

var publicClientDelete = Vue.extend({
  template: '#public-client-delete',
  data: function () {
    return {publicClient: findPublicClient(this.$route.params.publicClient_id)};
  },
  methods: {
    deletePublicClient: function () {
      publicClients.splice(findPublicClientKey(this.$route.params.publicClient_id), 1);
      router.push('/');
    }
  }
});

var publicClientAdd = Vue.extend({
  template: '#public-client-add',
  data: function () {
    return {
      publicClient: {
        publicName: '',
        publicFantasyName: '',
        addressDelivery: '',
        addressBilling: '',
        primaryContact: '',
        primaryEmail: '',
        primaryPhoneNumber: '',
        primarySupportContact: '',
        observations: '',
        status: false
      }
    }
  },
  methods: {
    createPublicClient() {
      console.log(this.publicClient)
      PublicClientService.create(this.publicClient, r => router.push('/'));
    }
  }
});

var router = new VueRouter({
  routes: [
    {path: '/', component: List},
    {path: '/public-client/:publicClient_id', component: publicClient, name: 'public-client'},
    {path: '/public-client-add', component: publicClientAdd},
    {path: '/public-client/:publicClient_id/edit', component: publicClientEdit, name: 'public-client-edit'},
    {path: '/public-client/:publicClient_id/delete', component: publicClientDelete, name: 'public-client-delete'}
  ]
});

new Vue({
  el: '#app',
  data: {
    company: "Oficina Santa Cruz",
    title: "Public Client Managment",
    subtitle: "Add a new public client" 
  },
  router: router
});