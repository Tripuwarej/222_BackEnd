package sit.int221.oasip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sit.int221.oasip.Entity.User;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {
//    @Transactional
//    @Modifying
//    @Query("DELETE FROM User u WHERE u.id=:id")
//    int delete(@Param("id") int id, @Param("userId") int userId);

}
