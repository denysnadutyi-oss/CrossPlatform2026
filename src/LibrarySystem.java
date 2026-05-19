import java.io.*;
import java.util.*;

class Author { // НЕ Serializable
    private String name;
    public Author() {}
    public Author(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override public String toString() { return "Author{name='" + name + "'}"; }
}

class Book { // НЕ Serializable
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

class Reader { // НЕ Serializable
    private String name;
    public Reader() {}
    public Reader(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override public String toString() { return "Reader{name='" + name + "'}"; }
}

class Bookshelf implements Serializable {
    private transient List<Book> books = new ArrayList<>(); // transient
    public Bookshelf() {}
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
    public void addBook(Book book) { books.add(book); }
    @Override public String toString() { return "Bookshelf{" + books + "}"; }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(books.size());
        for (Book b : books) {
            oos.writeUTF(b.getTitle());
            oos.writeUTF(b.getAuthor().getName());
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        books = new ArrayList<>();
        int size = ois.readInt();
        for (int i = 0; i < size; i++) {
            String title = ois.readUTF();
            String authorName = ois.readUTF();
            books.add(new Book(title, new Author(authorName)));
        }
    }
}

class Rent implements Serializable {
    private transient Book book; // transient
    private transient Reader reader; // transient
    public Rent() {}
    public Rent(Book book, Reader reader) { this.book = book; this.reader = reader; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Reader getReader() { return reader; }
    public void setReader(Reader reader) { this.reader = reader; }
    @Override public String toString() { return "Rent{book=" + book + ", reader=" + reader + "}"; }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(book.getTitle());
        oos.writeUTF(book.getAuthor().getName());
        oos.writeUTF(reader.getName());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        String title = ois.readUTF();
        String authorName = ois.readUTF();
        book = new Book(title, new Author(authorName));
        String readerName = ois.readUTF();
        reader = new Reader(readerName);
    }
}

class Library implements Serializable {
    private Bookshelf bookshelf = new Bookshelf();
    private transient List<Reader> readers = new ArrayList<>(); // transient
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
    @Override public String toString() { return "Library{" + bookshelf + ", " + readers + ", " + rents + "}"; }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(readers.size());
        for (Reader r : readers) {
            oos.writeUTF(r.getName());
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        readers = new ArrayList<>();
        int size = ois.readInt();
        for (int i = 0; i < size; i++) {
            String name = ois.readUTF();
            readers.add(new Reader(name));
        }
    }
}