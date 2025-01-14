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

    function getGame(){
        const Game = dropdownButto.value;

        fetch('/dropdownButto', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({selection: Game})
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success', data);
            })
            .catch(error => {
                console.log('Error', error)
            })

    }
    document.getElementById('publish').addEventListener('click',function(){
        getGame();
    });

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
