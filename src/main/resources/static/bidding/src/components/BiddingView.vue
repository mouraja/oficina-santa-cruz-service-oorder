
<template>
  <div v-if="currentBidding" class="edit-form">
    <h4>Bidding</h4>
    <form>
      <div class="form-group">
        <label for="title">Alias</label>
        <input type="text" class="form-control" id="alias"
          v-model="currentBidding.alias"
        />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description"
          v-model="currentBidding.description"
        />
      </div>

            <div class="form-group">
                <label><strong>Initial date:</strong></label>
                <input type="text" class="form-control" id="initialDate" v-model="bidding.initialDate" required/>
            </div>

            <div class="form-group">
                <label><strong>Expirated date:</strong></label>
                <input type="text" size="4" class="form-control" id="expirateDate" v-model="bidding.expirateDate"/>
            </div>

            <div class="form-group">
                <label><strong>observations:</strong></label>
                <textarea class="form-control" id="observations" rows="10"  placeholder="Put some observations" v-model="bidding.observations"></textarea>
            </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        {{ currentBidding.status ? "Active" : "Expired" }}
      </div>
    </form>

    <button class="badge badge-primary mr-2"
      v-if="currentBidding.status"
      @click="updateStatus(false)"
    >
      Expire
    </button>
    <button v-else class="badge badge-primary mr-2"
      @click="updateStatus(true)"
    >
      Active
    </button>

    <button class="badge badge-danger mr-2"
      @click="deleteBidding"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateBidding"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Bidding...</p>
  </div>
</template>

<script>
import BiddingDataService from "../services/BiddingDataService";

export default {
  name: "bidding",
  data() {
    return {
      currentBidding: null,
      message: ''
    };
  },
  methods: {
    getBidding(id) {
      BiddingDataService.get(id)
        .then(response => {
          this.currentBidding = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    updatePublished(status) {
      var data = {
        id: this.currentBidding.id,
        title: this.currentBidding.title,
        description: this.currentBidding.description,
        published: status
      };

      BiddingDataService.update(this.currentBidding.id, data)
        .then(response => {
          this.currentBidding.published = status;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    updateBidding() {
      BiddingDataService.update(this.currentBidding.id, this.currentBidding)
        .then(response => {
          console.log(response.data);
          this.message = 'The bidding was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteBidding() {
      BiddingDataService.delete(this.currentBidding.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "biddings" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getBidding(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>