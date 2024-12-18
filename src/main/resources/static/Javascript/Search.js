const guidesData = [
    { title: "Draven Tutorial", description: "How to master Draven in League of Legends", game: "League of Legends", tags: ["ADC", "Draven", "Mechanics", "Overon"] },
    { title: "Briars Feet", description: "A detailed Guide about Briars Feet", game: "League of Legends", tags: ["Champion lore", "Briar", "lildio"] },
    { title: "Jett Guide", description: "Complete guide to Jett in Valorant", game: "Valorant", tags: ["Agent", "Jett", "Gameplay"] },
    { title: "Counter-Strike 2 Strategies", description: "Top strategies for Counter-Strike 2", game: "Counter-Strike", tags: ["Strategy", "CS2", "Tactics", "GrafGrafowitz"] },
    { title: "Inferno Smokes", description: "Effective smokes in CS:GO's Inferno map", game: "Counter-Strike", tags: ["Smokes", "Inferno", "CSGO", "Skywalker"] },
    { title: "Breeze Smokes", description: "Smokes for Breeze in Valorant", game: "Valorant", tags: ["Smokes", "Breeze", "Utility"] }
];



let selectedTags = [];

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




