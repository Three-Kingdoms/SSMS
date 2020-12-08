$(function () {
    $("#form").on("submit", function (ev) {
        $.post("user/verify/register", $("#form").serialize(), function (data) {
            switch (data) {
                case "error":
                    showAlert("该账户名已存在");
                    $("#username-textfield").addClass("has-error");
                    break;
                case "success":
                    $(".login-container > .wrapper").load("login-page", alert("注册成功，请登录。"));
                    break;
            }
        });
        ev.preventDefault();
    });

    $("#buttons > a.btn-link").on("click", function () {
        $(".login-container > .wrapper").load("login-page");
    });
});

// function checkEmpty() {
//     if (document.getElementById("username").value === "" ||
//         document.getElementById("nickname").value === "" ||
//         document.getElementById("password").value === "") {
//         showAlert("<strong>用户名</strong>、<strong>昵称</strong>或<strong>密码</strong>不能为空！");
//         if (document.getElementById("username").value === "") {
//             document.getElementById("username-textfield").classList.add("has-error");
//         }
//         if (document.getElementById("nickname").value === "") {
//             document.getElementById("nickname-textfield").classList.add("has-error");
//         }
//         if (document.getElementById("password").value === "") {
//             document.getElementById("password-textfield").classList.add("has-error");
//         }
//     } else document.getElementById("form").submit();
// }

function showAlert(message) {
    document.getElementById("alert").innerHTML =
        '<div class="alert alert-dismissible alert-danger">' +
        '<button type="button" class="close" data-dismiss="alert" onclick="removeAlert()">&times;</button>' +
        message +
        '</div>';
}

function removeAlert() {
    document.getElementById("alert").innerHTML = "";
    document.getElementById("username-textfield").classList.remove("has-error");
    document.getElementById("nickname-textfield").classList.remove("has-error");
    document.getElementById("password-textfield").classList.remove("has-error");
}
