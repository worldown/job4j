package ru.job4j.strong_mvc.persistent;

import ru.job4j.strong_mvc.model.Role;
import ru.job4j.strong_mvc.model.User;

import java.util.List;

/**
 * This interface responsible for CRUD operation on Memory, DB, File
 * Define persistent layer, interact with Logic layer.
 *
 * @author Kosolapov Ilya (d_dexter@mail.ru)
 * @version $id
 * @since 0.1
 */
public interface Store {
    void add(User user);

    void update(User user);

    void delete(User user);

    List<User> findAll();

    User findById(User user);

    boolean ifExist(User user);

    List<Role> getRoles();
}
