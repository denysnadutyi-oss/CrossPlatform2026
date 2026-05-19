import java.io.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Author author1 = new Author("Taras Shevchenko");
        Book book1 = new Book("Kobzar", author1);
        library.getBookshelf().addBook(book1);
        Reader reader1 = new Reader("Ivan");
        library.addReader(reader1);
        library.rentBook(book1, reader1);

        System.out.println("--- ВЕРСІЯ 1: ПОТОЧНИЙ СТАН СИСТЕМИ ---");
        System.out.println(library);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.dat"))) {
            oos.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Library deserializedLibrary = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.dat"))) {
            deserializedLibrary = (Library) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("--- ВЕРСІЯ 1: СТАН ПІСЛЯ ДЕСЕРІАЛІЗАЦІЇ ---");
        System.out.println(deserializedLibrary);
    }
}