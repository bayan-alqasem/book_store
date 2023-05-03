package jo.jordan.JordanBookStore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


import jo.jordan.JordanBookStore.entity.Book;
import jo.jordan.JordanBookStore.entity.Role;
import jo.jordan.JordanBookStore.entity.Store;
import jo.jordan.JordanBookStore.entity.User;

import jo.jordan.JordanBookStore.repository.BookRepository;
import jo.jordan.JordanBookStore.repository.RoleRepository;
import jo.jordan.JordanBookStore.repository.StoreRepository;
import jo.jordan.JordanBookStore.repository.UserRepository;

@Service
public class DBInit implements CommandLineRunner {

	private BookRepository bookRepository;
	private RoleRepository roleRepository;
	private StoreRepository storeRepository;
	private UserRepository userRepository;

	@Autowired
	public DBInit(BookRepository bookRepository, RoleRepository roleRepository, StoreRepository storeRepository,
			UserRepository userRepository) {
		super();
		this.bookRepository = bookRepository;
		this.roleRepository = roleRepository;
		this.storeRepository = storeRepository;
		this.userRepository = userRepository;

	}

	@Override
	public void run(String... args) throws Exception {

		Role roleAdmin = new Role();
		roleAdmin.setRoleName("ROLE_storeAdmin");
		roleRepository.save(roleAdmin);
		Role roleAdmin1 = new Role();
		roleAdmin1.setRoleName("ROLE_normalUser");
		roleRepository.save(roleAdmin1);

		User admin = new User();
		admin.setUserName("ahmad");
		admin.setPassword("123");
		admin.setActive(1);
		admin.getRoles().add(roleRepository.findById(1).get());

		userRepository.save(admin);

		User admin1 = new User();
		admin1.setUserName("haya");
		admin1.setPassword("234");
		admin1.setActive(1);
		admin1.getRoles().add(roleRepository.findById(1).get());

		userRepository.save(admin1);

		User user = new User();
		user.setUserName("leen");
		user.setPassword("567");
		user.setActive(1);
		user.getRoles().add(roleRepository.findById(2).get());

		userRepository.save(user);

		User user1 = new User();
		user1.setUserName("lana");
		user1.setPassword("789");
		user1.setActive(1);
		user1.getRoles().add(roleRepository.findById(2).get());

		userRepository.save(user1);

		User generalUser = new User();
		generalUser.setUserName("khaled");
		generalUser.setPassword("999");
		generalUser.setActive(1);
		userRepository.save(generalUser);

		User generalUser1 = new User();
		generalUser1.setUserName("mohammad");
		generalUser1.setPassword("888");
		generalUser1.setActive(1);
		userRepository.save(generalUser1);

		Book book1 = new Book();
		book1.setName("arabic");
		bookRepository.save(book1);

		Book book2 = new Book();
		book2.setName("english");
		bookRepository.save(book2);

		Book book3 = new Book();
		book3.setName("math");
		bookRepository.save(book3);

		Book book4 = new Book();
		book4.setName("java");
		bookRepository.save(book4);

		Store store1 = new Store();
		store1.setName("capitalStore");
		store1.getBook().add(book1);
		store1.getBook().add(book2);
		storeRepository.save(store1);

		Store store2 = new Store();
		store2.setName("abcStore");
		store2.getBook().add(book4);
		store2.getBook().add(book3);
		storeRepository.save(store2);

	}

}
