<%@page import="model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="../assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Team11_Stockist</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Canonical SEO -->
    <link rel="canonical" href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro"/>

    <!--  Social tags      -->
    <meta name="keywords" content="creative tim, html dashboard, html css dashboard, web dashboard, bootstrap dashboard, bootstrap, css3 dashboard, bootstrap admin, light bootstrap dashboard, frontend, responsive bootstrap dashboard">

    <meta name="description" content="Forget about boring dashboards, get an admin template designed to be simple and beautiful.">

    <!-- Schema.org markup for Google+ -->
    <meta itemprop="name" content="Light Bootstrap Dashboard PRO by Creative Tim">
    <meta itemprop="description" content="Forget about boring dashboards, get an admin template designed to be simple and beautiful.">

    <meta itemprop="image" content="http://s3.amazonaws.com/creativetim_bucket/products/34/original/opt_lbd_pro_thumbnail.jpg">
    <!-- Twitter Card data -->

    <meta name="twitter:card" content="product">
    <meta name="twitter:site" content="@creativetim">
    <meta name="twitter:title" content="Light Bootstrap Dashboard PRO by Creative Tim">

    <meta name="twitter:description" content="Forget about boring dashboards, get an admin template designed to be simple and beautiful.">
    <meta name="twitter:creator" content="@creativetim">
    <meta name="twitter:image" content="http://s3.amazonaws.com/creativetim_bucket/products/34/original/opt_lbd_pro_thumbnail.jpg">
    <meta name="twitter:data1" content="Light Bootstrap Dashboard PRO by Creative Tim">
    <meta name="twitter:label1" content="Product Type">
    <meta name="twitter:data2" content="$29">
    <meta name="twitter:label2" content="Price">

    <!-- Open Graph data -->
    <meta property="og:title" content="Light Bootstrap Dashboard PRO by Creative Tim" />
    <meta property="og:type" content="article" />
    <meta property="og:url" content="http://demos.creative-tim.com/light-bootstrap-dashboard-pro/examples/dashboard.html" />
    <meta property="og:image" content="http://s3.amazonaws.com/creativetim_bucket/products/34/original/opt_lbd_pro_thumbnail.jpg"/>
    <meta property="og:description" content="Forget about boring dashboards, get an admin template designed to be simple and beautiful." />
    <meta property="og:site_name" content="Creative Tim" />


    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!--  Light Bootstrap Dashboard core CSS    -->
    <link href="css/light-bootstrap-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href='css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>
    <link href="css/pe-icon-7-stroke.css" rel="stylesheet" />

</head>
<body>
 <jsp:useBean id="users" class="model.Users" scope="session" />
