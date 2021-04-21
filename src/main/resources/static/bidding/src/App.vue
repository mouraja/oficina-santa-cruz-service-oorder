<template>
  <div id="app">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                  <!-- Container wrapper -->
                  <div class="container-fluid">
                    <!-- Navbar brand -->
                    <a class="navbar-brand" href="./index.html">
                      <img src="./img/logo-imagem.png" :title="company" width="35%" height="35%" />
                    </a>
                    <!-- Toggle button -->
                    <button
                      class="navbar-toggle"
                      type="button"
                      data-toggle="collapse"
                      data-target="#navbarMainMenu"
                      aria-controls="navbarMainMenu"
                      aria-expanded="false"
                      aria-label="Toggle navigation">
                      <i class="fas fa-bars"></i>
                    </button>
                    <!-- Collapsible wrapper -->
                    <div class="collapse navbar-collapse" id="navbarMainMenu">
                      <!-- Left links -->
                      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <!-- Navbar Home -->
                        <li class="nav-item active">
                          <a class="nav-link" aria-current="page" href="#">Home</a>
                        </li>
                        <!-- Navbar dropdown Services -->
                        <li class="nav-item dropdown">
                          <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarService"
                            role="button"
                            data-toggle="dropdown"
                            aria-expanded="false"
                            >
                            Services
                          </a>
                          <!-- Dropdown Manager -->
                          <ul class="dropdown-menu" role="menu" aria-labelledby="navbarService">
                            <li><a class="dropdown-item" href="ServiceOrders.html">Services Orders</a></li>
                            <li><a class="dropdown-item" href="Autoparts.html">Autopart Buy Orders</a></li>
                          </ul>
                        </li>              
                        <!-- Navbar dropdown Manager -->
                        <li class="nav-item dropdown">
                          <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarManager"
                            role="button"
                            data-toggle="dropdown"
                            aria-expanded="false"
                            >
                            Manager
                          </a>
                          <!-- Dropdown Manager -->
                          <ul class="dropdown-menu" aria-labelledby="navbarManager">
                            <li><a class="dropdown-item" href="Vehicles.html">Vehicles</a></li>
                            <li><a class="dropdown-item" href="Biddings.html">Biddings</a></li>
                          </ul>
                        </li>

                        <!-- Navbar dropdown Relationship -->
                        <li class="nav-item dropdown">
                          <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarRelationship"
                            role="button"
                            data-toggle="dropdown"
                            aria-expanded="false"
                            >
                            Relationship
                          </a>
                          <!-- Dropdown relationship -->
                          <ul class="dropdown-menu" aria-labelledby="navbarRelationship">
                            <li><a class="dropdown-item" href="PublicClients.html">Public clients</a></li>
                            <li><a class="dropdown-item" href="LegalClients.html">Legal clients</a></li>
                            <li><a class="dropdown-item" href="LegalClients.html">Clients</a></li>
                            <li><hr class="dropdown-divider" /></li>
                            <li>
                              <a class="dropdown-item disabled" tabindex="-1" aria-disabled="true" href="#">Reserved</a>
                            </li>
                          </ul>
                        </li>

                        <!-- Navbar About -->
                        <li class="nav-item">
                          <a class="nav-link disabled" tabindex="-1" aria-disabled="true" href="#">About</a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </nav>
                <!-- Navbar -->

    <div class="container mt-3">
      <router-view />
    </div>

    </div>
  </div>

</template>

<script>
export default {
  name: "app"
};
</script>
