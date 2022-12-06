package com.example.Clinica_Odontologica.model;

public class ResponseJson {
    private String message;
    private Object data;

    public ResponseJson(String message, Object data) {
        this.message = message;
        this.data = data;
    }
    public ResponseJson(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
