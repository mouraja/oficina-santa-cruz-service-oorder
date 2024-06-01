<template>
  <div class="submit-form">
    <div v-if="!submitted">

            <div class="form-group">
                <label for="add-alias">Bidding alias</label>
                <input type="text" class="form-control" id="add-alias" v-model="bidding.alias" required/>
            </div>

            <div class="form-group">
                <label for="add-description">Bidding description</label>
                <input type="text" class="form-control" id="add-description" v-model="bidding.description" required/>
            </div>

            <div class="form-group">
                <label for="add-initial-date">Bidding initial date</label>
                <input type="text" class="form-control" id="add-initial-date" v-model="bidding.initialDate" required/>
            </div>

            <div class="form-group">
                <label for="add-expirate-date">Bidding expirate date</label>
                <input type="text" size="4" class="form-control" id="add-expirate-date" v-model="bidding.expirateDate"/>
            </div>

            <div class="form-group">
                <label for="add-observations">Observations</label>
                <textarea class="form-control" id="add-observations" rows="10"  placeholder="Put some observations" v-model="bidding.observations"></textarea>
            </div>

            <div class="form-group">
                <label for="add-status">Bidding status</label>
                <input type="checkbox" class="form-control" id="add-status" v-model="bidding.status" required/>
            </div>

            <button @click="saveBidding" class="btn btn-success">
                <i class="bi bi-check"></i>
                Create
            </button>

    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newBidding">Add</button>
    </div>
  </div>
</template>

</template>


<script>
import BiddingDataService from "../services/BiddingDataService";

export default {
  name: "bidding-add",
  data() {
    return {
      bidding: {
        id: null,
        alias: "",
        description: "",
        initialDate: null,
        expirateDate: null,
        observations: null,
        status: false
      },
      submitted: false
    };
  },
  methods: {
    saveBidding() {
      var data = {
        alias: this.bidding.alias,
        description: this.bidding.description,
        initialDate: this.bidding.initialDate,
        expirateDate: this.bidding.expirateDate,
        observations: this.bidding.observations,
        status: this.bidding.status
      };

      BiddingDataService.create(data)
        .then(response => {
          this.bidding.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newBidding() {
      this.submitted = false;
      this.bidding = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>