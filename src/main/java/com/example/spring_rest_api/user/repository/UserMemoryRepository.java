package com.example.spring_rest_api.user.repository;

import com.example.spring_rest_api.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class UserMemoryRepository {
    private final Map<Long, User> userStorage = new ConcurrentHashMap<>();

    public User create(User user) {
        return userStorage.put(user.getUserId(), user);
    }

    public User findById(Long userId) {
        return userStorage.get(userId);
    }

    public User update(Long userId, User user) {
        return userStorage.put(userId, user);
    }

    public User delete(Long userId) {
        User deleted = userStorage.get(userId).delete();
        return userStorage.put(userId, deleted);
    }
}
