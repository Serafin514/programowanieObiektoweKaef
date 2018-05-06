package pl.kszafran.sda.algo.exercises;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Zaimplementuj poniższe algorytmy wyszukiwania.
 */
public class Exercises3 {

    /**
     * Wyszukuje element o wartości value w podanej tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     */
    public int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     */
    public int binarySearch(int[] array, int value) {
        int minValue = 0;
        int maxValue = array.length - 1;
        while (maxValue >= minValue) {
            int middleValue = ((maxValue + minValue) / 2);
            if (array[middleValue] > value) {
                maxValue = middleValue - 1;
            } else if (array[middleValue] < value) {
                minValue = middleValue + 1;
            } else
                return middleValue;
        }
        return -1;
    }

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ liście i zwraca jego indeks.
     */
    public <T> Optional<Integer> indexOf(List<T> list, T value, Comparator<T> comparator) {
        for (int i = 0; i < list.size(); i++) {
            if (value == list.get(i)) {
                return Optional.ofNullable(i);
            }
        }
        return Optional.empty();
    }
    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Wyszukuje wszystkie elementy o wartości value w podanej POSORTOWANEJ tablicy i zwraca zakres ich indeksów.
     * <p>
     * Uwaga: istnieją dwie możliwe implementacje, jedna o stałej złożoności O(log n)
     * oraz druga, która potrafi zdegradować się do złożoności O(n) w najgorszym przypadku.
     */
    public Optional<IntRange> binarySearchRange(int[] array, int value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     * <p>
     * Uwaga: należy zastosować wyszukiwanie interpolacyjne (interpolation search).
     */
    public int interpolationSearch(int[] array, int value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Znajduje wszystkie pliki o nazwie pasującej do podanego wyrażenia regularnego
     * w podanym katalogu i wszystkich jego podkatalogach.
     * Zwrócone pliki są posortowane alfabetycznie po pełnej ścieżce (nie tylko nazwie pliku).
     * Jeśli directory wskazuje na plik, zwrócona lista ma zawierać tylko ten plik
     * (jeśli jego nazwa pasuje do wyrażenia regularnego).
     * Uwaga: należy skupić się na klasach z pakietu java.io.
     */
    public List<File> findFiles(File directory, String regex) throws IOException {
        List<File> result = new ArrayList<>();
        File[] files = directory.listFiles();
        if (directory.isFile() && directory.getName().matches(regex)) {// do ogarniecia
            result.add(directory);
        }

        if (files != null) {

            for (File file : files) {

                if (file.isFile() && file.getName().matches(regex)) {
                    result.add(file);

                } else if (file.isDirectory()) {
                    result.addAll(findFiles(file, regex));
                }
            }
        }
        return result;
    }


    /**
     * Działa tak samo jak findFiles().
     * <p>
     * Uwaga: należy korzystac z dobrodziejstw pakietu java.nio.file.
     */
    public Stream<Path> findFilesNIO(Path directory, Pattern regex) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static class IntRange {
        private final int start;
        private final int end;

        public IntRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

}
