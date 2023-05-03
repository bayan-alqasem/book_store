package jo.jordan.JordanBookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jo.jordan.JordanBookStore.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);


	

}
