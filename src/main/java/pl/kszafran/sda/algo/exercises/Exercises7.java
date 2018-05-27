package pl.kszafran.sda.algo.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Exercises7 {

    /**
     * Zwraca true jeśli elementy w podanej tablicy tworzą kopiec,
     * tzn. tworzą kompletne drzewo binarne, w którym każdy węzeł
     * ma wartość większą lub równą wartości swoich dzieci.
     */
    public boolean isHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (((2 * i) + 1 < array.length
                    && array[2 * i + 1] > array[i])
                    ||
                    ((2 * i) + 2 < array.length
                            && array[2 * i + 2] > array[i])) {
                return false;
            }
        }
        return true;
    }

    public <T extends Comparable<T>> SdaHeap<T> createHeap(T[] heap, int capacity) {
        return new FixedSizeSdaHeap<>(heap, capacity);
    }

    public interface SdaHeap<T extends Comparable<T>> {

        /**
         * Dodaje nowy element do kopca. Po dodaniu elementu do tablicy, własność kopca musi zostać zachowana.
         *
         * @throws IllegalStateException jeśli kopiec jest pełny
         */
        void push(T element);

        /**
         * Usuwa z kopca i zwraca element o najwyższej wartości.
         *
         * @throws NoSuchElementException jeśli kopiec jest pusty
         */
        T pop();

        /**
         * Zwraca ilość elementów na kopcu.
         */
        int size();

        /**
         * Zwraca tablicę zawierającą elementy kopca.
         */
        T[] toArray();
    }

    private static class FixedSizeSdaHeap<T extends Comparable<T>> implements SdaHeap<T> {

        private T[] heap;
        private int size;

        // zakładamy, że "heap" jest poprawnym kopcem
        public FixedSizeSdaHeap(T[] heap, int capacity) {
            this.heap = Arrays.copyOf(heap, capacity);
            this.size = heap.length;
        }


        /*
        A[A.length] = v
        i = A.length-1
        while (i > 1 && A[parent(i)] < A[i])
        swap(A[i], A[parent(i)])
        */
        @Override
        public void push(T element) {
            if (size == heap.length) {
                throw new IllegalStateException();
            }
            heap[size] = element;
            size += 1;
            int index = size - 1;
            while (index > 0 && heap[index].compareTo(heap[(index - 1) / 2]) > 0) {
                T swap = heap[index];
                heap[index] = heap[(index - 1) / 2];
                heap[(index - 1) / 2] = swap;
                index=(index-1)/2;
            }

        }

        @Override
        public T pop() {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public int size() {
            return size;
        }

        public T[] toArray() {
            return Arrays.copyOf(heap, size);
        }
    }

    public <T extends Comparable<T>> SdaBst<T> createBst(T[] elements) {
        return new SdaBstImpl<>(elements);
    }

    public interface SdaBst<T extends Comparable<T>> {

        /**
         * Wstawia nowy element do drzewa BST.
         * <p>
         * Jeśli element o takiej samej wartości już znajduje się w drzewie,
         * zostaje zastąpiony przez nowy element.
         */
        void insert(T element);

        /**
         * Zwraca true, jeśli podany element znajduje się w drzewie.
         * <p>
         * Uwaga: elementy należy porównywać poprzez .compareTo(..), nie .equals(..).
         */
        boolean contains(T element);

        /**
         * Usuwa element z drzewa BST (jeśli taki istnieje).
         * <p>
         * Podpowiedź: należy rozpatrzyć trzy przypadki:
         * - usuwany węzeł nie ma dzieci
         * - usuwany węzeł ma jedno dziecko
         * - usuwany węzeł ma dwoje dzieci
         * <p>
         * Uwaga: zauważ, że nasza implementacja Node nie przechowuje referencji na rodzica (parent),
         * więc nie każde rozwiazanie znalezione w Internecie się dla nas nadaje.
         * <p>
         * Podpowiedź: ta stronka może się tutaj bardziej przydać niż Wikipedia:
         * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
         */
        void delete(T element);

        /**
         * Zwraca listę zawierającą wszystkie elementy, posortowane.
         */
        List<T> toList();
    }

    private static class SdaBstImpl<T extends Comparable<T>> implements SdaBst<T> {

        private Node root;

        public SdaBstImpl(T[] elements) {
            // to już jest OK, nie ruszać :)
            for (T element : elements) {
                insert(element);
            }
        }

        @Override
        public void insert(T element) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public boolean contains(T element) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void delete(T element) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public List<T> toList() {
            List<T> list = new ArrayList<>();
            inOrder(root, list::add);
            return list;
        }

        private void inOrder(Node node, Consumer<T> visitor) {
            if (node == null) {
                return;
            }
            inOrder(node.left, visitor);
            visitor.accept(node.value);
            inOrder(node.right, visitor);
        }

        private class Node {

            private T value;
            private Node left;
            private Node right;

            public Node(T value, Node left, Node right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }
        }
    }
}
