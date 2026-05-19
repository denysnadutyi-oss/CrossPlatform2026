import java.io.*;
import java.util.*;

class Author implements Serializable {
    private String name;
    public Author() {}
    public Author(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override public String toString() { return "Author{name='" + name + "'}"; }
}

class Book implements Serializable {
    private String title;
    private Author author;
    public Book() {}
    public Book(String title, Author author) { this.title = title; this.author = author; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    @Override public String toString() { return "Book{title='" + title + "', author=" + author + "}"; }
}

class Bookshelf implements Serializable {
    private List<Book> books = new ArrayList<>();
    public Bookshelf() {}
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
    public void addBook(Book book) { books.add(book); }
    @Override public String toString() { return "Bookshelf{" + books + "}"; }
}

class Reader implements Serializable {
    private String name;
    public Reader() {}
    public Reader(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override public String toString() { return "Reader{name='" + name + "'}"; }
}

class Rent implements Serializable {
    private Book book;
    private Reader reader;
    public Rent() {}
    public Rent(Book book, Reader reader) { this.book = book; this.reader = reader; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Reader getReader() { return reader; }
    public void setReader(Reader reader) { this.reader = reader; }
    @Override public String toString() { return "Rent{book=" + book + ", reader=" + reader + "}"; }
}

class Library implements Serializable {
    private Bookshelf bookshelf = new Bookshelf();
    private List<Reader> readers = new ArrayList<>();
    private List<Rent> rents = new ArrayList<>();
    public Library() {}
    public Bookshelf getBookshelf() { return bookshelf; }
    public void setBookshelf(Bookshelf bookshelf) { this.bookshelf = bookshelf; }
    public List<Reader> getReaders() { return readers; }
    public void setReaders(List<Reader> readers) { this.readers = readers; }
    public List<Rent> getRents() { return rents; }
    public void setRents(List<Rent> rents) { this.rents = rents; }
    public void addReader(Reader reader) { readers.add(reader); }
    public void rentBook(Book book, Reader reader) { rents.add(new Rent(book, reader)); }
    @Override public String toString() { return "Library{\n bookshelf=" + bookshelf + ",\n readers=" + readers + ",\n rents=" + rents + "\n}"; }
}