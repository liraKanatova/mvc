package peaksoft.repository;

import peaksoft.entity.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);
    User getUserById(Long id);
    List<User>getAllUsers();
    void updateUser(Long id,User user);
    void deleteUserById(Long id);
    List<User>searchUser(String word);
}
