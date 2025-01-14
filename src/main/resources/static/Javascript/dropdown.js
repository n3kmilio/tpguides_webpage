document.addEventListener("DOMContentLoaded", function () {
    const dropdownButton = document.getElementById('dropdownButton');
    const dropdownContent = document.getElementById('dropdownContent');

    dropdownButton.addEventListener('click', function () {
        dropdownContent.classList.toggle('show');
    });

    function selectGame(gameName, gameImage) {
        dropdownButton.textContent = gameName;
        dropdownContent.classList.remove('show');
    }

    document.querySelectorAll('.dropdown-item').forEach(item => {
        item.addEventListener('click', function () {
            const gameName = this.textContent.trim();
            const gameImage = this.querySelector('img').src;
            selectGame(gameName, gameImage);
        });
    });

    document.addEventListener('click', function (event) {
        if (!dropdownButton.contains(event.target) && !dropdownContent.contains(event.target)) {
            dropdownContent.classList.remove('show');
        }
    });
});

document.addEventListener('click', function (event) {
    const searchDropdown = document.getElementById('searchDropdown');
    if (!event.target.closest('form')) {
        searchDropdown.style.display = 'none';
    }
});
