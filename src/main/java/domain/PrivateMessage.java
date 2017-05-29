
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
@Table(indexes = {

	@Index(columnList = "copy")

})
public class PrivateMessage extends DomainEntity {

	//Constructor ---------------------------------------------------------

	public PrivateMessage() {
		super();
	}


	//Attributes ------------------------------------------------------------

	private Date	moment;

	private String	subject;

	private String	text;

	private String	attachments;

	private boolean	copy;


	public boolean isCopy() {
		return this.copy;
	}

	public void setCopy(final boolean copy) {
		this.copy = copy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getMoment() {

		return this.moment;

	}

	public void setMoment(final Date moment) {

		this.moment = moment;

	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getSubject() {

		return this.subject;

	}

	public void setSubject(final String subject) {

		this.subject = subject;

	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getText() {

		return this.text;

	}

	public void setText(final String text) {

		this.text = text;

	}

	@URL
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getAttachments() {

		return this.attachments;

	}

	public void setAttachments(final String attachments) {

		this.attachments = attachments;

	}


	//Relationships --------------------------------------------------------------------------------------

	private Actor	sender;

	private Actor	recipient;


	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Actor getSender() {

		return this.sender;

	}

	public void setSender(final Actor sender) {

		this.sender = sender;

	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Actor getRecipient() {

		return this.recipient;

	}

	public void setRecipient(final Actor recipient) {

		this.recipient = recipient;

	}

}
