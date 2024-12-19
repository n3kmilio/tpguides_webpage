let selectedTags = [];
let guidesData = [];

// Fetch die Guides vom Backend
async function fetchGuides() {
    try {
        const response = await fetch('/api/guides');
        if (response.ok) {
            guidesData = await response.json();
            filterResults();  // Filter die Ergebnisse direkt nach dem Laden
        } else {
            console.error('Fehler beim Abrufen der Guides');
        }
    } catch (error) {
        console.error('Fehler beim Abrufen der Guides:', error);
    }
}

// Aufruf der API, um nach Guides zu suchen
async function searchGuides(searchTerm) {
    try {
        const response = await fetch(`/api/guides/search?searchTerm=${searchTerm}`);
        if (response.ok) {
            guidesData = await response.json();
            filterResults();
        } else {
            console.error('Fehler beim Abrufen der Suchergebnisse');
        }
    } catch (error) {
        console.error('Fehler beim Abrufen der Suchergebnisse:', error);
    }
}

function addTag(tag) {
    if (!selectedTags.includes(tag)) {
        selectedTags.push(tag);
        updateTagUI();
        filterResults();
    }
}

function removeTag(tag) {
    selectedTags = selectedTags.filter(t => t !== tag);
    updateTagUI();
    filterResults();
}

function updateTagUI() {
    const selectedTagsContainer = document.getElementById('selectedTags');
    selectedTagsContainer.innerHTML = '';
    selectedTags.forEach(tag => {
        const tagElement = document.createElement('div');
        tagElement.classList.add('tag');
        tagElement.innerHTML = `${tag} <span onclick="removeTag('${tag}')">&times;</span>`;
        selectedTagsContainer.appendChild(tagElement);
    });
}

function filterResults() {
    const searchTerm = document.getElementById('searchInput').value.toLowerCase();
    const searchResultsContainer = document.getElementById('searchResults');
    const searchOverlay = document.getElementById('searchOverlay');

    searchResultsContainer.innerHTML = '';

    const filteredGuides = guidesData.filter(guide => {
        const matchesSearch = guide.title.toLowerCase().includes(searchTerm) || guide.description.toLowerCase().includes(searchTerm);
        const matchesTags = selectedTags.every(tag => guide.tags.some(guideTag => guideTag.toLowerCase().includes(tag.toLowerCase())));
        return matchesSearch && matchesTags;
    });

    if (filteredGuides.length > 0) {
        filteredGuides.forEach(guide => {
            const guideElement = document.createElement('div');
            guideElement.classList.add('search-item');
            guideElement.innerHTML = `<a href="guide.html?title=${guide.title}"><h4>${guide.title}</h4><p>${guide.description}</p></a>`;
            searchResultsContainer.appendChild(guideElement);
        });

        searchOverlay.style.display = 'flex';
    } else {
        searchOverlay.style.display = 'none';
    }
}

// Beim Laden der Seite Guides abrufen
document.addEventListener('DOMContentLoaded', () => {
    fetchGuides();
});

// Wenn der Benutzer nach Guides sucht, den Suchbegriff verwenden
document.getElementById('searchInput').addEventListener('input', (event) => {
    searchGuides(event.target.value);
});
