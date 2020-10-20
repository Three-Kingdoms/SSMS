$(function () {

    $("#main-content > div.cards.multi-user > a.panel.panel-default").on({
        click: function () {
            $("#main-content").load("/group/info");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

});