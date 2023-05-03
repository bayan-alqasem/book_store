package jo.jordan.JordanBookStore.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Store")
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_store", joinColumns = { @JoinColumn(name = "store_id") }, inverseJoinColumns = {
			@JoinColumn(name = "book_id") })
	private List<Book> book = new ArrayList<>();

	public Integer getId() {
		return Id;
	}

	public String getName() {
		return name;
	}
	@JsonIgnore
	public List<Book> getBook() {
		return book;
	}

	
}
