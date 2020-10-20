function showSearchBox() {
    document.getElementById("tab-groupType").classList.remove("active");
    document.getElementById("tab-groupType").getElementsByTagName("a")[0].ariaExpanded = false;
    document.getElementById("tab-groupId").classList.add("active");
    document.getElementById("tab-groupId").getElementsByTagName("a")[0].ariaExpanded = true;
    document.getElementById("search-type").classList.remove("active", "in");
    document.getElementById("search-box").classList.add("active", "in");
}

function showSearchType() {
    document.getElementById("tab-groupId").classList.remove("active");
    document.getElementById("tab-groupId").getElementsByTagName("a")[0].ariaExpanded = false;
    document.getElementById("tab-groupType").classList.add("active");
    document.getElementById("tab-groupType").getElementsByTagName("a")[0].ariaExpanded = true;
    document.getElementById("search-box").classList.remove("active", "in");
    document.getElementById("search-type").classList.add("active", "in");
}

function checkEmpty() {
    if (document.getElementById('search-input').value === '') {
        showAlert('组号不能为空！');
        document.getElementById('search-field').classList.add("has-warning");
    } else {
        // removeAlert();
        document.getElementById('search-form').submit();
    }
}

function showAlert(message) {
    document.getElementById('alert').innerHTML =
        '<div class="alert alert-dismissible alert-warning">' +
        '<a class="close" data-dismiss="alert">&times;</a>' +
        message +
        '</div>';
}

// function removeAlert() {
//     document.getElementById('alert').innerHTML = '';
//     document.getElementById('search-field').classList.remove("has-warning");
// }
function showServices() {
    if (document.getElementById('select').options[0].selected) {
        document.getElementById('services-multi').style.display = 'block';
        document.getElementById('services-single').style.display = 'none';
    }
    if (document.getElementById('select').options[1].selected) {
        document.getElementById('services-multi').style.display = 'none';
        document.getElementById('services-single').style.display = 'block';
    }
    // document.getElementsByClassName('search-result')[1].innerHTML = '';
}