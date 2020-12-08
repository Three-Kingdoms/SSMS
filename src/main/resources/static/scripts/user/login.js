$(function () {
    $("#form").on("submit", function (ev) {
        $.post("user/verify/login", $("#form").serialize(), function (data) {
            switch (data) {
                case "error":
                    showAlert("用户名或密码错误");
                    $("#username-textfield").addClass("has-error");
                    $("#password-textfield").addClass("has-error");
                    break;
                case "success":
                    window.location.href = "index";
                    break;
            }
        });
        ev.preventDefault();
    });

    $("#buttons > a.btn-register").on("click", function () {
        $(".login-container > .wrapper").load("register-page");
    });
});


// function checkEmpty() {
//     if (document.getElementById("username").value === "" || document.getElementById("password").value === "") {
//         showAlert("<strong>用户名</strong>或<strong>密码</strong>不能为空！");
//         if (document.getElementById("username").value === "") {
//             document.getElementById("username-textfield").classList.add("has-error");
//         }
//         if (document.getElementById("password").value === "") {
//             document.getElementById("password-textfield").classList.add("has-error");
//         }
//     } else document.getElementById("form").submit();
// }

function showAlert(message) {
    document.getElementById("alert").innerHTML =
        '<div class="alert alert-dismissible alert-danger">' +
        '<a class="close" data-dismiss="alert" onclick="removeAlert()">&times;</a>' +
        message +
        '</div>';
}

function removeAlert() {
    document.getElementById("username-textfield").classList.remove("has-error");
    document.getElementById("password-textfield").classList.remove("has-error");
}