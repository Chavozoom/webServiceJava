package com.chavozo.webservice;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chavozo.webservice.domain.Address;
import com.chavozo.webservice.domain.Category;
import com.chavozo.webservice.domain.City;
import com.chavozo.webservice.domain.Client;
import com.chavozo.webservice.domain.Order;
import com.chavozo.webservice.domain.Payment;
import com.chavozo.webservice.domain.PaymentsWithBankSlip;
import com.chavozo.webservice.domain.PaymentsWithCard;
import com.chavozo.webservice.domain.Product;
import com.chavozo.webservice.domain.State;
import com.chavozo.webservice.domain.enums.ClientType;
import com.chavozo.webservice.domain.enums.PaymentState;
import com.chavozo.webservice.repositories.AddressRepository;
import com.chavozo.webservice.repositories.CategoryRepository;
import com.chavozo.webservice.repositories.CityRepository;
import com.chavozo.webservice.repositories.ClientRepository;
import com.chavozo.webservice.repositories.OrderRepository;
import com.chavozo.webservice.repositories.PaymentRepository;
import com.chavozo.webservice.repositories.ProductRepository;
import com.chavozo.webservice.repositories.StateRepository;

@SpringBootApplication
public class WebserviceApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String[] args) throws Exception {
		Category cat1 = new Category(null, "Office");
		Category cat2 = new Category(null, "House");

		Product prod1 = new Product(null, "Laptop", 2100.00);
		Product prod2 = new Product(null, "Chair", 210.00);
		Product prod3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));

		prod1.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat2));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		State state1 = new State(null, "Boston");
		State state2 = new State(null, "New York");

		City city1 = new City(null, "Cambridge", state1);
		City city2 = new City(null, "New York", state2);
		City city3 = new City(null, "Buffalo", state2);

		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2, city3));

		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));

		Client client1 = new Client(null, "John", "john@gmail.com", "123456789", ClientType.INDIVIDUAL);
		client1.getPhones().addAll(Arrays.asList("1991948282", "19919482822"));

		Address address1 = new Address(null, "12", "baker street", "123456789", client1, "Bronks", city2);
		Address address2 = new Address(null, "123", "street baker", "987654123", client1, "Bronks 2", city2);

		client1.getAddresses().addAll(Arrays.asList(address1, address2));

		clientRepository.saveAll(Arrays.asList(client1));
		addressRepository.saveAll(Arrays.asList(address1, address2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Order order1 = new Order(null, sdf.parse("30/09/2023 10:30"), client1, address1);
		Order order2 = new Order(null, sdf.parse("25/09/2020 10:30"), client1, address2);

		Payment payment1 = new PaymentsWithCard(null, PaymentState.COMPLETED, order1, 6);
		order1.setPayment(payment1);

		Payment payment2 = new PaymentsWithBankSlip(null, PaymentState.PENDENT, order2, sdf.parse("25/10/2020 10:30"),
				null);

		client1.getOrders().addAll(Arrays.asList(order1, order2));

		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
		orderRepository.saveAll(Arrays.asList(order1, order2));

	}

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

}
