<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Buscar Citas</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="plataforma.jsp">Odontosanitas</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Proximamente una Confirguracion</a></li>
                        <li><a class="dropdown-item" href="#!">Proximamente un Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Cerrar sesión</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Graficos</div>
                            <a class="nav-link" href="plataforma.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Plataforma
                            </a>
                            <div class="sb-sidenav-menu-heading">Gestion de Odontoasanitas</div>
         
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Gestion
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Citas
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="bcitas.jsp">Buscar Citas</a>
                                            <a class="nav-link" href="ccitas.jsp">Crear Citas</a>
                                            <a class="nav-link" href="ecitas.jsp">Editar Citas</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Usuarios
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="busuario.jsp">Buscar Usuarios</a>
                                            <a class="nav-link" href="cusuario.jsp">Crear Usuario</a>
                                            <a class="nav-link" href="eusuario.jsp">Editas Usuario</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading"></div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Grafico de Citas.
                            </a>
                            <a class="nav-link" href="tables.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Ingreso y Salida del Sistema -- Proximamente
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Carlos Hugo
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Crear Citas</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="Dashboard.jsp">Plataforma</a></li>
                            <li class="breadcrumb-item active">Gestion / Crear Citas</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                            <%@ page import="java.util.*, com.mycompany.odontologia.*" %>
                            <%
                                PacienteDAO pacienteDAO = new PacienteDAO();
                                OdontologoDAO odontologoDAO = new OdontologoDAO();
                                List<Paciente> pacientes = pacienteDAO.listarTodos();
                                List<Odontologo> odontologos = odontologoDAO.listarTodos();
                            %>
                            <form action="${pageContext.request.contextPath}/crearTurno" method="post">
                                <label>Fecha:</label>
                                <input type="date" name="fecha" required class="form-control" />

                                <label>Hora:</label>
                                <input type="time" name="hora" required class="form-control" />

                                <label>Paciente:</label>
                                <select name="paciente" class="form-control">
                                    <%
                                        for (Paciente p : pacientes) {
                                    %>
                                    <option value="<%= p.getId() %>"><%= p.getNombre() %></option>
                                    <%
                                        }
                                    %>
                                </select>

                                <label>Odontólogo:</label>
                                <select name="odontologo" class="form-control">
                                    <%
                                        for (Odontologo o : odontologos) {
                                    %>
                                    <option value="<%= o.getId() %>"><%= o.getNombre() %> - <%= o.getEspecialidad() %></option>
                                    <%
                                        }
                                    %>
                                </select>

                                <button type="submit" class="btn btn-success mt-3">Guardar Cita</button>
                            </form>

                            </div>
                        </div>
                        <div style="height: 100vh"></div>
                        <div class="card mb-4"><div class="card-body">When scrolling, the navigation stays at the top of the page. This is the end of the static navigation demo.</div></div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
