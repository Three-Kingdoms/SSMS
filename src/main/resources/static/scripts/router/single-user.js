$(function () {

    let mainContent = $("#main-content");

    $("#groupDropdown > ul.dropdown-menu > li.add-subscription > a").on({
        click: function () {
            mainContent.load("/subscription/add");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

    $("#groupDropdown > ul.dropdown-menu > li.manage-subscription > a").on({
        click: function () {
            mainContent.load("/user/info", function () {
                $("#nav-bar-links").children().removeClass("active");
                $("#nav-bar-links > li:nth-child(3)").addClass("active");
                $("#tab-groupType > a")[0].click();
            });
        }
    });

    $("#main-content > div.cards.single-user > a.panel.panel-default").on({
        click: function () {
            let subsId = this.dataset.subsId;
            mainContent.load("/subscription/info?subsId=" + subsId);
            $("#nav-bar-links").children().removeClass("active");
        }
    });

});