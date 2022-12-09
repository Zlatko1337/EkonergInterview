package hr.ekonerg.ekonerginterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hr.ekonerg.ekonerginterview.entity.Zupanija;

@Repository
public interface ZupanijaRepository extends JpaRepository<Zupanija, Long> {

	@Query(nativeQuery=true, 
			value = "SELECT z.ID, z.NAZIV FROM ZUPANIJA z \r\n"
					+ "RIGHT JOIN \r\n"
					+ "(\r\n"
					+ "	SELECT SUM(BROJ_STANOVNIKA) as BROJ_STANOVNIKA, ZUPANIJA_ID FROM NASELJE GROUP BY ZUPANIJA_ID ORDER BY BROJ_STANOVNIKA DESC LIMIT 3\r\n"
					+ ") as n\r\n"
					+ "on z.ID = n.ZUPANIJA_ID")
	List<Zupanija> findZupanijeOrderedByBrojStanovnika();

}
