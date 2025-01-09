document.getElementById('publishform').action = '/publish'

document.addEventListener("DOMContentLoaded", function () {
    var publish = document.getElementById("publish");
    var title = document.getElementById("title-input")
    var content = document.getElementById("guide-input")
    publish.addEventListener("click", function () {
        var titletext = title.value;
        var contenttext = content.value;

    });
});