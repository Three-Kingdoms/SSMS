$(function () {

    $("#subsAccount > div > table > thead > tr > th:last-child > a").on({
        click: function () {
            $("#main-content").load("/subscription/add");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

    $("#modifySubsInfo").on({
        click: function () {
            $("#main-content").load("/subscription/add");
            // $("#nav-bar-links").children().removeClass("active");
        }
    });

});