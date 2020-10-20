$(function () {

    $("#subsAccount > div > table > thead > tr > th:last-child > a").on({
        click: function () {
            $("#main-content").load("/subscription/info");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

});