function updateNickname(oldNickname) {
    document.getElementById("update-nickname-input").removeAttribute("placeholder");
    document.getElementById("update-nickname-input").removeAttribute("disabled");
    document.getElementById("update-nickname-input").setAttribute("value", oldNickname);
    document.getElementById("edit-btn").style.display = "none";
    document.getElementById("save-btn").style.display = "";
}

function checkEmptyOfNewNickname() {
    if (document.getElementById("update-nickname-input").value === "") {
        showAlert("<strong>新昵称</strong>不能为空！");
        document.getElementById("new-nickname-textfield").classList.add("has-error");
    } else document.getElementById("update-nickname-form").submit();
}

function checkInputOfNewPassword() {
    let oldPassword = document.getElementById("old-password-input");
    let newPassword = document.getElementById("new-password-input");
    let repeatPassword = document.getElementById("repeat-password-input");
    if (oldPassword.value === "" || newPassword.value === "" || repeatPassword.value === "") {
        showAlert("<strong>密码</strong>不能为空");
        if (oldPassword.value === "") {
            document.getElementById("old-password-textfield").classList.add("has-error");
        }
        if (newPassword.value === "") {
            document.getElementById("new-password-textfield").classList.add("has-error");
        }
        if (repeatPassword.value === "") {
            document.getElementById("repeat-password-textfield").classList.add("has-error");
        }
    } else if (newPassword.value !== repeatPassword.value) {
        showAlert("两次输入的<strong>新密码</strong>不一致！");
        document.getElementById("new-password-textfield").classList.add("has-error");
        document.getElementById("repeat-password-textfield").classList.add("has-error");
    } else document.getElementById("update-password-form").submit();
}

function showAlert(message) {
    document.getElementById("alert").innerHTML =
        '<div class="alert alert-dismissible alert-danger">' +
        '<button type="button" class="close" data-dismiss="alert" onclick="removeAlert()">&times;</button>' +
        message +
        '</div>';
}

function removeAlert() {
    document.getElementById("alert").innerHTML = "";
    document.getElementById("new-nickname-textfield").classList.remove("has-error");
    document.getElementById("old-password-textfield").classList.remove("has-error");
    document.getElementById("new-password-textfield").classList.remove("has-error");
    document.getElementById("repeat-password-textfield").classList.remove("has-error");
}