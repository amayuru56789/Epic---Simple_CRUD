/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("#btnSave").click(function (){
    //console.log("Hello"); 
    registrationUser();
});

function registrationUser(){
    var data = $("#registerForm").serialize(); //get information txtFields using form data
    /*console.log(data);*/
    /*----------------------ajax for saveCustomer function---------------------------*/
    $.ajax({
       url: "http://localhost:8084/SimpleCrud/Registration",
       method: "POST",
       data:data, //if we send data with the request
       success:function (res){
           if (res.status==200){
               alert(res.message);
               //loadAllCustomers();
           }else {
               alert(res.data);
           }
           /*console.log(res.message);*/
       },
        error:function (ob,textStatus, error){
           alert(textStatus);
        }
    });
}

