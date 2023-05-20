package eventwebapp.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name="sessions")
public class Session {

	// i wonder if there's a way to query the first value that isn't used
	// and does identity give the last used 'primary key + 1'
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long session_id;
	private String session_name;
	private int session_length;
	private String session_description;
	
//	@ManyToMany
//	@JoinTable(
//			name = "session_speakers",
//			joinColumns = @JoinColumn(name = "session_id"),
//			inverseJoinColumns = @JoinColumn(name = "speaker_id"))
//	private List<Speaker> speakers;
	
	public Session() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getSession_id() {
		return session_id;
	}
	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}
	public String getSession_name() {
		return session_name;
	}
	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}
	public int getSession_length() {
		return session_length;
	}
	public void setSession_length(int session_length) {
		this.session_length = session_length;
	}
	public String getSession_description() {
		return session_description;
	}
	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}
	
	
	
}
