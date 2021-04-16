
publicClients: [];

function findPublicClient(id) {
  return findPublicClientKey(id);
}
;

function findPublicClientKey(id) {
  return this.publicClients.find(key => key.id === id);
}
;

const PublicClientService = {

  base_url: 'http://localhost:8080/api/manager/client/public/',

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

  create(publicClient, fn) {
    axios
            .post(this.base_url, publicClient)
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  update(id, publicClient, fn) {
    axios
            .put(this.base_url + id, publicClient)
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  delete(id, fn) {
    axios
            .delete(this.base_url + id)
            .then(response => fn(response))
            .catch(error => console.log(error));
  }

};

const publicClientList = Vue.extend({
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
    this.$data.subtitle = "Public Client List";
    PublicClientService.findAll(r => {
      this.publicClients = r.data;
      publicClients = r.data;
    });
  }
});

var publicClientView = Vue.extend({
  template: '#public-client-view',
  data: function () {
    return {publicClient: findPublicClient(this.$route.params.publicClient_id)};
  },
  mounted() {
    this.$data.subtitle = "Public Client View";
  }
});

var publicClientEdit = Vue.extend({
  template: '#public-client-edit',
  data: function () {
    return {publicClient: findPublicClient(this.$route.params.publicClient_id)};
  },
  methods: {
    updatePublicClient: function () {
      PublicClientService.update(this.publicClient.id, this.publicClient, r => router.push('/'));
    }
  },
  mounted() {
    this.$data.subtitle = "Public Client Edit";
  }
});

var publicClientDelete = Vue.extend({
  template: '#public-client-delete',
  data: function () {
    return {publicClient: findPublicClient(this.$route.params.publicClient_id)};
  },
  methods: {
    deletePublicClient: function () {
      PublicClientService.delete(this.publicClient.id, r => router.push('/'));
    }
  },
  mounted() {
    this.$data.subtitle = "Public Client Delete";
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
    };
  },
  methods: {
    createPublicClient() {
      PublicClientService.create(this.publicClient, r => router.push('/'));
    }
  },
  mounted() {
    this.$data.subtitle = "Public Client Add";
  }
});

var router = new VueRouter({
  routes: [
    {path: '/', component: publicClientList},
    {path: '/public-client/view/:publicClient_id', component: publicClientView, name: 'public-client-view'},
    {path: '/public-client/add', component: publicClientAdd, name: 'public-client-add'},
    {path: '/public-client/edit/:publicClient_id', component: publicClientEdit, name: 'public-client-edit'},
    {path: '/public-client/delete/:publicClient_id', component: publicClientDelete, name: 'public-client-delete'}
  ]
});

new Vue({
  el: '#app',
  data: {
    company: "Oficina Santa Cruz",
    title: "Public Client Managment",
    subtitle: ""
  },
  router: router
});
