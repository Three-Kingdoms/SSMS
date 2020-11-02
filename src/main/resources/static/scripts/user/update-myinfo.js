
function removeAlert() {
    $("#alert").html("");
    $("#new-nickname-textfield").removeClass("has-error");
    $("#old-password-textfield").removeClass("has-error");
    $("#new-password-textfield").removeClass("has-error");
    $("#repeat-password-textfield").removeClass("has-error");
}

function showAlert(message) {
    $("#alert")[0].innerHTML = `<div class ="alert alert-dismissible alert-danger"><button type="button" class="close" data-dismiss="alert" onclick="removeAlert()">&times;</button>${message}</div>`;
}


$(function(){
    //点击编辑的相关功能
    $("#edit-nickname").on("click",function(){

        const inputBox = $("#update-nickname-input");
        var oldNickname = inputBox.attr("placeholder");

        inputBox.removeAttr("placeholder");
        inputBox.removeAttr("disabled");
        inputBox.attr("value", oldNickname);

        $("#edit-nickname").css("display", "none");
        $("#save-nickname").css("display", "");
    });

    //提交昵称修改
    $("#save-nickname").on("click",function(){

        var newNickname = $("input[name= newNickname]").val();

        if(newNickname === ""){
            showAlert("<p>新昵称不能为空!</p>");
            $("#new-nickname-textfield").addClass("has-error");
        }else {
            $.post("user/updateNickname",{newNickname:newNickname},function(data){
                if(data==="success") {
                    alert("修改成功")
                    $("#my-info").load("user/info");
                }
            });
        }
    });

    //提交密码修改
    $("#save-password").on("click",function(){
        var oldPassword = $("input[name = oldPassword]").val();
        var newPassword = $("input[name = newPassword]").val();
        var repeatPassword = $("input[name = repeatPassword]").val();

        if(oldPassword === "" || newPassword === "" || repeatPassword === ""){
            //判断输入的内容是否为空
            if (oldPassword === "") {
                showAlert("<p>密码不能为空!</p>");
                $("#old-password-textfield").addClass("has-error");
            } else{
                if (newPassword === "") {
                    showAlert("<p>新密码不能为空!</p>");
                    $("#new-password-textfield").addClass("has-error");
                } else {
                    if (repeatPassword === "") {
                        showAlert("<p>请再次输入密码!</p>");
                        $("#repeat-password-textfield").addClass("has-error");
                    }
                }
            }
        }else {
            if (newPassword !== repeatPassword) {
                //判断两次密码是否一样
                showAlert("<p>两次输入的新密码不一致！</p>");
                $("#new-password-textfield").addClass("has-error");
                $("#repeat-password-textfield").addClass("has-error");
            } else{
                $.post("user/updatePassword",{oldPassword:oldPassword, newPassword:newPassword},function(data){

                    if(data==="success"){
                        alert("修改成功");
                        $("#my-info").load("user/info");
                    } else{
                        showAlert("<p>原密码不正确！</p>");
                    }

                });
            }
        }
    });

});


// function updateNickname(oldNickname) {
//
//
//     const update_nickname_input = $("#update-nickname-input");
//     update_nickname_input.removeAttribute("placeholder");
//     update_nickname_input.removeAttribute("disabled");
//     update_nickname_input.setAttribute("value", oldNickname);
//     $("#edit-btn").css("display", "none");
//     $("#save-btn").css("display", "");  }
    // document.getElementById("update-nickname-input").removeAttribute("placeholder");
    // document.getElementById("update-nickname-input").removeAttribute("disabled");
    // document.getElementById("update-nickname-input").setAttribute("value", oldNickname);
    // document.getElementById("edit-btn").style.display = "none";
    // document.getElementById("save-btn").style.display = "";


// function checkEmptyOfNewNickname() {
//     if (document.getElementById("update-nickname-input").value === "") {
//         showAlert("<strong>新昵称</strong>不能为空！");
//         document.getElementById("new-nickname-textfield").classList.add("has-error");
//     } else document.getElementById("update-nickname-form").submit();
//
//     $("#edit-btn").on("click",function(){
//         var newNickname = $("input[name= 'update-nickname-input']").val();
//
//         if(newNickname === ""){
//             showAlert("<strong>新昵称</strong>不能为空！");
//             $("#new-nickname-textfield").addClass("has-error");
//         }else {
//             $.post("user/updateNickname",{newNickname:newNickname},function(data){
//                 alert(data);
//                 $("#my-info").load("info");
//             });
//         }
//     });
// }

// function checkInputOfNewPassword() {
//     const oldPassword = $("#old-password-input");
//     const newPassword = $("#new-password-input");
//     const repeatPassword = $("#repeat-password-input");
//
//     if(oldPassword.val() === "" || newPassword.val() === "" || repeatPassword.val() === ""){
//         showAlert("<strong>密码</strong>不能为空");
//         if (oldPassword.val() === "") {
//             $("#old-password-textfield").addClass("has-error");
//         }
//         if (newPassword.val() === "") {
//             $("#new-password-textfield").addClass("has-error");
//         }
//         if (repeatPassword.val() === "") {
//             $("#repeat-password-textfield").addClass("has-error");
//         }
//     }else if (newPassword.val() !== repeatPassword.val()) {
//         showAlert("两次输入的<strong>新密码</strong>不一致！");
//         $("#new-password-textfield").addClass("has-error");
//         $("#repeat-password-textfield").addClass("has-error");
//     } else document.getElementById("update-password-form").submit();
// }
    // let oldPassword = document.getElementById("old-password-input");
    // let newPassword = document.getElementById("new-password-input");
    // let repeatPassword = document.getElementById("repeat-password-input");
    // if (oldPassword.value === "" || newPassword.value === "" || repeatPassword.value === "") {
    //     showAlert("<strong>密码</strong>不能为空");
    //     if (oldPassword.value === "") {
    //         document.getElementById("old-password-textfield").classList.add("has-error");
    //     }
    //     if (newPassword.value === "") {
    //         document.getElementById("new-password-textfield").classList.add("has-error");
    //     }
    //     if (repeatPassword.value === "") {
    //         document.getElementById("repeat-password-textfield").classList.add("has-error");
    //     }
    // } else if (newPassword.value !== repeatPassword.value) {
    //     showAlert("两次输入的<strong>新密码</strong>不一致！");
    //     document.getElementById("new-password-textfield").classList.add("has-error");
    //     document.getElementById("repeat-password-textfield").classList.add("has-error");
    // } else document.getElementById("update-password-form").submit();



// function showAlert(message) {
//     document.getElementById("alert").innerHTML =
//         '<div class="alert alert-dismissible alert-danger">' +
//         '<button type="button" class="close" data-dismiss="alert" onclick="removeAlert()">&times;</button>' +
//         message +
//         '</div>';
//
// }

// function removeAlert() {
//     document.getElementById("alert").innerHTML = "";
//     document.getElementById("new-nickname-textfield").classList.remove("has-error");
//     document.getElementById("old-password-textfield").classList.remove("has-error");
//     document.getElementById("new-password-textfield").classList.remove("has-error");
//     document.getElementById("repeat-password-textfield").classList.remove("has-error");
//
// }