<div class="wrapper">
    <div class="sidebar" data-color="orange" data-image="../assets/img/full-screen-image-3.jpg">
        <!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->

        <div class="logo">
            <a href="admin.jsp" class="logo-text">
                Team11
            </a>
        </div>
		<div class="logo logo-mini">
			<a href="admin.jsp" class="logo-text">
				T11
			</a>
		</div>

    	<div class="sidebar-wrapper">

            <div class="user">
                <div class="photo">
                    <img src="picture/default-avatar.png" />
                </div>
                <div class="info">
                    <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                   
                        <%=users.getUsername() %>                        
                        <b class="caret"></b>
                    </a>
                    <div class="collapse" id="collapseExample">
                        <ul class="nav">
                           <li><a href="pages/login.jsp">Login</a></li>
                            <li><a href="LogOut">Logout</a></li>
                            <li><a href="admin.jsp">Settings</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <ul class="nav">
                <li>
                    <a href="admin.jsp">
                        <i class="pe-7s-graph"></i>
                        <p>Manage User</p>
                    </a>
                </li>
                <li>
                    <a href="productViewServlet">
                        <i class="pe-7s-plugin"></i>
                        <p>Manage Products</p>
                    </a>
                   
                </li>

                <li>
                    <a href="supplierViewServlet">
                        <i class="pe-7s-note2"></i>
                        <p>Manage Supplier</p>
                    </a>                   
                </li>
                <li>
                    <a href="reorderViewServlet">
                         <i class="pe-7s-graph1"></i>
                        <p>Reorder</p>
                    </a>
                </li>

                <li>
                    <a href="reportViewServlet">
                         <i class="pe-7s-news-paper"></i>
                        <p>Print Report</p>
                    </a>
                </li>

                <li>
                    <a  href="email.jsp">
                        <i class="pe-7s-mail"></i>
                        <p>Sent Email
                          
                        </p>
                    </a>
                   
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
				<div class="navbar-minimize">
					<button id="minimizeSidebar" class="btn btn-warning btn-fill btn-round btn-icon">
						<i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i>
						<i class="fa fa-navicon visible-on-sidebar-mini"></i>
					</button>
				</div>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Stokist</a>
                </div>
                <div class="collapse navbar-collapse">

                    <form class="navbar-form navbar-left navbar-search-form" role="search">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" value="" class="form-control" placeholder="Search...">
                        </div>
                    </form>

                    <ul class="nav navbar-nav navbar-right">
                       
                        <li class="dropdown dropdown-with-icons">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-list"></i>
                                <p class="hidden-md hidden-lg">
    								More
    								<b class="caret"></b>
    							</p>
                            </a>
                            <ul class="dropdown-menu dropdown-with-icons">
                                <li>
                                    <a href="admin.jsp">
                                        <i class="pe-7s-graph"></i> Manage User
                                    </a>
                                </li>
                                <li>
                                    <a href="productViewServlet">
                                        <i class="pe-7s-plugin"></i> Manage Products
                                    </a>
                                </li>
                                <li>
                                    <a href="supplierViewServlet">
                                        <i class="pe-7s-note2"></i> Manage Supplier
                                    </a>
                                </li>
                                <li>
                                    <a href="reorderViewServlet">
                                        <i class="pe-7s-graph1"></i> Reorder
                                    </a>
                                </li>
                                <li>
                                    <a href="reportViewServlet">
                                        <i class="pe-7s-news-paper"></i> Print Report
                                    </a>
                                </li>
                                <li>
                                    <a href="admin.jsp">
                                        <i class="pe-7s-tools"></i> Settings
                                    </a>
                                </li>
                                <li class="divider"></li>
                              
                                <li>
                                    <a href="LogOut" class="text-danger">
                                        <i class="pe-7s-close-circle"></i>
                                        Log out
                                    </a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>

        <div class="content">
        
        <!-- Main Content in put here -->
        <!-- Main Content in put here -->
          <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content">
                            
                                <form action="userUpdateServlet" method="post" name="userForm">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Role</label>
                                                <input type="text" name="role" class="form-control" disabled placeholder="Role" value="<%=users.getRole() %>"/>
                                                <input type="hidden" name="role" class="form-control" placeholder="Role" value="<%=users.getRole() %>"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Username</label>                                                
                                                <input type="text" name="userName" class="form-control" placeholder="UserName" value="<%=users.getUsername() %>" />
                                        
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Email address</label>
                                                <input type="text" name="email" class="form-control" placeholder="Email" value = "<%=users.getEmail() %>" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input type="text" name="firstName" class="form-control" placeholder="First Name" value="<%=users.getFirstname()%>"/>
                                                
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Last Name</label>
                                                <input type="text" name="lastName" class="form-control" placeholder="Last Name" value="<%=users.getLastname()%>"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" name="address" class="form-control" placeholder="Home Address" value="<%=users.getAddress() %>"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Password</label>
                                                <input type="text" name="password" class="form-control" placeholder="Password" value="<%=users.getPassword() %>"/>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>PhoneNumber</label>
                                                <input type="text" name="phoneNumber" class="form-control" placeholder="PhoneNumber" value="<%=users.getPhonenumber() %>" />
                                            </div>
                                        </div>
                                       <div class="col-md-4">
                                            <div class="form-group">
                                                
                                               <input type="hidden" name="userID" class="form-control" placeholder="userID" value="<%=users.getUserID() %>"/>  
                                            </div>
                                        </div>
                                    </div>

                               

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>About Me</label>
                                                <textarea type="text" name="description" rows="5" class="form-control" placeholder="Here can be your description" value="Here can be your description"><%=users.getDescription() %></textarea>
                                            </div>
                                        </div>
                                    </div>
                                        

                                    <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <img src="picture/full-screen-image-3.jpg" alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                     <a href="#">
                                    <img class="avatar border-gray" src="picture/default-avatar.png" alt="..."/>

                                      <h4 class="title"><%=users.getUsername() %><br />
                                         <small><%=users.getLastname() %> <%=users.getFirstname()%></small>
                                      </h4>
                                    </a>
                                </div>
                                <p class="description text-center"> "<%=users.getDescription()%>"
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i></button>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
         <!-- Main Content in put here -->
         <!-- Main Content in put here -->
         
        </div>

        <footer class="footer">
            <div class="container-fluid">
            
                <p class="copyright pull-right">
                    &copy; 2017 <a href="https://github.com/NUS-ISS-Team11/Team11_Stockist.git">Team11_Stockist</a>, made with love for a better web
                </p>
            </div>
        </footer>


    </div>
