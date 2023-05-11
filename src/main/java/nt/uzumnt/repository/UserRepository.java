package nt.uzumnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nt.uzumnt.model.Users;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findFirstByPhoneNumber(String phoneNumber);
    Optional<Users> findFirstByPhoneNumberAndIsActive(String phoneNumber, Short isActive);
    Optional<Users> findFirstByIdAndIsActive(Integer id, Short isActive);
}
