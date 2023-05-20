package eventwebapp.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import eventwebapp.models.Session;

@Component
public interface SessionRepository extends JpaRepository<Session, Long> {

	@Query("select s from sessions s where s.session_name = :sessionName")
	List<Session> findBySessionName(@Param("sessionName") String sessionName);
}
