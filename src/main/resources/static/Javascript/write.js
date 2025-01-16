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
            const gameName = this.textContent.trim(); // Get the game name from the selected item
            const gameImage = this.querySelector('img').src; // Get the image source (optional)

            // Update the button text and hide the dropdown
            selectGame(gameName, gameImage);

            // Send a POST request to the server with the selected game name
            fetch(`/api/write/search?gameName=${encodeURIComponent(gameName)}`, {
                method: 'POST', // You can change this to 'POST' if necessary
                headers: {
                    'Content-Type': 'application/json',
                },
                body: gameName
            })
                .then(response => response.json()) // Assuming the server returns JSON
                .then(data => {
                    console.log('Game data received:', data);
                })
                .catch(error => {
                    console.error('Error fetching game data:', error);
                });
        });
    });

    document.addEventListener('click', function (event) {
        if (!dropdownButto.contains(event.target) && !dropdownConten.contains(event.target)) {
            dropdownConten.classList.remove('show');
        }
    });
});
