package trius.springframework.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import trius.springframework.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
