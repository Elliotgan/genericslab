/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

/**
 *
 * @author ganellio
 * @param <T>
 */
public class LinkedList<T> {

    private static class Node<T> {

        public T value;
        public Node<T> next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    public LinkedList() {
        this.first = null;
    }

    public void add(T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     *
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            Node<T> retNode = first;
            T ret = retNode.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                Node<T> retNode = cur.next;
                T ret = retNode.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }

    public void intersperse(T sep) {
        if (first == null) {

        } else {
            Node<T> cur = first;
            Node<T> holder = first;
            while (cur.next != null) {
                Node<T> sepe = new Node<T>(sep, null);
                holder = cur.next;
                cur.next = sepe;
                sepe.next = holder;
            }
        }
    }

    public T maximum() {
        if (first == null) {
            throw new UnsupportedOperationException();
        }
        if ((first.value instanceof Integer)
                || (first.value instanceof Character)
                || (first.value instanceof Long)
                || (first.value instanceof Float)
                || (first.value instanceof Double)) {
            T ret = (T) first.value;
            for (Node<T> cur = first; cur != null; cur = cur.next) {
                if ((double) cur.value > (double) ret) {
                    ret = cur.value;
                }
            }
            return ret;
        } else {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public String toString() {
        String ret = "[";
        for (Node<T> cur = first; cur != null; cur = cur.next) {
            ret += cur.value;
            if (cur.next == null) {
                ret += "]";
            } else {
                ret += ", ";
            }
        }
        return ret;
    }

    public void printlst() {
        for (Node cur = first; cur != null; cur = cur.next) {
            System.out.println(cur.value);
        }
    }

    public void insertionSort() {
        if (first == null) {
            throw new UnsupportedOperationException();
        }
        String type;
        if (!((first.value instanceof Integer)
                || (first.value instanceof Character)
                || (first.value instanceof Long)
                || (first.value instanceof Float)
                || (first.value instanceof Double))) {
            throw new UnsupportedOperationException();
        }
        Node<T> prevNode = first; //Keeps track of the node directly in front of cur.
        Node<T> curNode = first.next; //Keeps track of the node being sorted.
        for (int i = 1; i < this.size(); i++) { //Iterates through LinkedList, stops before last element.
            System.out.println("currently at i = " + i);
            T curVal = this.get(i);
            //boolean execute = true;
            if (Double.valueOf("" + curVal) < Double.valueOf("" + this.get(0))) {
                prevNode.next = curNode.next;
                Node save = this.first;
                this.first = curNode;
                curNode.next = save;
            } else {
                Node<T> nodeBefore = first; //Keeps track of the node before where we want to insert.
                //Node<T> nodeBehind = first.next; //Keeps track of the node after where we want to insert.
                for (int j = 2; j < i; j++) { //Traverses through the sorted sorted part of the list.
                    //Node<T> nodeBefore = first; //Keeps track of the node before where we want to insert.
                    //Node<T> nodeBehind = first.next; //Keeps track of the node after where we want to insert.
                    System.out.println("curNode: " + curNode.value);
                    System.out.println("nodeBofore: " + nodeBefore.value);
                    //System.out.println("nodeBehind: " + nodeBehind.value);
                    System.out.println("value of jth node: " + this.get(j));
                    if (Double.valueOf("" + curVal) < Double.valueOf("" + this.get(j)) || j == i - 1) { //&& execute) { //Finds the next largest number to insert cur node infront of 
                        prevNode.next = curNode.next; //Repairs the pointer to the item before the one we are sorting to point to the next unsorted item.
                        //execute = false; //(execute ensures we don't run this again once we have already found the right place to insert).
                        nodeBefore.next = curNode; //Points the item infront of where we want to insert to our curNode.
                        //curNode.next = nodeBehind; //Points the curNode to the next largest sorted item.
                        break;
                    }
                    nodeBefore = nodeBefore.next; //advances the traversal
                    //nodeBehind = nodeBehind.next; //advances the traversal
                }
            }
            //prevNode = curNode; //advances the traversal
            curNode = prevNode.next; //advances the traversal
        }
    }

    public void insertionSortalt() {
        if (first == null) {
            return;
        }
        String type;
        if (!((first.value instanceof Integer)
                || (first.value instanceof Character)
                || (first.value instanceof Long)
                || (first.value instanceof Float)
                || (first.value instanceof Double))) {
            throw new UnsupportedOperationException();
        }
        for (int i = 1; i < this.size(); i++) {
            //System.out.println("size: " + this.size());
            Node prev = this.first;
            Node cur;
            for (int x = 0; x < i - 1; x++) {
                prev = prev.next;
            }
            cur = prev.next;
            //System.out.println("prev: " + prev.value);
            //System.out.println("cur: " + cur.value);
            if ((Double.valueOf("" + this.get(0))) > (Double.valueOf("" + cur.value))) {
                prev.next = prev.next.next;
                //System.out.println("skip triggered");
                Node save = this.first;
                this.first = cur;
                cur.next = save;
            } else {
                Node before = this.first;
                for (int j = 1; j < i; j++) {
                    //System.out.println("swap loop entered");
                    //System.out.println("before: " + before.value);
                    if (((Double.valueOf("" + this.get(j))) > (Double.valueOf("" + cur.value)))) {
                        //System.out.println("swap triggered");
                        //System.out.println("i value: " + i);
                        //System.out.println("j value: " + j);
                        //System.out.println("j: " + this.get(j));
                        prev.next = prev.next.next;
                        cur.next = before.next;
                        before.next = cur;
                        break;
                    }
                    before = before.next;
                }
            }
            //System.out.println("reaches the end, print list:");
           // this.printlst();
        }

    }

}
