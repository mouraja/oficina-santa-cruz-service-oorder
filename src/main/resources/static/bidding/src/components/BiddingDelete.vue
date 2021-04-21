<template id="vehicle-delete">
    <div>
        <h2>Delete vehicle {{ vehicle.licensePlate }} (id:{{ vehicle.id }})</h2>
        <form @submit.prevent="deleteVehicle">
            <p>The action cannot be undone.</p>
            <button type="submit" class="btn btn-danger">Delete</button>
            <button type="submit" class="btn btn-danger">
                <router-link :to="{path: '/'}">Cancel</router-link>
            </button>
        </form>
    </div>
</template>
