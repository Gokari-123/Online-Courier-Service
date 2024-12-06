package Online.Courier.Service.Repository;

import Online.Courier.Service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   // User findByUserName(String userName);
   @Query("SELECT u FROM User u WHERE u.username = :username")
   User findByUserName(@Param("username") String username);
}
