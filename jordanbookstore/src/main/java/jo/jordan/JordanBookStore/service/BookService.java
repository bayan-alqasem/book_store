package jo.jordan.JordanBookStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jo.jordan.JordanBookStore.entity.Book;
import jo.jordan.JordanBookStore.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}
	
}
