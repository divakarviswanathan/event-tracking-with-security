package pep.diva.trackevents.eventtracking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author divakar
 *
 */
@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "created_by", columnDefinition = "VARCHAR(64)", nullable = false)
	private String createdBy;

	@Column(name = "event_about", columnDefinition = "VARCHAR(64)")
	private String eventAbout;

	@Column(name = "event_description", columnDefinition = "VARCHAR(256)")
	private String eventDescription;

	@Column(name = "event_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;

	public long getId() {
		return id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getEventAbout() {
		return eventAbout;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setEventAbout(String eventAbout) {
		this.eventAbout = eventAbout;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
}
