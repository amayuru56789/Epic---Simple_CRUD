/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("#btnLog").click(function (){
//   console.log("Hello"); 
    var userID = $("#userID").val();
    var password = $("#password").val();
    
//    console.log(userName+" :"+password);
    obj = {
        userID:userID,
        password:password
    }

//invoked ajax
    $.ajax({
        url: 'http://localhost:8084/SimpleCrud/Login',
        method: 'POST',
        //async: true,
        //data: {"userName":userName,"password":password},
        data:JSON.stringify(obj),
        //dataType: json,
        success: function (res){
            console.log(res);
            if (res.status==200){
                alert("Success");
                window.location = "ViewUser.jsp"
            }else{
                alert("User name or password incorrect");
            }
        }
    });
});

