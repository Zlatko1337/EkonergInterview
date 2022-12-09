package hr.ekonerg.ekonerginterview.entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Zupanija {

	@Id
	private long id;

	private String naziv;

	@LastModifiedDate
	private Instant lastModified;

	@OneToMany(mappedBy = "zupanija", cascade = CascadeType.ALL)
	private List<Naselje> naselja;

}
