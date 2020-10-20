function check() {
    if (document.getElementById("subsAccount").value === "") {
        showAlert("<strong>订阅账号</strong>不能为空！");
        document.getElementById("SubsAccount-textfield").classList.add("has-error");
    } else {
        if (document.getElementById("startTime").value === "" && document.getElementById("endTime").value === "") {
            document.getElementById("add-usersubs-form").submit();
        } else {
            if (document.getElementById("startTime").value === "" || document.getElementById("endTime").value === "") {
                if (document.getElementById("startTime").value !== "" || document.getElementById("endTime").value === "") {
                    showAlert("<strong>请输入完整的时间</strong>");
                    document.getElementById("endTime-textfield").classList.add("has-error");
                }
                if (document.getElementById("startTime").value === "" || document.getElementById("endTime").value !== "") {
                    showAlert("<strong>请输入完整的时间</strong>");
                    document.getElementById("startTime-textfield").classList.add("has-error");
                }
            } else document.getElementById("add-usersubs-form").submit();
        }
    }

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
    document.getElementById("SubsAccount-textfield").classList.remove("has-error");
    document.getElementById("startTime-textfield").classList.remove("has-error");
    document.getElementById("endTime-textfield").classList.remove("has-error");
}
