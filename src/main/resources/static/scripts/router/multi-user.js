$(function () {

    let mainContent = $("#main-content");

    $("#main-content > div.cards.multi-user > a.panel.panel-default").on({
        click: function () {
            mainContent.load("/group/info");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

    $("#groupDropdown > ul.dropdown-menu > li.add-subscription > a").on({
        click: function () {
            mainContent.load("/group/add");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

});