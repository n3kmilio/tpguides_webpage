document.addEventListener("DOMContentLoaded", function () {
    const dropdownButto = document.getElementById('dropdownButto');
    const dropdownConten = document.getElementById('dropdownConten');

    dropdownButto.addEventListener('click', function () {
        dropdownConten.classList.toggle('show');
    });

    function selectGame(gameName, gameImage) {
        dropdownButto.textContent = gameName;
        dropdownConten.classList.remove('show');
    }

    document.querySelectorAll('.dropdown-item').forEach(item => {
        item.addEventListener('click', function () {
            const gameName = this.textContent.trim();
            const gameImage = this.querySelector('img').src;
            selectGame(gameName, gameImage);
        });
    });

    document.addEventListener('click', function (event) {
        if (!dropdownButto.contains(event.target) && !dropdownConten.contains(event.target)) {
            dropdownConten.classList.remove('show');
        }
    });
});
