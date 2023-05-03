package jo.jordan.JordanBookStore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jo.jordan.JordanBookStore.entity.Book;
import jo.jordan.JordanBookStore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public List<Book> getAllBook() {
		return bookService.getAllBook();
	}

	
}
