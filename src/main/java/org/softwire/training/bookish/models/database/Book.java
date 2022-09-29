package org.softwire.training.bookish.models.database;



public class Book  {
    private String Title;
    private String Author;

    private int bookID;
    private String ISBN;
    private String Category;
    private int Copies;

    public Book() {


    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getCopies() {
        return Copies;
    }

    public void setCopies(int copies) {


        this.Copies = copies;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;

    }
}
