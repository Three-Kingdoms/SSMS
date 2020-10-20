function showBasicInformation() {
    document.getElementById("tab-groupType").classList.remove("active");
    document.getElementById("tab-groupType").getElementsByTagName("a")[0].ariaExpanded = false;
    document.getElementById("tab-groupId").classList.add("active");
    document.getElementById("tab-groupId").getElementsByTagName("a")[0].ariaExpanded = true;
    document.getElementById("subsAccount").classList.remove("active", "in");
    document.getElementById("basicInformation").classList.add("active", "in");
}

function showSubsAccount() {
    document.getElementById("tab-groupId").classList.remove("active");
    document.getElementById("tab-groupId").getElementsByTagName("a")[0].ariaExpanded = false;
    document.getElementById("tab-groupType").classList.add("active");
    document.getElementById("tab-groupType").getElementsByTagName("a")[0].ariaExpanded = true;
    document.getElementById("basicInformation").classList.remove("active", "in");
    document.getElementById("subsAccount").classList.add("active", "in");
}