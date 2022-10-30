/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
loadAllUsers();
/*--------------------------------loadAllUsers function for javaEE app------------------------------------*/
function loadAllUsers() {

    /*invoked ajax for send a request*/
    $("#userTable").empty();
    $.ajax({
       url:"http://localhost:8084/SimpleCrud/Registration",
       method:"GET",
        //convert to json format
       dataType:"json",
       success:function (res){
           for (const user of res) {
               /*console.log(user.userID);*/
               let row = `<tr><td>${user.userID}</td><td>${user.userName}</td><td>${user.address}</td><td>${user.email}</td><td>${user.contact}</td><td>${user.password}</td></tr>`;
               $("#userTable").append(row);
           }
       }
    });
}

