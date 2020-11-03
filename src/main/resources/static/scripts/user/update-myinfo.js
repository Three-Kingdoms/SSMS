
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


