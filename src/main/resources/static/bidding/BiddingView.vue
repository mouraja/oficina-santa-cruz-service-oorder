
<template id="vehicle-view">

    <section>
        <h2>View vehicle</h2>
        <div v-if="vehicle == undefined" class="alert alert-warning">Vehicle id {{ vehicle_id }} not found</div>
        <div v-else>
            <h2><i class="glyphicon glyphicon-tint"></i>{{ vehicle.id }}</h2> / <h2>{{ vehicle.licensePlate }}</h2>
            <b>Vehicle manufactor: </b>
            <div><span class="glyphicon glyphicon-user" style="color:gold" aria-hidden="true"></span>{{ vehicle.manufactor }}</div>
            <b>Vehicle model: </b>
            <div><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>{{ vehicle.model }}</div>
            <b>License plate: </b>
            <div><span class="glyphicon glyphicon-file" aria-hidden="true"></span>{{ vehicle.licensePlate }}</div>
            <b>Vehicle Manufactored Year: </b>
            <div><span class="glyphicon glyphicon-time" style="color:lightcoral" aria-hidden="true"></span>{{ vehicle.madeYear }}</div>
            <b>Vehicle Model Year: </b>
            <div><span class="glyphicon glyphicon-user" style="color:lightblue" aria-hidden="true"></span>{{ vehicle.madelYear }}</div>
            <b>Owner: </b>
            <div><span class="glyphicon glyphicon-tint" style="color:lightblue" aria-hidden="true"></span>{{ vehicle.clientOwner.publicName }}</div>
            <b>Vehicle observations: </b>
            <div><span class="glyphicon glyphicon-comment" style="color:lightsalmon" aria-hidden="true"></span>{{ vehicle.observations }}</div>
            <b>Status: </b>
            <div><span class="glyphicon glyphicon-hourglass" style="color:lightyellow" aria-hidden="true"></span>{{ vehicle.status }}</div>
            <br/>
            <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
            <a>
                <router-link to="/">Back to vehicle list</router-link>
            </a>
        </div>
    </section>
</template>
