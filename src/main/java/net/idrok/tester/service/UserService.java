package net.idrok.tester.service;

import net.idrok.tester.entity.User;

import java.util.Optional;

public interface UserService extends CommonService<User> {
    Optional<User> getByLogin(String login);
}
