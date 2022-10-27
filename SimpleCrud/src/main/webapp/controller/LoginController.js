/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("#btnLog").click(function (){
//   console.log("Hello"); 
    var userName = $("#userName").val();
    var password = $("#password").val();
    
//    console.log(userName+" :"+password);

//invoked ajax
    $.ajax({
        url: 'http://localhost:8084/SimpleCrud/Login',
        method: 'GET',
        async: true,
        data: {"userName":userName,"password":password},
        dataType: json,
        success: function (response, textState, xhr){
            console.log(response);
            
        }
    });
});

