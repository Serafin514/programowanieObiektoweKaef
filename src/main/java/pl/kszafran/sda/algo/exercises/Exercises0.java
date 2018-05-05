package pl.kszafran.sda.algo.exercises;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Zaimplementuj poniższe metody z użyciem wyrażeń lambda i/lub klas Stream oraz Optional.
 */
public class Exercises0 {

    /**
     * Funkcja zwraca pierwszy indeks pod którym
     * określony znak znajduje się w podanym Stringu.
     */
    public OptionalInt indexOf(String string, char c) {
        int i = string.indexOf(c);
        if (i ==-1) {
            return OptionalInt.empty();
        } else
            return OptionalInt.of(i);
    }
    /**
     * Znajduje autora książki o podanym tytule.
     */
    public Optional<String> findAuthorByTitle(BookRepository repository, String title) {
        return repository.findByTitle(title).map(name->name.author);
    }

    /**
     * Funkcja zwraca ilość liczb dodatnich w podanej liście.
     */
    public long numPositive(List<Integer> numbers) {
    return numbers.stream()
            .filter(element->element>0)
            .count();
    }

    /**
     * Funkcja zwraca listę autorów książek znajdujących się na podanej liście.
     * Wynikowa lista jest posortowana alfabetycznie oraz nie zawiera duplikatów.
     */
    public List<String> authorsOf(Book... books) {
         return Arrays.stream(books)
                 .map(Book::getAuthor)
                 .sorted()
                 .distinct()
                 .collect(Collectors.toList());
    }

    /**
     * Funkcja zwraca wszystkie słowa występujące w tytułach podanych książek.
     * Znaki inne niż litery i cyfry (non-word characters) są usunięte z wyrazów.
     * Zwrócone wyrazy zapisane są małymi literami.
     */
    public Set<String> keywordsIn(Book... books) {
        return Arrays.stream(books)
                .flatMap(book->Arrays.stream(book.title.split("\\W+")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

    }

    /**
     * Zwraca mapę pozwalającą znaleźć książki po tytule.
     */
    public Map<String, Book> byTitle(List<Book> books) {

      return  books.stream().collect(Collectors.toMap(Book::getTitle, book->book));
    }
    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Zwraca mapę pozwalającą znaleźć książki po autorze.
     */
    public Map<String, Set<Book>> byAuthor(List<Book> books) {
        return books.stream()
                .collect(Collectors.
                        groupingBy(Book::getAuthor,Collectors.toSet()));
    }
    /**
     * Funkcja zwraca z podanej list książkę, która ma najwięcej edycji.
     * Jeśli więcej niż jedna książka ma tyle samo edycji, zwrócona jest książka pierwsza w kolejności.
     * <p>
     * Podpowiedź: przyda się funkcja Stream.reduce.
     */
    public Optional<Book> findMostEditions(Book... books) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /*
     * Zmodyfikuj metodę byAuthor oraz odpowiadający jej test
     * aby zwracała obiekt klasy Multimap z biblioteki Guava.
     *
     * Uwaga: musisz dodać tę bibliotekę do zależności projektu.
     */

    public interface BookRepository {
        Optional<Book> findByTitle(String title);
    }

    public static class Book {

        private final String title;
        private final String author;
        private final int numEditions;

        public Book(String title, String author, int numEditions) {
            this.title = title;
            this.author = author;
            this.numEditions = numEditions;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getNumEditions() {
            return numEditions;
        }
    }
}
