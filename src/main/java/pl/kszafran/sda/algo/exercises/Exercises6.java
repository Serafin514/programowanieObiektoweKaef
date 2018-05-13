package pl.kszafran.sda.algo.exercises;

import java.util.*;

/**
 * Zaimplementuj poniższe metody operujące na drzewie binarnym.
 */
public class Exercises6 {


    /**
     * Przechodzi podane drzewo w kolejności pre-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public <T> List<T> traversePreOrder(SdaTree<T> tree) {
        List<T> treeList = new ArrayList<>();

        treeList.add(tree.getValue());

        if (tree.getLeftChild().isPresent()) {
            treeList.addAll(traversePreOrder(tree.getLeftChild().get()));
        }

        if (tree.getRightChild().isPresent()) {
            treeList.addAll(traversePreOrder(tree.getRightChild().get()));
        }
        return treeList;
    }

    /**
     * Przechodzi podane drzewo w kolejności in-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public <T> List<T> traverseInOrder(SdaTree<T> tree) {

        List<T> treeList = new ArrayList<>();

        if (tree.getLeftChild().isPresent()) {
            treeList.addAll(traverseInOrder(tree.getLeftChild().get()));

        }
        treeList.add(tree.getValue());
        if (tree.getRightChild().isPresent()) {
            treeList.addAll(traverseInOrder(tree.getRightChild().get()));
        }
        return treeList;
    }

    /**
     * Przechodzi podane drzewo w kolejności post-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public <T> List<T> traversePostOrder(SdaTree<T> tree) {

        List<T> treeList = new ArrayList<>();

        if (tree.getLeftChild().isPresent()) {
            treeList.addAll(traversePostOrder(tree.getLeftChild().get()));

        }
        if (tree.getRightChild().isPresent()) {
            treeList.addAll(traversePostOrder(tree.getRightChild().get()));
        }
        treeList.add(tree.getValue());
        return treeList;
    }

    /**
     * Funkcja działa tak samo jak traversePreOrder.
     * <p>
     * Uwaga: metodę należy zaimplementować z wykorzystaniem stosu (bez rekurencji).
     */
    public <T> List<T> traversePreOrderIterative(SdaTree<T> tree) {
        List<T> result = new ArrayList<>();
        Deque<SdaTree<T>> stack = new ArrayDeque<>();

        stack.push(tree);

        while (!stack.isEmpty()) {
            SdaTree<T> temp = stack.pop();
            result.add(temp.getValue());
            temp.getRightChild().ifPresent(val -> stack.push(val));
            temp.getLeftChild().ifPresent(stack::push);

            /*
            if (temp.getRightChild().isPresent()) {
                stack.push(temp.getRightChild().get());
                //tree.getRightChild().get();
            }
            if (temp.getLeftChild().isPresent()) {
                stack.push(temp.getLeftChild().get());
            }
            */
        }
        return result;
    }

    /**
     * Przechodzi podane drzewo w kolejności level-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     * <p>
     * Podpowiedź: implementacja jest bardzo podobna do traversePreOrderIterative,
     * ale zamiast stosu wykorzystuje inną strukturę danych.
     */
    public <T> List<T> traverseLevelOrder(SdaTree<T> tree) {
        List<T> result = new ArrayList<>();
        Deque<SdaTree<T>> queue = new ArrayDeque<>();

        queue.offer(tree);

        while (!queue.isEmpty()) {
            SdaTree<T> poll = queue.poll();
            result.add(poll.getValue());
            poll.getLeftChild().ifPresent(queue::offer);
            poll.getRightChild().ifPresent(queue::offer);
        }
        return result;
    }

    /**
     * Funkcja zwraca liczbę liści w podanym drzewie.
     */
    public int countLeaves(SdaTree<?> tree) {
        int iterator = 0;
        Deque<SdaTree<?>> deque = new ArrayDeque<>();
        deque.push(tree);
        while (!deque.isEmpty()) {
            SdaTree<?> temp = deque.pop();

            if (temp.getRightChild().isPresent()) {
                deque.push(temp.getRightChild().get());
            }
            if (temp.getLeftChild().isPresent()) {
                deque.push(temp.getLeftChild().get());
            }
            if (!temp.getLeftChild().isPresent() && !temp.getRightChild().isPresent()) {
                iterator++;
            }
        }
        return iterator;
    }

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     * <p>
     * Tekst zawiera tyle linijek, ile poziomów ma drzewo.
     * Każda linijka zawiera wartości węzłów na odpowiednim poziomie rozdzielone spacjami, po kolei,
     * czyli każda linijka zawiera dwa razy więcej wartości niż poprzednia.
     * Wartość "-" oznacza, że węzeł na danej pozycji nie istnieje.
     * <p>
     * Np. drzewo ze slajdów przedstawione byłoby jako "F\nB G\nA D - I\n- - C E - - H -",
     * czyli zapisując w wielu liniach:
     * F
     * B G
     * A D - I
     * - - C E - - H -
     * <p>
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek zawiera nieprawidłową ilość wartości
     */
    public SdaTree<String> buildTree1(String input) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     * <p>
     * Każda linijka zawiera informację o parze rodzic-dziecko.
     * Format każdej linijki wygląda następująco:
     * <p>
     * left(rodzic)=dziecko
     * <p>
     * lub
     * <p>
     * right(rodzic)=dziecko
     * <p>
     * dla lewego i prawego dziecka odpowiednio.
     * <p>
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek jest niezgodna z powyższym formatem
     */
    public SdaTree<String> buildTree2(String input) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


    
    /**
     * Funkcja oblicza wysokość drzewa.
     * <p>
     * Przypomnienie: wysokość drzewa składającego się jedynie z korzenia to 0.
     */
    public int calcHeight(SdaTree<?> tree) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja znajduje największy element w drzewie.
     */
    public <T> T findMax(SdaTree<T> tree, Comparator<T> comparator) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public interface SdaTree<T> {

        /**
         * Tworzy nowe drzewo z korzeniem o podanej wartości oraz danych poddrzewach.
         */
        static <T> SdaTree<T> of(T value, SdaTree<T> left, SdaTree<T> right) {
            return new SdaTreeImpl<>(value, left, right);
        }

        /**
         * Tworzy nowy liść drzewa (węzeł bez dzieci).
         */
        static <T> SdaTree<T> leaf(T value) {
            return new SdaTreeImpl<>(value, null, null);
        }

        /**
         * Zwraca wartość tego węzła.
         */
        T getValue();

        /**
         * Zwraca lewe poddrzewo.
         */
        Optional<SdaTree<T>> getLeftChild();

        /**
         * Zwraca prawe poddrzewo.
         */
        Optional<SdaTree<T>> getRightChild();
    }

    private static class SdaTreeImpl<T> implements SdaTree<T> {

        private final T value;
        private final SdaTree<T> left;
        private final SdaTree<T> right;

        private SdaTreeImpl(T value, SdaTree<T> left, SdaTree<T> right) {
            this.value = Objects.requireNonNull(value, "value must not be null");
            this.left = left;
            this.right = right;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public Optional<SdaTree<T>> getLeftChild() {
            return Optional.ofNullable(left);
        }

        @Override
        public Optional<SdaTree<T>> getRightChild() {
            return Optional.ofNullable(right);
        }
    }
}
