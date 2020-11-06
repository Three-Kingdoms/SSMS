$(function () {

    let mainContent = $("#main-content");

    $("#main-content > div.cards.multi-user > a.panel.panel-default").on({
        click: function () {
            var groupId = this.dataset.group;
            mainContent.load("/group/info?groupId=" + groupId);
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