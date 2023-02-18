package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import login.User;

/**
 * This will allow you to use Spring's built-in methods for CRUD operations on the User entity.
 * 
 * @author raman
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUsername(String username);
	User findByEmail(String email);
}
