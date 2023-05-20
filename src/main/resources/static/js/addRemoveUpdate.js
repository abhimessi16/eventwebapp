const speakerModifyTitle = document.getElementById("speakerModifyTitle");
const sessionModifyTitle = document.getElementById("sessionModifyTitle");
const addSpeaker = document.getElementById("addSpeaker");
const deletSpeaker = document.getElementById("deleteSpeaker");
const updateSpeaker = document.getElementById("updateSpeaker");
const addSession = document.getElementById("addSession");
const deleteSession = document.getElementById("deleteSession");
const updateSession = document.getElementById("updateSession");

const speakerSelect = document.getElementById("speakerSelect");
const sessionSelect = document.getElementById("sessionSelect");

const addBtn = document.getElementById("addBtn");
const deleteBtn = document.getElementById("deleteBtn");
const updateBtn = document.getElementById("updateBtn");

function displayTitle(elemId) {
	
	const modifyTitles = document.getElementsByClassName("modifyTitle");
	console.log(modifyTitles);
	for(var i = 0; i < modifyTitles.length; i++){
		modifyTitles[i].style.display = "none";
	}
	
	const modifyForms = document.getElementsByClassName("modifyForm");
	for(var i = 0; i < modifyForms.length; i++){
		modifyForms[i].style.display = "none";
	}
	
	const element = document.getElementById(elemId);
	const displayVal = element.style.display;
	if(displayVal !== "none"){
		element.style.display = "none";
	}else{
		element.style.display = "block";
	}
}

function displayFormUtility(action) {
	
	const modifyForms = document.getElementsByClassName("modifyForm");
	for(var i = 0; i < modifyForms.length; i++){
		modifyForms[i].style.display = "none";
	}
	
	const speakerModifyTitle = document.getElementById("speakerModifyTitle");
	const sessionModifyTitle = document.getElementById("sessionModifyTitle");
	if(speakerModifyTitle.style.display == "block"){
		displayForm(action, "Speaker");
	}else if(sessionModifyTitle.style.display == "block"){
		displayForm(action, "Session");
	}else {
		window.alert("Select speaker/session to modify");
	}
}

function displayForm(action, object) {
	const element = document.getElementById(action + object);
	console.log(element);
	displayVal = element.style.display;
	if(displayVal !== "none"){
		element.style.display = "none";
	}else{
		element.style.display = "block";
	}
}
