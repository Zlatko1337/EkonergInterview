package hr.ekonerg.ekonerginterview.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Naselje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String naselje;

	private int brojStanovnika;

	@LastModifiedDate
	private Instant lastModified;

	@ManyToOne
	@JoinColumn(name = "zupanija_Id")
	private Zupanija zupanija;

}
