package com.example.nipc26.librarymanagement.model;

import java.io.Serializable;

/**
 * Created by NI PC 26 on 10/27/2016.
 */

public class BookModel implements Serializable{
    public String bookId;
    public String bookName;
    public String bookType;
    public String price;
    public String edition;
    public String copied;
    public String bookBarcode;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getCopied() {
        return copied;
    }

    public void setCopied(String copied) {
        this.copied = copied;
    }

    public String getBookBarcode() {
        return bookBarcode;
    }

    public void setBookBarcode(String bookBarcode) {
        this.bookBarcode = bookBarcode;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookType='" + bookType + '\'' +
                ", price='" + price + '\'' +
                ", edition='" + edition + '\'' +
                ", copied='" + copied + '\'' +
                ", bookBarcode='" + bookBarcode + '\'' +
                '}';
    }
}
