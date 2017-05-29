
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.OrderDomainRepository;
import domain.OrderDomain;
import domain.Product;
import domain.ShoppingGroup;
import domain.Status;

@Service
@Transactional
public class OrderDomainService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private OrderDomainRepository	orderRepository;

	// Supporting services ----------------------------------------------------

	@Autowired
	private ProductService			productService;

	@Autowired
	private ShoppingGroupService	shoppingGroupService;


	// Constructors -----------------------------------------------------------

	public OrderDomainService() {
		super();
	}

	//Simple CRUD -------------------------------------------------------------

	public OrderDomain create() {
		OrderDomain res;
		res = new OrderDomain();
		return res;
	}

	public Collection<OrderDomain> findAll() {
		Collection<OrderDomain> res;
		res = this.orderRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public OrderDomain findOne(final int orderId) {
		OrderDomain res;
		res = this.orderRepository.findOne(orderId);
		Assert.notNull(res);
		return res;
	}

	public OrderDomain save(final OrderDomain o) {
		Assert.notNull(o);
		return this.orderRepository.save(o);

	}
	public OrderDomain saveAndFlush(final OrderDomain o) {
		Assert.notNull(o);
		return this.orderRepository.saveAndFlush(o);

	}

	public void delete(final OrderDomain o) {
		Assert.notNull(o);
		this.orderRepository.delete(o);
	}

	//Other business methods --------------------------------------

	public void flush() {
		this.orderRepository.flush();
	}

	public Double numberOfOrderLastMonth() {

		Double p;

		p = this.orderRepository.numberOfOrderLastMonth();

		return p;
	}

	public void markAsAReceived(final OrderDomain order) {
		Assert.notNull(order);

		order.setStatus(Status.RECEIVED);
		order.setFinishDate(new Date());

		final List<Product> ps = new ArrayList<Product>();

		ps.addAll(order.getProducts());

		final Product pr = ps.get(0);

		final ShoppingGroup sh = pr.getShoppingGroupProducts();

		for (final Product p : order.getProducts()) {
			p.setShoppingGroupProducts(null);
			this.productService.saveAndFlush(p);
		}

		sh.setLastOrderDate(null);
		this.shoppingGroupService.save(sh);

	}
}
