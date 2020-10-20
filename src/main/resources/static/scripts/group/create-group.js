function formatForm() {
    if (document.querySelector("#groupType-multi-radio").checked) {
        document.querySelector("#service-multi-form").style.display = "";
        document.querySelector("#subs-multi-select").setAttribute("name", "serviceId");
        let subsMultiForms = document.getElementsByClassName("subs-multi-form");
        for (let index = 0; index < subsMultiForms.length; index++) {
            subsMultiForms[index].style.display = "";
        }
        let subsMultiSelect = document.getElementsByClassName("subs-multi-select");
        for (let index = 0; index < subsMultiSelect.length; index++) {
            subsMultiSelect[index].setAttribute("name", "subsAccount");
        }
        let subsSingleForms = document.getElementsByClassName("subs-single-form");
        for (let index = 0; index < subsSingleForms.length; index++) {
            subsSingleForms[index].style.display = "none";
        }
        let subsSingleSelect = document.getElementsByClassName("subs-single-select");
        for (let index = 0; index < subsSingleSelect.length; index++) {
            subsSingleSelect[index].removeAttribute("name");
        }
        let multiOptions = document.querySelector("#subs-multi-select").options;
        for (let index = 0; index < multiOptions.length; index++) {
            if (multiOptions[index].selected) {
                document.querySelector("#subs-multi-id" + multiOptions[index].value + "-form").style.display = "";
                document.querySelector("#subsAccount-multi-id" + multiOptions[index].value + "-select").setAttribute("name", "subsAccount");
            } else {
                document.querySelector("#subs-multi-id" + multiOptions[index].value + "-form").style.display = "none";
                document.querySelector("#subsAccount-multi-id" + multiOptions[index].value + "-select").removeAttribute("name");
            }
        }
        document.querySelector("#service-single-form").style.display = "none";
        document.querySelector("#subs-single-select").removeAttribute("name");
    } else if (document.querySelector("#groupType-single-radio").checked) {
        document.querySelector("#service-multi-form").style.display = "none";
        document.querySelector("#subs-multi-select").removeAttribute("name");
        let subsMultiForms = document.getElementsByClassName("subs-multi-form");
        for (let index = 0; index < subsMultiForms.length; index++) {
            subsMultiForms[index].style.display = "none";
        }
        let subsMultiSelect = document.getElementsByClassName("subs-multi-select");
        for (let index = 0; index < subsMultiSelect.length; index++) {
            subsMultiSelect[index].removeAttribute("name");
        }
        let subsSingleForms = document.getElementsByClassName("subs-single-form");
        for (let index = 0; index < subsSingleForms.length; index++) {
            subsSingleForms[index].style.display = "";
        }
        let subsSingleSelect = document.getElementsByClassName("subs-single-select");
        for (let index = 0; index < subsSingleSelect.length; index++) {
            subsSingleSelect[index].setAttribute("name", "subsAccount");
        }
        let singleOptions = document.querySelector("#subs-single-select").options;
        for (let index = 0; index < singleOptions.length; index++) {
            if (singleOptions[index].selected) {
                document.querySelector("#subs-single-id" + singleOptions[index].value + "-form").style.display = "";
                document.querySelector("#subsAccount-single-id" + singleOptions[index].value + "-select").setAttribute("name", "subsAccount");
            } else {
                document.querySelector("#subs-single-id" + singleOptions[index].value + "-form").style.display = "none";
                document.querySelector("#subsAccount-single-id" + singleOptions[index].value + "-select").removeAttribute("name");
            }
        }
        document.querySelector("#service-single-form").style.display = "";
        document.querySelector("#subs-single-select").setAttribute("name", "serviceId");
    }
}

function validateNum(num) {
    return /^\+?[1-9][0-9]*$/.test(num.value);
}

function checkForm() {

    if (document.querySelector("#groupName-input").value === "" || document.querySelector("#maxMember-input").value === "") {
        showAlert("请完成表单填写！");
        if (document.querySelector("#groupName-input").value === "") {
            document.querySelector("#groupName-form").classList.add("has-warning");
        }
        if (document.querySelector("#maxMember-input").value === "") {
            document.querySelector("#maxMember-form").classList.add("has-warning");
        }
    } else if (document.querySelector("#groupType-multi-radio").checked &&
        document.querySelector("#subsAccount-multi-id" + document.querySelector("#subs-multi-select").value + "-select").value === "-1") {
        showAlert("没有该类型服务对应的订阅账号！<br/>请在“我的信息-订阅信息”中添加。");
    } else if (document.querySelector("#groupType-single-radio").checked &&
        document.querySelector("#subsAccount-single-id" + document.querySelector("#subs-single-select").value + "-select").value === "-1") {
        showAlert("没有该类型服务对应的订阅账号！<br/>请在“我的信息-订阅信息”中添加。");
    } else if (!validateNum(document.querySelector("#maxMember-input"))) {
        showAlert("小组人数请填写大于等于 1 的整数！");
        document.querySelector("#maxMember-input").classList.add("has-warning");
    } else {
        document.querySelector("#create-group-form").submit();
    }
}

function showAlert(message) {
    document.querySelector("#alert").innerHTML =
        '<div class="alert alert-dismissible alert-warning">' +
        '<a class="close" data-dismiss="alert" onclick="removeAlert()">&times;</a>' +
        message +
        '</div>';
}

function removeAlert() {
    document.querySelector("#alert").innerHTML = "";
    document.querySelector("#groupName-form").classList.remove("has-warning");
    document.querySelector("#maxMember-form").classList.remove("has-warning");
}