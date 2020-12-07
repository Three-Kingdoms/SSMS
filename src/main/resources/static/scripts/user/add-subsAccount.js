$(function () {

    let singleServiceForm = $("#single-serviceName-form");
    let multiServiceForm = $("#multi-serviceName-form");
    let subscriptionNameForm = $("#subscriptionName-form");
    let dateForm = $("#date-form");

    // function removeAlert() {
    //     // $("#alert").html("");
    //     singleServiceForm.removeClass("has-error");
    //     multiServiceForm.removeClass("has-error");
    //     subscriptionNameForm.removeClass("has-error");
    //     dateForm.removeClass("has-error");
    // }

    function showAlert(message) {
        $("#alert")[0].innerHTML = `<div class ="alert alert-dismissible alert-danger"><button type="button" class="close" data-dismiss="alert" onclick="removeAlert()">&times;</button>${message}</div>`;
    }

    $("#radio-single").on("click", function () {
        singleServiceForm.css("display", "");
        multiServiceForm.css("display", "none");
    });
    $("#radio-multi").on("click", function () {
        singleServiceForm.css("display", "none");
        multiServiceForm.css("display", "");
    });

    $("#createSubs").on("click",function (){
        let subsName = $("input[name = subscriptionName]").val();
        let serviceType = $("input[name = subscriptionType]:checked").val();
        let serviceId = serviceType === "single" ? $('select[name = singleServiceName] option:selected').val() : $('select[name = multiServiceName] option:selected').val();
        let startTime = $("input[name = startTime]").val();
        if (startTime !== "" ) startTime += "T00:00";
        let endTime = $("input[name = endTime]").val();
        if ((endTime !== "")) endTime += "T00:00";
        let description = $("textarea[name = note]").val();
        console.log(subsName + " - " + serviceId + " - " + startTime + " - " + endTime + " - " + description);
        if (serviceId === "-1") {
            if (serviceType === "single") {
                singleServiceForm.addClass("has-error");
            } else if (serviceType === "multi") {
                multiServiceForm.addClass("has-error");
            }
            showAlert("请选择服务！");
        } else if (subsName === "") {
            subscriptionNameForm.addClass("has-error");
            showAlert("请输入账号！");
        } else if (startTime === "" || endTime === "") {
            showAlert("请输入开始时间和结束时间！");
            dateForm.addClass("has-error");
        } else {
            $.post("subscription/create", {
                subsAccount: subsName, service: serviceId, startTime: startTime,
                endTime: endTime, description: description
            }, function (data) {
                if (data === "success") $("#main-content").load("subscription/my");
            });
        }
    });

    $("#form-button > div > a.btn.btn-default").on("click", function () {
        $("#nav-bar-links > li:nth-child(2) > a").click();

    });

});






// function check() {
//     if (document.getElementById("subsAccount").value === "") {
//         showAlert("<strong>订阅账号</strong>不能为空！");
//         document.getElementById("SubsAccount-textfield").classList.add("has-error");
//     } else {
//         if (document.getElementById("startTime").value === "" && document.getElementById("endTime").value === "") {
//             document.getElementById("add-usersubs-form").submit();
//         } else {
//             if (document.getElementById("startTime").value === "" || document.getElementById("endTime").value === "") {
//                 if (document.getElementById("startTime").value !== "" || document.getElementById("endTime").value === "") {
//                     showAlert("<strong>请输入完整的时间</strong>");
//                     document.getElementById("endTime-textfield").classList.add("has-error");
//                 }
//                 if (document.getElementById("startTime").value === "" || document.getElementById("endTime").value !== "") {
//                     showAlert("<strong>请输入完整的时间</strong>");
//                     document.getElementById("startTime-textfield").classList.add("has-error");
//                 }
//             } else document.getElementById("add-usersubs-form").submit();
//         }
//     }
//
// }




// function showAlert(message) {
//     document.getElementById("alert").innerHTML =
//         '<div class="alert alert-dismissible alert-danger">' +
//         '<button type="button" class="close" data-dismiss="alert" onclick="removeAlert()">&times;</button>' +
//         message +
//         '</div>';
// }
//
// function removeAlert() {
//     document.getElementById("alert").innerHTML = "";
//     document.getElementById("SubsAccount-textfield").classList.remove("has-error");
//     document.getElementById("startTime-textfield").classList.remove("has-error");
//     document.getElementById("endTime-textfield").classList.remove("has-error");
// }
