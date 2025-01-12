document.addEventListener("DOMContentLoaded", function () {
    const dropdownButton = document.getElementById('dropdownButton');
    const dropdownContent = document.getElementById('dropdownContent');

    dropdownButton.addEventListener('click', function () {
        dropdownContent.classList.toggle('show');
    });

    function selectGame(gameName, gameImage) {
        dropdownButton.textContent = gameName;
        dropdownContent.classList.remove('show');

        fetch('/droppie', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({selection: gameName})
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success', data);
            })
            .catch(error => {
                console.log('Error', error)
            })
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
