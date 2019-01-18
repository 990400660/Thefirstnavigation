package com.example.pc.thefirstnavigation.beans;

public class BaseDemo<T> {
    private int code;
    private String message;
    private T data;

    public BaseDemo(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return data;
    }

    public void setT(T data) {
        this.data = data;
    }

   /* @Override
    public String toString() {
        return "BaseDemo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", t=" + t +
                '}';
    }*/
}
