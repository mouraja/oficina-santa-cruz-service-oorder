<template id="bidding-add">
    <section>
        <h2>Add new bidding</h2>
        <form @submit.prevent="createBidding">

            <div class="form-group">
                <label for="add-description">Bidding description</label>
                <input type="text" class="form-control" id="add-description" v-model="bidding.description" required/>
            </div>

            <div class="form-group">
                <label for="add-alias">Bidding alias</label>
                <input type="text" class="form-control" id="add-alias" v-model="bidding.alias" required/>
            </div>

            <div class="form-group">
                <label for="add-initial-date">Bidding initial date</label>
                <input type="text" class="form-control" id="add-initial-date" v-model="bidding.initialDate" required/>
            </div>

            <div class="form-group">
                <label for="add-expirate-date">Manufactored expirate date</label>
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

            <button type="submit" class="btn btn-primary">
                <i class="bi bi-check"></i>
                Create
            </button>
            <button type="reset" class="btn btn-warning">
                <router-link :to="{path: '/'}">
                    <i class="bi bi-x"></i>
                    Cancel
                </router-link>
            </button>
        </form>
        </div>
</template>
