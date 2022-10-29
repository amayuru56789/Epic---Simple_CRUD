<%-- 
    Document   : SignUp
    Created on : 27-Oct-2022, 23:36:50
    Author     : indee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp Page</title>
    </head>
    <body>
        <div class="container">
            <div class="justify-content-center">
                <div class="user-card">
                    <div class="card-header">
                        <h1>Sign Up</h1>
                    </div>
                    
                    <div class="card-body">
                        <form class="form-horizontal" id="registerForm" action="#">
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">User ID</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-solid fa-image-portrait"></i></span>
                                        <input type="text" class="form-control" name="name" id="txtuserID" placeholder="Enter your ID">
                                    </div>
                                </div>
                            </div>
                            
<!--                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">User ID</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-solid fa-image-portrait"></i></span>
                                        <input type="text" class="form-control" name="name" id="userID" placeholder="Enter your ID">
                                    </div>
                                </div>
                            </div>-->
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">User Name</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-solid fa-image-portrait"></i></span>
                                        <input type="text" class="form-control" name="name" id="txtuserName" placeholder="Enter your Name">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Address</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-solid fa-image-portrait"></i></span>
                                        <input type="text" class="form-control" name="name" id="txtaddress" placeholder="Enter your Address">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Email</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-solid fa-image-portrait"></i></span>
                                        <input type="text" class="form-control" name="name" id="txtemail" placeholder="Enter your Email">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">User Contact</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-solid fa-image-portrait"></i></span>
                                        <input type="text" class="form-control" name="name" id="txtcontact" placeholder="Enter your Mobile No">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Password</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa-solid fa-image-portrait"></i></span>
                                        <input type="text" class="form-control" name="name" id="txtpassword" placeholder="Enter your Password">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <button type="button" id="btnSave" class="btn btn-primary btn-lg btn-block login-button">Sign Up</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/jQuery/jquery-3.6.0.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="controller/SignUpController.js"></script>
    </body>
</html>
