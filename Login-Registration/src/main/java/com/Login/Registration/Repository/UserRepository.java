package com.Login.Registration.Repository;

import com.Login.Registration.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByEmailIdAndPassword(String emailId,String password);
}
