package project.bmigenerator.Repository;

import org.springframework.data.repository.CrudRepository;
import project.bmigenerator.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
