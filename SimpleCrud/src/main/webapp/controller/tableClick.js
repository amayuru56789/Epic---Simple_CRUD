/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#table").click(function (e) {
    let userId = $(e.target).closest('tr').find('td').eq(0).html();
    let userName = $(e.target).closest('tr').find('td').eq(1).html();
    let address = $(e.target).closest('tr').find('td').eq(2).html();
    let email = $(e.target).closest('tr').find('td').eq(3).html();
    let contact = $(e.target).closest('tr').find('td').eq(4).html();
    let password = $(e.target).closest('tr').find('td').eq(5).html();

    $("#txtUserId").val(userId);
    $("#txtUserName").val(userName);
    $("#txtUserAddress").val(address);
    $("#txtEmail").val(email);
    $("#txtContact").val(contact);
    $("#txtPassword").val(password);
});