</div>

<div class="fixed-plugin">
    <div class="dropdown">
        <a href="#" data-toggle="dropdown">
        <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
            <li class="header-title">Configuration</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Sidebar Image</p>
                    <div class="switch switch-sidebar-image"
                        data-on-label="ON"
                        data-off-label="OFF">
                        <input type="checkbox" checked/>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
			<li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Sidebar Mini</p>
                    <div class="switch  switch-sidebar-mini"
                        data-on-label="ON"
                        data-off-label="OFF">
                        <input type="checkbox"/>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
			<li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Fixed Navbar</p>
                    <div class="switch  switch-navbar-fixed"
                        data-on-label="ON"
                        data-off-label="OFF">
                        <input type="checkbox"/>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Filters</p>
                    <div class="pull-right">
                        <span class="badge filter" data-color="black"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange active" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple" data-color="purple"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Images</li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="picture/full-screen-image-1.jpg">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="picture/full-screen-image-2.jpg">
                </a>
            </li>
            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="picture/full-screen-image-3.jpg">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="picture/full-screen-image-4.jpg">
                </a>
            </li>

            

        </ul>
    </div>
</div>

</body>
<!--   Core JS Files and PerfectScrollbar library inside jquery.ui   -->
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>


	<!--  Forms Validations Plugin -->
	<script src="js/jquery.validate.min.js"></script>

	<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script src="js/moment.min.js"></script>

    <!--  Date Time Picker Plugin is included in this js file -->
    <script src="js/bootstrap-datetimepicker.js"></script>

    <!--  Select Picker Plugin -->
    <script src="js/bootstrap-selectpicker.js"></script>

	<!--  Checkbox, Radio, Switch and Tags Input Plugins -->
	<script src="js/bootstrap-checkbox-radio-switch-tags.js"></script>

	<!--  Charts Plugin -->
	<script src="js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="js/bootstrap-notify.js"></script>

    <!-- Sweet Alert 2 plugin -->
	<script src="js/sweetalert2.js"></script>

    <!-- Vector Map plugin -->
	<script src="js/jquery-jvectormap.js"></script>

    <!--  Google Maps Plugin    -->
    <script src="js/aa743e8f448a4792bad10d201a7080f6.js"></script>

	<!-- Wizard Plugin    -->
    <script src="js/jquery.bootstrap.wizard.min.js"></script>

    <!--  Bootstrap Table Plugin    -->
    <script src="js/bootstrap-table.js"></script>

	<!--  Plugin for DataTables.net  -->
    <script src="js/jquery.datatables.js"></script>


    <!--  Full Calendar Plugin    -->
    <script src="js/fullcalendar.min.js"></script>

    <!-- Light Bootstrap Dashboard Core javascript and methods -->
	<script src="js/light-bootstrap-dashboard.js"></script>

	<!--   Sharrre Library    -->
    <script src="js/jquery.sharrre.js"></script>

	<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
	<script src="js/demo.js"></script>

    <script>
        $().ready(function(){
            demo.initCharts();
        });
    </script>

    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

      ga('create', 'UA-46172202-1', 'auto');
      ga('send', 'pageview');

    </script>

</html>
