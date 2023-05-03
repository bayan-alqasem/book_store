package jo.jordan.JordanBookStore.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jo.jordan.JordanBookStore.entity.Store;
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
	
}
