$(function () {
    //移除小组成员
    $("#groupMemberTable > table > tbody > tr > td> a.groupMemberId").on('click', function () {
        let userId = this.dataset.userId;
        let groupId = this.dataset.groupId;
        $.get(
            "group/remove", {userId: userId, groupId: groupId}, function () {
                $("#main-content").load("group/info?groupId=" + groupId, function () {
                    }
                )
            });
    });
    //解散小组
    $("#dissolve").on('click', function () {
        //dissolveId 为需要解散的小组id
        let dissolveId = this.dataset.dissolveId;
        alert("成功解散小组")
        $.get(
            "group/dissolve", {groupId: dissolveId}, function () {
                $("#main-content").load("subscription/multi", function () {
                    }
                )
            });
    });

    //退出小组
    $("#exit").on('click', function () {
        //从哪个小组退出
        let groupId = this.dataset.dissolveId;
        let userId = this.dataset.exitId;
        alert("退出小组成功");
        $.get(
            "group/exit", {userId: userId, groupId: groupId}, function () {
                $("#main-content").load("subscription/multi", function () {
                    }
                )
            });
    });
});
