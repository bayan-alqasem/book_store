package jo.jordan.JordanBookStore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

@Table(name = "book")
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String name;
	@ManyToMany(mappedBy = "book")
	private List<Store> store = new ArrayList<>();
	public Integer getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	@JsonIgnore
	public List<Store> getStore() {
		return store;
	}


}
