package ru.devmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.devmark.dao.UserActionDao;
import ru.devmark.model.UserAction;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserActionDao userActionDao;

    @PostMapping("/actions")
    @ResponseStatus(HttpStatus.CREATED)
    public void writeAction(@Valid @RequestBody UserAction request) {
        userActionDao.addAction(request.getActionDate(), request.getUserId(), request.getAction());
    }

    @GetMapping("/{userId}/action/history")
    public List<UserAction> getUserActionHistory(
            @PathVariable("userId") int userId,
            @RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo
    ) {
        return userActionDao.getUserActionHistory(userId, dateFrom, dateTo);
    }
}
