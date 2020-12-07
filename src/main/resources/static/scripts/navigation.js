$(function () {

    let mainContent = $("#main-content");

    $("#nav-bar-links > li > a").on({
        click: function () {
            switch ($.trim($(this).text())) {
                case "个人订阅":
                    mainContent.load("subscription/my");
                    break;
                case "多人订阅":
                    mainContent.load("subscription/multi");
                    break;
                case "我的信息":
                    mainContent.load("user/info");
                    break;
            }
            $(this).parent().addClass("active").siblings().removeClass("active");
            let toggle = $("#nav-bar-toggle")[0];
            if (!toggle.classList.contains("collapsed")) toggle.click();
        }
    });

    $("#main-content > div.cards.single-user > a.panel.panel-default").on({
        click: function () {
            mainContent.load("subscription/info");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

    $("#main-content > div.cards.multi-user > a.panel.panel-default").on({
        click: function () {
            mainContent.load("group/info");
            $("#nav-bar-links").children().removeClass("active");
        }
    });

});