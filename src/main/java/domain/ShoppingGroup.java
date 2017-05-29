
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
@Table(indexes = {

	@Index(columnList = "category_id"), @Index(columnList = "private_group"), @Index(columnList = "creator_id"), @Index(columnList = "puntuation"), @Index(columnList = "freePlaces")

})
public class ShoppingGroup extends DomainEntity {

	//Constructor ------------------------------------

	public ShoppingGroup() {
		super();
	}


	//Attributes --------------------------------------

	private boolean	private_group;
	private String	name;
	private String	description;
	private Date	lastOrderDate;
	private int		freePlaces;
	private String	site;
	private int		puntuation;


	//Getters and Setters ------------------------------

	public boolean isPrivate_group() {
		return this.private_group;
	}

	public void setPrivate_group(final boolean private_group) {
		this.private_group = private_group;
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getLastOrderDate() {
		return this.lastOrderDate;
	}

	public void setLastOrderDate(final Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	@Min(0)
	public int getFreePlaces() {
		return this.freePlaces;
	}

	public void setFreePlaces(final int freePlaces) {
		this.freePlaces = freePlaces;
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getSite() {
		return this.site;
	}

	public void setSite(final String site) {
		this.site = site;
	}

	public int getPuntuation() {
		return this.puntuation;
	}

	public void setPuntuation(final int puntuation) {
		this.puntuation = puntuation;
	}


	//Relationships

	private Collection<User>		users;
	private Collection<Product>		products;
	private Collection<Comment>		comments;
	private Category				category;
	private User					creator;
	private Collection<Punctuation>	punctuations;


	@OneToMany(mappedBy = "shoppingGroup")
	public Collection<Punctuation> getPunctuations() {
		return this.punctuations;
	}

	public void setPunctuations(final Collection<Punctuation> punctuations) {
		this.punctuations = punctuations;
	}

	@ManyToOne(optional = false)
	@Valid
	public User getCreator() {
		return this.creator;
	}

	public void setCreator(final User creator) {
		this.creator = creator;
	}

	@ManyToMany
	@Valid
	public Collection<User> getUsers() {
		return this.users;
	}

	public void setUsers(final Collection<User> users) {
		this.users = users;
	}

	@OneToMany(mappedBy = "shoppingGroupProducts")
	@Valid
	public Collection<Product> getProducts() {
		return this.products;
	}

	public void setProducts(final Collection<Product> products) {
		this.products = products;
	}

	@OneToMany(mappedBy = "shoppingGroupComments")
	@Valid
	public Collection<Comment> getComments() {
		return this.comments;
	}

	public void setComments(final Collection<Comment> comments) {
		this.comments = comments;
	}

	@ManyToOne(optional = true)
	@Valid
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

}
