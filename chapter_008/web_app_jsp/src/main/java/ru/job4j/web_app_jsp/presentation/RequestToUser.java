package ru.job4j.web_app_jsp.presentation;

import ru.job4j.web_app_jsp.model.User;

import javax.servlet.http.HttpServletRequest;

class RequestToUser {
    static User getUserParameters(HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String created = req.getParameter("created");
        return new User(Integer.valueOf(id), name, login, email, created);
    }
}
