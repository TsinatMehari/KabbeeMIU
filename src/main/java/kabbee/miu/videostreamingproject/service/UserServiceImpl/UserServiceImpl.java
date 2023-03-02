package kabbee.miu.videostreamingproject.service.UserServiceImpl;

import kabbee.miu.videostreamingproject.domain.User;
import kabbee.miu.videostreamingproject.repository.UserRepository;
import kabbee.miu.videostreamingproject.service.UserInterfaceService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
//@RequiredArgsConstructor
public class UserServiceImpl implements UserInterfaceService {

   private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public User register(User user) {
     return  userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
