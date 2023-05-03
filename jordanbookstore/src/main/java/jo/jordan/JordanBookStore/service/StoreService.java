package jo.jordan.JordanBookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jo.jordan.JordanBookStore.entity.Book;
import jo.jordan.JordanBookStore.entity.Store;

import jo.jordan.JordanBookStore.repository.StoreRepository;

@Service
public class StoreService {
	private StoreRepository storeRepository;

	public StoreService(StoreRepository storeRepository) {
		super();
		this.storeRepository = storeRepository;
	}

	public List<Store> getAllStore() {
		return storeRepository.findAll();
	}

	public Store getStore(Integer Id) {
		return storeRepository.findById(Id).get();
	}

	public List<Book> findAllBookByStoreId(int id) {
		return storeRepository.findById(id).get().getBook();
	}
}
