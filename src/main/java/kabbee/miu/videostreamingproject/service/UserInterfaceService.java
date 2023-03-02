package kabbee.miu.videostreamingproject.service;

import kabbee.miu.videostreamingproject.domain.User;

public interface UserInterfaceService {
    User register(User user);
    User findById(Long id);

}
