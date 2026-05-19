import java.io.*;
import java.util.*;

class Author implements Externalizable {
    private String name;
    public Author() {}
    public Author(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override public void writeExternal(ObjectOutput out) throws IOException { out.writeUTF(name); }
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { name = in.readUTF(); }
    @Override public String toString() { return "Author{name='" + name + "'}"; }
}

class Book implements Externalizable {
    private String title;
    private Author author;
    public Book() {}
    public Book(String title, Author author) { this.title = title; this.author = author; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    @Override public void writeExternal(ObjectOutput out) throws IOException { out.writeUTF(title); out.writeObject(author); }
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { title = in.readUTF(); author = (Author) in.readObject(); }
    @Override public String toString() { return "Book{title='" + title + "', author=" + author + "}"; }
}

class Bookshelf implements Externalizable {
    private List<Book> books = new ArrayList<>();
    public Bookshelf() {}
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
    public void addBook(Book book) { books.add(book); }
    @Override public void writeExternal(ObjectOutput out) throws IOException { out.writeObject(books); }
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { books = (List<Book>) in.readObject(); }
    @Override public String toString() { return "Bookshelf{" + books + "}"; }
}

class Reader implements Externalizable {
    private String name;
    public Reader() {}
    public Reader(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override public void writeExternal(ObjectOutput out) throws IOException { out.writeUTF(name); }
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { name = in.readUTF(); }
    @Override public String toString() { return "Reader{name='" + name + "'}"; }
}

class Rent implements Externalizable {
    private Book book;
    private Reader reader;
    public Rent() {}
    public Rent(Book book, Reader reader) { this.book = book; this.reader = reader; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Reader getReader() { return reader; }
    public void setReader(Reader reader) { this.reader = reader; }
    @Override public void writeExternal(ObjectOutput out) throws IOException { out.writeObject(book); out.writeObject(reader); }
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { book = (Book) in.readObject(); reader = (Reader) in.readObject(); }
    @Override public String toString() { return "Rent{book=" + book + ", reader=" + reader + "}"; }
}

class Library implements Externalizable {
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
    @Override public void writeExternal(ObjectOutput out) throws IOException { out.writeObject(bookshelf); out.writeObject(readers); out.writeObject(rents); }
    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { bookshelf = (Bookshelf) in.readObject(); readers = (List<Reader>) in.readObject(); rents = (List<Rent>) in.readObject(); }
    @Override public String toString() { return "Library{" + bookshelf + ", " + readers + ", " + rents + "}"; }
}