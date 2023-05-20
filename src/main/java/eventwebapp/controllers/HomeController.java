package eventwebapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eventwebapp.data.SessionRepository;
import eventwebapp.data.SpeakerRepository;
import eventwebapp.models.Session;
import eventwebapp.models.Speaker;

@Controller
public class HomeController {

	private SpeakerRepository speakerRepository;
	private SessionRepository sessionRepository;
	
	public HomeController(SpeakerRepository speakerRepository, SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
		this.speakerRepository = speakerRepository;
	}
	
	@RequestMapping("/")
	public String homePageOpen(ModelMap modelMap) {
		modelMap.addAttribute("eventName", "My first spring boot project");
		return "index";
	}
	
	@RequestMapping("/sessions")
	public String allSessions(ModelMap modelMap) {
		List<Session> sessions = new ArrayList<>();
		sessions = sessionRepository.findAll();
		modelMap.put("sessions", sessions);
		return "sessions";
	}
	
	@RequestMapping("/sessions/{id}")
	public String showSession(@PathVariable Long id, ModelMap modelMap) {
		Session session = sessionRepository.findById(id).get();
		System.out.println("session details are given as " + session);
		modelMap.put("sess", session);
		return "session-details";
	}
	
	@RequestMapping("/speakers/{id}")
	public String showSpeaker(@PathVariable Long id, ModelMap modelMap) {
		Speaker speaker = speakerRepository.findById(id).get();
		modelMap.put("speaker", speaker);
		return "speaker-details";
	}
	
	@RequestMapping("/speakers")
	public String allSpeakers(ModelMap modelMap) {
		List<Speaker> speakers = new ArrayList<>();
		speakers = speakerRepository.findAll();
		modelMap.put("speakers", speakers);
		return "speakers";
	}
	
	@RequestMapping("/event_modify")
	public String modifyPage() {
		return "add-remove-update";
	}
	
	@PostMapping("/event_modify/add/session")
	public String addSession(Session session) {
		System.out.println("coming here");
		System.out.println("the session name is :" + session.getSession_name());
		sessionRepository.save(session);
		return "redirect:/sessions";
	}
	
	@PostMapping("/event_modify/add/speaker")
	public String addSpeaker(Speaker speaker) {
		System.out.println("coming here");
		System.out.println("the speaker name is :" + speaker.getFirst_name() + " " + speaker.getLast_name());
		speakerRepository.save(speaker);
		return "redirect:/speakers";
	}
	
	@PostMapping("/event_modify/delete/speaker")
	public String deleteSpeaker(String first_name, String last_name, String title) {
		List<Speaker> speakers = speakerRepository.findByFirstLastNameAndTitle(first_name, last_name, title);
		speakerRepository.delete(speakers.get(0));
		return "redirect:/speakers";
	}
	
	@PostMapping("/event_modify/delete/session")
	public String deleteSession(String session_name) {
		List<Session> sessions = sessionRepository.findBySessionName(session_name);
		sessionRepository.delete(sessions.get(0));
		return "redirect:/sessions";
	}
	
	@PostMapping("/event_modify/update/speaker")
	public String updateSpeaker(String first_name, String last_name, String title) {
		List<Speaker> speakers = speakerRepository.findByFirstLastNameAndTitle(first_name, last_name, title);
		speakerRepository.delete(speakers.get(0));
		return "redirect:/speakers";
	}
	
	@PostMapping("/event_modify/update/session")
	public String updateSession(String session_name) {
		List<Session> sessions = sessionRepository.findBySessionName(session_name);
		sessionRepository.delete(sessions.get(0));
		return "redirect:/sessions";
	}
	
}
