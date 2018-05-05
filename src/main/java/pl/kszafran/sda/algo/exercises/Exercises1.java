package pl.kszafran.sda.algo.exercises;

import java.util.Arrays;
import java.util.Set;

/**
 * Zaimplementuj poniższe metody Z WYKORZYSTANIEM REKURENCJI.
 */
public class Exercises1 {

    /**
     * Oblicza silnię argumentu n. Zwraca 1 dla n = 0.
     */
    public int factorial(int n) {
        if (n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    /**
     * Oblicza sumę wszystkich liczb w podanej tablicy.
     * Uwaga: aby policzyć sumę rekurencyjnie, potrzebna będzie dodatkowa metoda.
     */
    public int sum3(int[] n){
        return n[0] + sum3(Arrays.copyOfRange(n, 1, n.length));
    }

    public int sum(int[] numbers) {
        return sum2(numbers,0);
    }

    public int sum2(int[] numbers,int offset){
       if (offset==numbers.length){
           return 0;
       }else {
           return numbers[offset]+sum2(numbers,offset+1);
       }
    }

    /**
     * Odwraca podany napis, np. dla "test" zwraca "tset".
     */
    public String reverse(String text) {
        int length = text.length();
        return text.substring(text.charAt(length),text.charAt(length-1));
    }

    /**
     * Oblicza NWW (najmniejszą wspólną wielokrotnosć) podanych argumentów.
     *
     * (po angielsku LCM - Least Common Multiple)
     *
     * Podpowiedź:
     * NWW(a, b) = a * b / NWD(a, b)
     * NWW(a1, a2, ..., an) = NWW(a1, NWW(a2, a3, ..., an))
     *
     * @throws IllegalArgumentException jeśli któryś z argument jest ujemny lub gdy nie podano żadnych argumentów
     */
    public int lcm(int... numbers) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Zwraca wszystkie możliwe permutacje podanego ciągu (różnych) znaków.
     * Np. dla "123" zwraca ["123", "132", "213", "231", "312", "321"].
     */
    public Set<String> permutations(String string) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
