package nt.uzumnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nt.uzumnt.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
