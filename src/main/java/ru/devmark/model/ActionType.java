package ru.devmark.model;

public enum ActionType {

    LOGIN(1),
    LOGOUT(2);

    private int id;

    ActionType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ActionType getById(int id) {
        for (ActionType action : values()) {
            if (action.getId() == id) {
                return action;
            }
        }
        throw new RuntimeException("Unknown action type: " + id);
    }
}
