package kabbee.miu.videostreamingproject.repository;

import kabbee.miu.videostreamingproject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
