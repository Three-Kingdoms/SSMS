$(function (){

    let ServiceForm = $("#serviceName-form");
    let subscriptionNameForm = $("#subscriptionName-form");

    function removeAlert() {
        $("#alert").html("");
        ServiceForm.removeClass("has-error");
        subscriptionNameForm.removeClass("has-error");
        $("#startTime-textfield").removeClass("has-error");
        $("#endTime-textfield").removeClass("has-error");
    }

    function showAlert(message) {
        $("#alert")[0].innerHTML = `<div class ="alert alert-dismissible alert-danger"><button type="button" class="close" data-dismiss="alert" onclick="removeAlert()">&times;</button>${message}</div>`;
    }

    $("#modifySubs").on("click",function (){
        let id = this.dataset.subsId;
        let subsAccount = $("input[name = subscriptionName]").val();
        let serviceId = $('select[name = serviceName] option:selected').val();
        let startTime = $("input[name = startTime]").val();
        if (startTime !== "" ) startTime += "T00:00";
        let endTime = $("input[name = endTime]").val();
        if ((endTime !== "")) endTime += "T00:00";
        let description = $("textarea[name = note]").val();
        if (subsAccount === "") {
            subscriptionNameForm.addClass("has-error");
            showAlert("请输入账号！");
        } else {
            $.post("subscription/modify",{id:id, subsAccount:subsAccount, service:serviceId, startTime:startTime,
                endTime:endTime, description:description}, function (data) {
                if(data==="success") $("#main-content").load("/user/info", function () {
                    $("#nav-bar-links").children().removeClass("active");
                    $("#nav-bar-links > li:nth-child(3)").addClass("active");
                    $("#tab-groupType > a")[0].click();
                });
            });
        }
    });
});
