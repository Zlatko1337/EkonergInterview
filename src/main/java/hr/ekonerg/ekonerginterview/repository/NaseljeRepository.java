package hr.ekonerg.ekonerginterview.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.ekonerg.ekonerginterview.entity.Naselje;
import hr.ekonerg.ekonerginterview.entity.Zupanija;

@Repository
public interface NaseljeRepository extends JpaRepository<Naselje, Long> {

	List<Naselje> findByZupanija(Zupanija zupanija);
	
	@Transactional @Modifying
	@Query("UPDATE Naselje n SET n.brojStanovnika = ?1, lastModified = ?2 where id = ?3")	//we can use repository.save(entity) but for demo we do like this
	void updateBrojStanovnikaByIdNaselje(int brojStanovnika, Instant lastModified, long naseljeId);
	

}
