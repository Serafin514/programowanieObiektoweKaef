package pl.kszafran.sda.algo.exercises;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Exercises3 {

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
        if (directory.isFile()&& directory.getName().matches(regex)){// do ogarniecia
            result.add(directory);
        }

        if (files != null) {//do ogarniecia

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
}
