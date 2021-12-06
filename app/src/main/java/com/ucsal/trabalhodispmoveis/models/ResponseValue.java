package com.ucsal.trabalhodispmoveis.models;

import com.google.gson.annotations.SerializedName;
import com.ucsal.trabalhodispmoveis.models.Book;

import java.util.List;

public class ResponseValue {
    private String status;
    private int code;
    private String total;
    @SerializedName("data")
    private List<Book> books;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", total='" + total + '\'' +
                ", books=" + books +
                '}';
    }
}
