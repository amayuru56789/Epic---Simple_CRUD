<%-- 
    Document   : Login
    Created on : 27-Oct-2022, 15:12:05
    Author     : indee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/styles.css"/>
        <link rel="stylesheet" href="assets/fonts/css/all.min.css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
<!--        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
    </head>
    <body>
        <div class="banner" style="background-color: #2d3436">
        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <div class="card-header">
                        <h1>Log In</h1>
                        <div class="d-flex justify-content-end social_icon">
                            <span><i class="fa-brands fa-square-github"></i></span>
                            <span><i class="fab fa-google-plus-square"></i></span>
                            <span><i class="fab fa-twitter-square"></i></span>
                        </div>
                    </div>
                    
                    <div class="card-body">
                        <form>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="User name" id="userName">
                            </div>
                            
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" placeholder="password" id="password">
                            </div>
                            
                            <div class="row align-items-center remember">
                                <input type="checkbox"> Remember Me
                            </div>
                            <div class="form-group">
                                <input type="button" value="Login" class="btn float-right login_btn" id="btnLog">
                            </div>
                        </form>
                    </div>
                    
                    <div class="card-footer">
                        <div class="d-flex justify-content-center links">
                            IF You Don't have an Account?
                        </div>
                        <div class="rights">
                            <small>Created By AVC</small>
                        </div>
                        <div class="lines">
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        
        <script src="assets/jQuery/jquery-3.6.0.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="controller/LoginController.js"></script>
    </body>
</html>
