let selectedTags = [];
let guidesData = [];

async function fetchGuides() {
    try {
        const response = await fetch('/api/guides');
        if (response.ok) {
            guidesData = await response.json();
        } else {
            console.error('Fehler beim Abrufen der Guides');
        }
    } catch (error) {
        console.error('Fehler beim Abrufen der Guides:', error);
    }
}

async function searchGuides(searchTerm) {
    try {
        const response = await fetch(`/api/guides/search?searchTerm=${searchTerm}`);
        if (response.ok) {
            guidesData = await response.json();
            filterResultsDropdown();
        } else {
            console.error('Fehler beim Abrufen der Suchergebnisse');
        }
    } catch (error) {
        console.error('Fehler beim Abrufen der Suchergebnisse:', error);
    }
}



function filterResultsDropdown() {
    fetchGuides();

    const searchTerm = document.getElementById('searchInput').value.toLowerCase();
    const searchDropdown = document.getElementById('searchDropdown');

    searchDropdown.innerHTML = '';

    const filteredGuides = guidesData.filter(guide => {
        const matchesSearch = guide.title.toLowerCase().includes(searchTerm) || guide.description.toLowerCase().includes(searchTerm);
        const matchesTags = selectedTags.every(tag => guide.tags.some(guideTag => guideTag.toLowerCase().includes(tag.toLowerCase())));
        return matchesSearch && matchesTags;
    });

    if (filteredGuides.length > 0) {
        searchDropdown.style.display = 'block';

        filteredGuides.forEach(guide => {
            const guideElement = document.createElement('div');
            guideElement.classList.add('dropdown-item');
            guideElement.innerHTML = `<a href="guide.html?title=${encodeURIComponent(guide.title)}">${guide.title}</a>`;

            guideElement.addEventListener('click', function () {
                document.getElementById('searchInput').value = guide.title;
                searchDropdown.style.display = 'none';
            });

            searchDropdown.appendChild(guideElement);
        });
    } else {
        searchDropdown.style.display = 'none';
    }

}

function getResultsOnInput(event) {
    if (event) event.preventDefault();
    const inputInDoc = document.getElementById("searchInput").value;
    if (!inputInDoc) {
        localStorage.setItem('inputSave', inputInDoc)
        window.location.href = 'index.html';
    }
}