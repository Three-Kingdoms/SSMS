$(function () {

    $("#subsAccount > div > table > thead > tr > th:last-child > a").on({
        click: function () {
            $("#main-content").load("/subscription/add");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

    $("#subsAccount > div > table > tbody > tr > td > a.modify").on("click", function () {
        let subsId = this.dataset.subsId;
        $("#main-content").load("/subscription/modify-page?subsId=" + subsId, function () {
            // $("#nav-bar-links").children().removeClass("active");
            // $("#nav-bar-links > li:nth-child(3)").addClass("active");
            // $("#tab-groupType > a")[0].click();
        });

    });

    $("#subsAccount > div > table > tbody > tr > td > a.remove").on("click", function () {
        let subsId = this.dataset.subsId;
        $.post("subscription/remove", {subsId: subsId}, function () {
            $("#main-content").load("/user/info", function () {
                $("#nav-bar-links").children().removeClass("active");
                $("#nav-bar-links > li:nth-child(3)").addClass("active");
                $("#tab-groupType > a")[0].click();
            });
        });

    });

    $("#modifySubsInfo").on({
        click: function () {
            $("#main-content").load("/subscription/add");
        }
    });

});
