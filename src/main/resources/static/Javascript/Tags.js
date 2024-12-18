document.addEventListener("DOMContentLoaded", function () {
    const availableTags = [
        "Beginner", "Intermediate", "Advanced", "Strategy", "Tips",
        "Walkthrough", "Guide", "Ranked", "Multiplayer", "Singleplayer"
    ];

    const tagInput = document.getElementById("tagInput");
    const selectedTagsContainer = document.getElementById("selectedTags");
    const dropdown = document.getElementById("tagDropdown"); // Ensure this exists in the HTML
    let selectedTags = JSON.parse(localStorage.getItem('selectedTags')) || [];


    selectedTags.forEach(tag => addTag(tag));


    tagInput.addEventListener("input", function () {
        const inputValue = tagInput.value.trim().toLowerCase();
        const suggestions = availableTags.filter(tag =>
            tag.toLowerCase().includes(inputValue)
        );
        showAutocompleteSuggestions(suggestions);
    });

    tagInput.addEventListener("keydown", function (event) {
        if (event.key === "Enter" && tagInput.value.trim() !== "") {
            event.preventDefault();
            addTag(tagInput.value.trim());
        }
    });


    function showAutocompleteSuggestions(suggestions) {
        dropdown.innerHTML = "";
        dropdown.style.display = suggestions.length > 0 ? "block" : "none";

        suggestions.forEach(tag => {
            const suggestionItem = document.createElement("div");
            suggestionItem.className = "dropdown-item"; // Add Bootstrap styling
            suggestionItem.textContent = tag;
            suggestionItem.addEventListener("click", function () {
                addTag(tag);
            });
            dropdown.appendChild(suggestionItem);
        });
    }

    function addTag(tag) {
        if (!selectedTags.includes(tag)) {
            selectedTags.push(tag);
            localStorage.setItem('selectedTags', JSON.stringify(selectedTags));

            const tagElement = document.createElement("div");
            tagElement.className = "tag";
            tagElement.textContent = tag;

            const removeButton = document.createElement("span");
            removeButton.textContent = "×";
            removeButton.className = "remove-tag";
            removeButton.addEventListener("click", function () {
                removeTag(tag);
            });

            tagElement.appendChild(removeButton);
            selectedTagsContainer.appendChild(tagElement);
        }


        tagInput.value = "";
        dropdown.style.display = "none";
    }

    function removeTag(tag) {
        selectedTags = selectedTags.filter(t => t !== tag);
        localStorage.setItem('selectedTags', JSON.stringify(selectedTags));

        const tags = document.querySelectorAll(".tag");
        tags.forEach(tagElement => {
            if (tagElement.textContent.includes(tag)) {
                tagElement.remove();
            }
        });
    }

    document.addEventListener("click", function (event) {
        if (!dropdown.contains(event.target) && event.target !== tagInput) {
            dropdown.style.display = "none";
        }
    });
});
