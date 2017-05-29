
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {

	//Constructors -------------------------------------

	public Comment() {
		super();
	}


	//Attributes ------------------------------------

	private String	title;
	private String	text;
	private Date	moment;


	//Getters and Setters --------------------------

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getText() {
		return this.text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}


	//Relationships

	private ShoppingGroup	shoppingGroupComments;
	private User			userComment;


	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public User getUserComment() {
		return this.userComment;
	}

	public void setUserComment(final User userComment) {
		this.userComment = userComment;
	}

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	public ShoppingGroup getShoppingGroupComments() {
		return this.shoppingGroupComments;
	}

	public void setShoppingGroupComments(final ShoppingGroup shoppingGroupComments) {
		this.shoppingGroupComments = shoppingGroupComments;
	}

}
