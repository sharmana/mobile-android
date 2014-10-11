package com.sharmana.db.dto;

/**
 * Created by strusov on 12.10.2014.
 */
public class UserDTO {
//    {"_id":"54397ff8e4b0631360f4e264","yandex_id":"281831812","name":"sharmana","email":"sharmana@yandex.ru"}

    private String _id;
    private String yandex_id;
    private String name;
    private String email;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getYandex_id() {
        return yandex_id;
    }

    public void setYandex_id(String yandex_id) {
        this.yandex_id = yandex_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
