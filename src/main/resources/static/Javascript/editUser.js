const editButton = document.getElementById("editButton");
const saveButton = document.getElementById("saveButton");
const paragraph = document.getElementById("editableText");
const textarea = document.getElementById("textEditor");
const usernameInput = document.getElementById("usernameEditor");
const usernameDisplay = document.getElementById("usernameDisplay");

editButton.addEventListener("click", () => {
   textarea.value = paragraph.textContent;
   usernameInput.textContent = usernameDisplay.textContent;
   paragraph.classList.add("hidden");
   textarea.classList.remove("hidden");
   saveButton.classList.remove("hidden");
   editButton.classList.add("hidden");
   usernameInput.classList.remove("hidden");
   usernameDisplay.classList.add("hidden");
});

saveButton.addEventListener("click", () => {
    document.getElementById('descriptionForm').submit();
    usernameDisplay.textContent = usernameInput.textContent;
    paragraph.textContent = textarea.value;
    paragraph.classList.remove("hidden");
    textarea.classList.add("hidden");
    saveButton.classList.add("hidden");
    editButton.classList.remove("hidden");
    usernameInput.classList.add("hidden");
    usernameDisplay.classList.remove("hidden")
});