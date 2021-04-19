<template id="vehicle-list">
    <section>
        <div class="actions">
            <router-link class="btn btn-primary" :to="{name: 'vehicle-add'}">
                <span class="glyphicon glyphicon-plus"></span>
                Add vehicle
            </router-link>
        </div>
        <div class="filters row">
            <div class="form-group col-sm-5">
                <label for="search-element">Seach</label>
                <input v-model="searchKey" class="form-control" id="search-element" requred/>
            </div>
        </div>
        <div v-if="vehicles.length == 0"
             class="alert alert-warning">No vehicle found.</div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">License plate</th>
                    <th scope="col">Manufactor</th>
                    <th scope="col">Model</th>
                    <th scope="col">Owner</th>
                    <th scope="colgroup" colspan="2">Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="vehicle in filteredVehicles">
                    <th scope="row">
            <router-link :to="{name: 'vehicle-view', params: {vehicle_id: vehicle.id}}">{{ vehicle.id }}</router-link>
            </th>
            <td>{{ vehicle.licensePlate }}</td>
            <td>{{ vehicle.manufactor }}</td>
            <td>{{ vehicle.model }}</td>
            <td>{{ vehicle.clientOwner.fantasyName }}</td>
            <td>
            <router-link class="btn btn-warning btn-xs" :to="{name: 'vehicle-edit', params: {vehicle_id: vehicle.id}}">Edit</router-link>
            </td>
            <td>
            <router-link class="btn btn-danger btn-xs" :to="{name: 'vehicle-delete', params: {vehicle_id: vehicle.id}}">Delete</router-link>
            </td>
            </tr>
            </tbody>
        </table>
    </section>
</template>
