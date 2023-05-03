package jo.jordan.JordanBookStore.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import jo.jordan.JordanBookStore.entity.Book;
import jo.jordan.JordanBookStore.entity.Store;
import jo.jordan.JordanBookStore.service.StoreService;

@RestController
public class StoreController {

	private StoreService storeService;

	public StoreController(StoreService storeService) {
		super();
		this.storeService = storeService;
	}

	@GetMapping("/stores")
	public List<Store> getAllStore() {
		return storeService.getAllStore();
	}

	@GetMapping("/stores/{Id}")
	public Store getStore(@PathVariable Integer Id) {
		return storeService.getStore(Id);
	}
	@GetMapping("/stores/{id}/books")
	public List<Book> getAllBookByStoreId(@PathVariable int id) {
	return storeService.findAllBookByStoreId(id);
	}
}
