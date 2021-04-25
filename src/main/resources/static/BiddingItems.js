
biddingItems: [];

function findBiddingItem(id) {
  return findBiddingItemKey(id);
};

function findBiddingItemKey(id) {
  return (this.biddingItems.find(key => key.id === id));
};


const BiddingItemService = {
  base_url: 'http://localhost:8080/api/manager/biddingitem/',

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

  findByBidding(id, fn) {
    axios
            .get(this.base_url + "bidding/" + id, {
              'headers': {
                "Content-type": "application/json"
              }
            })
            .then(response => fn(response))
            .catch(error => console.log(error));
  },
  
  create(biddingItem, fn) {
    axios
            .post(this.base_url, biddingItem)
            .then(response => fn(response))
            .catch(error => console.log(error));
  },

  update(id, biddingItem, fn) {
    axios
            .put(this.base_url + id, biddingItem)
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

/*** List Bidding Items By Bidding ***/
const BiddingItemListByBidding = Vue.extend({
  template: '#bidding-item-list-bidding',
  data: function () {
    return {
      biddingItems: [],
      searchKey: ''
    };
  },
  computed: {
    filteredBiddingItems() {
      return this.biddingItems.filter((biddingItem) => {
        return  biddingItem.status && (
                    biddingItem.code.indexOf(this.searchKey) > -1 ||
                    biddingItem.description.indexOf(this.searchKey) > -1
                );
      });
    }
  },
  mounted() {
    this.$data.subtitle = "Bidding Items List By Bidding";
    this.biddingItems = BiddingItemService.findbyBidding(this.$route.params.biddingItem_id);
    biddingItems = this.biddingItems;
  }
});

/*** List All Bidding Items ***/
const BiddingItemList = Vue.extend({
  template: '#bidding-item-list',
  data: function () {
    return {biddingItems: [], searchKey: ''};
  },
  computed: {
    filteredBiddingItems() {
      return this.biddingItems.filter((biddingItem) => {
        return  biddingItem.status && (
                    biddingItem.code.indexOf(this.searchKey) > -1 ||
                    biddingItem.description.indexOf(this.searchKey) > -1
                );
      });
    }
  },
  mounted() {
    this.$data.subtitle = "BiddingItems List";
    BiddingItemService.findAll(r => {
      this.biddingItems = r.data;
      biddingItems = r.data;
    });
  }
});

/*** View Bidding Item ***/
const BiddingItemView = Vue.extend({
  template: '#bidding-item-view',
  data: function () {
    return {biddingItem: findBiddingItem(this.$route.params.biddingItem_id)};
  },
  mounted() {
    this.$data.subtitle = "BiddingItem View";
  }
});

const BiddingItemEdit = Vue.extend({
  template: '#bidding-item-edit',
  data: function () {
    return {
      biddingItem: findBiddingItem(this.$route.params.biddingItem_id),
      institutions: []
    };
  },
  methods: {
    updateBiddingItem: function () {
        BiddingItemService.update(this.biddingItem.id, this.biddingItem, r => router.push('/'));
    },
    async listClients() {
      await BiddingItemService.findClients(r => {
        this.institutions = r.data;
        institutions = r.data;
        console.log(institutions);
      });
    }
  },
  mounted() {
    this.$data.subtitle = "BiddingItem Edit";
  },
  created() {
    this.listClients();
  }
});

const BiddingItemDelete = Vue.extend({
  template: '#bidding-item-delete',
  data: function () {
    return {biddingItem: findBiddingItem(this.$route.params.biddingItem_id)};
  },
  methods: {
    deleteBiddingItem: function () {
      BiddingItemService.delete(this.biddingItem.id, r => router.push('/'));
    }
  },
  mounted() {
    this.$data.subtitle = "BiddingItem Delete";
  }
});

const BiddingItemAdd = Vue.extend({
  template: '#bidding-item-add',
  data() {
    return {
      biddingItem: {
        id: null,
        alias: null,
        description: null,
        initialDate: null,
        expirateDate: null,
        publicInstitution: {
            id: 0,
            publicName: null,
            publicFantasyName: null,
            observations: '',
            status: false
        },
        observations: null,
        status: false
      },
      institutions: []
    };
  },
  methods: {
    createBiddingItem() {
      console.log(JSON.stringify(this.biddingItem));
      BiddingItemService.create(this.biddingItem, r => router.push('/'));
    },
    async listClients() {
      await BiddingItemService.findClients(r => {
        this.institutions = r.data;
        institutions = r.data;
      });
    }
  },
  created() {
    this.listClients();
  },
  mounted() {
    this.$data.subtitle = "Add BiddingItem";
  }
});

/*
const routerBiddingItem = new VueRouter({
  routes: [
    {path: '/', component: BiddingItemList},
    {path: '/biddingItem/view/:biddingItem_id', component: BiddingItemView, name: 'bidding-item-view'},
    {path: '/biddingItem/add', component: BiddingItemAdd, name: 'bidding-item-add'},
    {path: '/biddingItem/edit/:biddingItem_id', component: BiddingItemEdit, name: 'bidding-item-edit'},
    {path: '/biddingItem/edit/:biddingItem_id', component: BiddingItemDelete, name: 'bidding-item-delete'}
  ]
});
*/

/****
 const ClientList = new Vue({
 el: 'add-client-institution',
 data: () => ({
 clients: []
 }),
 methods: {
 async getClients() {
 await BiddingItemService.listClients(r => {
 this.clients = r.data;
 clients = r.data;
 });
 }
 },
 created() {
 this.getClients;
 }
 });
 ****/

/*
new Vue({
  el: '#app',
  data: {
    company: "Oficina Santa Cruz",
    title: "BiddingItem Managment",
    subtitle: ""
  },
  router: routerBiddingItem
});
*/