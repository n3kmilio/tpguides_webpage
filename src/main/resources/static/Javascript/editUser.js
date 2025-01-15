const editButton = document.getElementById("editButton");
const saveButton = document.getElementById("saveButton");
const paragraph = document.getElementById("editableText");
const textarea = document.getElementById("textEditor");

editButton.addEventListener("click", () => {
   textarea.value = paragraph.textContent;
   paragraph.classList.add("hidden");
   textarea.classList.remove("hidden");
   saveButton.classList.remove("hidden");
   editButton.classList.add("hidden");
});

saveButton.addEventListener("click", () => {
    document.getElementById('descriptionForm').submit();
    paragraph.textContent = textarea.value;
    paragraph.classList.remove("hidden");
    textarea.classList.add("hidden");
    saveButton.classList.add("hidden");
    editButton.classList.remove("hidden");
});