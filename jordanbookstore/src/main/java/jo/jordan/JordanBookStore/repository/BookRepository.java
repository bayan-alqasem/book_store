package jo.jordan.JordanBookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jo.jordan.JordanBookStore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer > {

}
