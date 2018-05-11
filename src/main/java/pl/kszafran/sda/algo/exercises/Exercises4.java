package pl.kszafran.sda.algo.exercises;

import java.io.IOException;
import java.util.*;

/**
 * Zaimplementuj poniższe metody operujące na liście wiązanej jednokierunkowej.
 */
public class Exercises4 {

    /**
     * Tworzy nową listę zawierającą podane elementy.
     */
    public <T> SdaList<T> createList(T... elements) {
        return new SdaLinkedList<>(elements);
    }

    public interface SdaList<T> extends Iterable<T> {

        /**
         * Zwraca true jeśli lista jest pusta.
         */
        boolean isEmpty();


        /**
         * Zwraca rozmiar listy (ilość elementów).
         */
        int size();

        /**
         * Zwraca pierwszy element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        T getFirst();

        /**
         * Zwraca ostatni element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        T getLast();

        /**
         * Pobiera element listy pod podanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        T get(int index);

        /**
         * Usuwa wszystkie elementy z listy.
         */
        void clear();

        /**
         * Dodaje nowy element na początku listy.
         */
        void addFirst(T element);

        /**
         * Dodaje nowy element na końcu listy.
         */
        void addLast(T element);

        /**
         * Usuwa pierwszy element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        void removeFirst();

        /**
         * Usuwa ostatni element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        void removeLast();

        ////////////////////////////////////////////
        //                                        //
        // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
        //                                        //
        ////////////////////////////////////////////

        /**
         * Zwraca iterator po elementach listy.
         *
         * @see java.lang.Iterable
         */
        @Override
        Iterator<T> iterator();

        /**
         * Zamienia element pod podanym indeksem.
         */
        void setAt(int index, T element);

        /**
         * Dodaje nowy element pod wskazanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        void addAt(int index, T element);

        /**
         * Usuwa element pod wskazanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        void removeAt(int index);
    }

    private static class SdaLinkedList<T> implements SdaList<T> {

        private Node<T> head;

        public SdaLinkedList(T[] elements) {

            for (int i = elements.length - 1; i >= 0; i--) {
                head = new Node<>(elements[i], head);
            }
        }

        @Override
        public boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        @Override
        public int size() {
            Node<T> iteratorNext = head;
            int iterator = 0;
            while (null != iteratorNext) {
                iteratorNext = iteratorNext.next;
                iterator++;
            }
            return iterator;
        }

        @Override
        public T getFirst() {
            if (head != null) {
                return head.element;
            }
            throw new NoSuchElementException("bla getFirst");
        }

        @Override
        public T getLast() {
            Node<T> iteratorNext = head;
            if (head != null) {
                while (null != iteratorNext.next) {
                    iteratorNext = iteratorNext.next;
                }
                return iteratorNext.element;
            } else
                throw new NoSuchElementException("bla get last");
        }

        @Override
        public T get(int index) {
            int iterator = 0;
            Node<T> iteratorNext = head;

            if (head != null) {
                if (index >= 0) {
                    while (iterator < index) {

                        iteratorNext = iteratorNext.next;
                        if (iteratorNext == null) {
                            throw new IndexOutOfBoundsException(index);
                        }
                        iterator++;
                    }
                    return iteratorNext.element;
                }
            }
            throw new IndexOutOfBoundsException(index);
        }

        @Override
        public void clear() {
            head = null;
        }

        @Override
        public void addFirst(T element) {
            head = new Node<>(element, head);
        }

        @Override
        public void addLast(T element) {
            if (isEmpty()) {
                addFirst(element);
            } else {
                Node zmienna = head;
                while (zmienna.next != null) {
                    zmienna = zmienna.next;
                }
                zmienna.next = new Node<>(element,null);
            }
        }

        @Override
        public void removeFirst() {
            head = null;
        }

        @Override
        public void removeLast() {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        ////////////////////////////////////////////
        //                                        //
        // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
        //                                        //
        ////////////////////////////////////////////

        @Override
        public Iterator<T> iterator() {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void setAt(int index, T element) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void addAt(int index, T element) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void removeAt(int index) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        private static class Node<T> {

            private T element;
            private Node<T> next;

            private Node(T element, Node<T> next) {
                this.element = element;
                this.next = next;
            }
        }
    }
}
/*
            if (head == null) {
                addFirst(element);
                //throw new IndexOutOfBoundsException();
                if(isEmpty())
                {
                    throw new NoSuchElementException();

                }
            }
            Node nd = head;
            while (nd.next != null) {
                nd = nd.next;

            }
            nd.next = new Node(element, null);
            */