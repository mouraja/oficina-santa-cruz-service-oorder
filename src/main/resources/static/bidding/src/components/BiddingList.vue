<template id="bidding-list">
    <section>
        <div class="actions">
            <router-link class="btn btn-primary" :to="{name: 'bidding-add'}">
                <span class="glyphicon glyphicon-plus"></span>
                Add bidding
            </router-link>
        </div>
        <div class="filters row">
            <div class="form-group col-sm-5">
                <label for="search-element">Seach</label>
                <input v-model="searchKey" class="form-control" id="search-element" requred/>
            </div>
        </div>
        <div v-if="bidding.length == 0"
             class="alert alert-warning">No bidding found.</div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Alias</th>
                    <th scope="col">Init date</th>
                    <th scope="col">Expirate date</th>
                    <th scope="colgroup" colspan="2">Actions</th>
                </tr>
            </thead>
            <tbody>
              <tr v-for="bidding in filteredVehicles">
                <th scope="row">
                  <router-link :to="{name: 'bidding-view', params: {bidding_id: bidding.id}}">
                    {{ bidding.id }}
                  </router-link>
                </th>
            <td>{{ bidding.alias }}</td>
            <td>{{ bidding.initialDate }}</td>
            <td>{{ bidding.expirateDate }}</td>
          <td>
            <router-link :to="{name: 'bidding-edit', params: {bidding_id: bidding.id}}">
              <span class="bi bi-pencil text-primary" title="Edit"></span><!-- Edit -->
            </router-link>
          </td>
          <td>
            <router-link :to="{name: 'bidding-delete', params: {bidding_id: bidding.id}}">
               <span class="bi bi-trash text-danger" title="Delete"></span><!-- delete -->
             </router-link>
          </td>
          </tr>
          </tbody>
        </table>
    </section>
</template>


<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by title"
          v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
            @click="searchTitle"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Biddings List</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(bidding, index) in biddings"
          :key="index"
          @click="setActiveBidding(bidding, index)"
        >
          {{ bidding.title }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllBiddings">
        Remove All
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentBidding">
        <h4>Bidding</h4>
        <div>
          <label><strong>Alias:</strong></label> {{ currentBidding.alias }}
        </div>
        <div>
          <label><strong>Description:</strong></label> {{ currentBidding.description }}
        </div>
        <div>
          <label><strong>Status:</strong></label> {{ currentBidding.status ? "Activate" : "Expirate" }}
        </div>

        <a class="badge badge-warning"
          :href="'/biddings/edit/' + currentBidding.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Bidding...</p>
      </div>
    </div>
  </div>
</template>

<script>
import BiddingDataService from "../services/BiddingDataService";

export default {
  name: "biddings-list",
  data() {
    return {
      biddings: [],
      currentBidding: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveBiddings() {
      BiddingDataService.getAll()
        .then(response => {
          this.biddings = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveBiddings();
      this.currentBidding = null;
      this.currentIndex = -1;
    },

    setActiveBidding(bidding, index) {
      this.currentBidding = bidding;
      this.currentIndex = index;
    },

    removeAllBiddings() {
      BiddingDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    searchAlias() {
      BiddingDataService.findByAlias(this.alias)
        .then(response => {
          this.biddings = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveBiddings();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>