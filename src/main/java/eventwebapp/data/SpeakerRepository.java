package eventwebapp.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import eventwebapp.models.Speaker;

@Component
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

	@Query("from speakers where first_name = ?1 and last_name = ?2 and title = ?3")
	List<Speaker> findByFirstLastNameAndTitle(String first_name, String last_name, String title);
}
