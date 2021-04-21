<template id="bidding-edit">
    <section>
        <h2>Edit new bidding</h2>
        <form @submit.prevent="createBidding">

            <div class="form-group">
                <label for="edit-description">Bidding description</label>
                <input type="text" class="form-control" id="edit-description" v-model="bidding.description" required/>
            </div>

            <div class="form-group">
                <label for="edit-alias">Bidding alias</label>
                <input type="text" class="form-control" id="edit-alias" v-model="bidding.alias" required/>
            </div>

            <div class="form-group">
                <label for="edit-initial-date">Bidding initial date</label>
                <input type="calendar" class="form-control" id="edit-initial-date" v-model="bidding.initialDate" required/>
            </div>

            <div class="form-group">
                <label for="edit-expirate-date">Manufactored expirate date</label>
                <input type="calendar" size="4" class="form-control" id="edit-expirate-date" v-model="bidding.expirateDate"/>
            </div>

            <div class="form-group">
                <label for="edit-observations">Observations</label>
                <textarea class="form-control" id="edit-observations" rows="10"  placeholder="Put some observations" v-model="bidding.observations"></textarea>
            </div>

            <div class="form-group">
                <label for="edit-status">Bidding status</label>
                <input type="checkbox" class="form-control" id="edit-status" v-model="bidding.status" required/>
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
    </section>
</template>
