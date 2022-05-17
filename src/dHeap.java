/*
 * Name: Ariane Yu
 * PID:  A16008867
 */

import java.util.*;

/**
 * Implementation of d-ary heap.
 * 
 * @param <T> Generic type
 */
public class dHeap<T extends Comparable<? super T>> implements dHeapInterface<T> {

    private T[] heap; // heap array
    private int d; // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // boolean to indicate whether heap is max or min

    /**
     * Initializes a binary max heap with capacity = 6
     */
    public dHeap() {
        this.heap = (T[]) new Comparable[6];
        this.d = 2;
        this.nelems = 0;
        this.isMaxHeap = true;
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        this.heap = (T[]) new Comparable[heapSize];
        this.d = 2;
        this.nelems = 0;
        this.isMaxHeap = true;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        if (d < 1) {
            throw new IllegalArgumentException();
        }
        this.heap = (T[]) new Comparable[heapSize];
        this.d = d;
        this.nelems = 0;
        this.isMaxHeap = isMaxHeap;
    }

    /**
     * It returns the size of this heap
     *
     * @return the number of elements that this heap contains
     */
    @Override
    public int size() {
        return this.nelems;
    }

    /**
     * This method adds a new element to the heap.
     *
     * @param data the new data that would be added.
     * @throws NullPointerException when the given data is null.
     */
    @Override
    public void add(T data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        }
        if (this.nelems == heap.length) {
            resize();
        }
        heap[nelems] = data;
        bubbleUp(nelems);
        nelems++;
    }

    /**
     * This function remove the root of this heap and rearrange it.
     *
     * @return the removed root.
     * @throws NoSuchElementException when the heap is empty.
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        T toRemove = heap[0];
        heap[0] = heap[size() - 1];
        heap[size() - 1] = null;
        nelems--;
        trickleDown(0);
        return toRemove;
    }

    /**
     * This method clear every element from the heap and reset the size to be 0.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        nelems = 0;
        int size = heap.length;
        heap = (T[]) new Comparable[size];
    }

    /**
     * This method returns the root of the heap.
     *
     * @return the data that the root stores.
     * @throws NoSuchElementException when the heap is empty.
     */
    public T element() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    /**
     * This helper function move the node down if necessary.
     *
     * @param index the position of the node in the heap.
     */
    private void trickleDown(int index) {
        int childIndex = d * index + 1; // getting the first child of this node
        T data = heap[index]; // getting the data stored at this node
        while (childIndex < this.size()) { // if the child is within the heap range
            T mData = data; // setting the max data to be the one stored at this node
            int mIndex = -1; // initializing the index to an invalid value
            int i = 0; // for the while loop.
            if (isMaxHeap) { // if
                while (i < d && i + childIndex < this.size()) {
                    // while at the child of this node
                    // while the child is within the range of the heap
                    if (heap[i + childIndex].compareTo(mData) > 0) {
                        // if the child is larger than this node
                        mData = heap[i + childIndex]; // updating the max data
                        mIndex = i + childIndex; // updating the index of the largest child
                    }
                    i++;
                }
            } else {
                while (i < d && i + childIndex < this.size()) {
                    // while at the child of this node
                    // while the child is within the range of the heap
                    if (heap[i + childIndex].compareTo(mData) < 0) {
                        // if the child is smaller than this node
                        mData = heap[i + childIndex]; // updating the mini data
                        mIndex = i + childIndex; // updating the index of the smallest child
                    }
                    i++;
                }
            }
            if (mData.compareTo(data) == 0) {
                // if this node has the largest data, stop the loop
                return;
            } else {
                T temp = heap[index];
                heap[index] = heap[mIndex];
                heap[mIndex] = temp; // swapping the max or mini child and this parent
                index = mIndex; // updating the index of this node
                childIndex = d * index + 1; // updating its child index
            }
        }
    }

    /**
     * This is a helper function that move the node up if conditions are met
     *
     * @param index the position of the node in the heap
     */
    private void bubbleUp(int index) {
        while (index > 0) { // while the node is not at the root
            int parentIndex = parent(index); // getting the index of the parent
            if (heap[index].compareTo(heap[parentIndex]) <= 0 && isMaxHeap) {
                // checking if the parent is larger than this node in max heap
                return;
            } else if (heap[index].compareTo(heap[parentIndex]) >= 0 && !isMaxHeap){
                // checking if the parent is smaller than this node in mini heap
                return;
            } else {
                T temp =  heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp; // swapping this node and its parent
                index = parentIndex; // updating the index of this node
            }
        }
    }

    @SuppressWarnings("unchecked")
    /**
     * This helper function resize the capacity of the heap array by doubling its length.
     */
    private void resize() {
        int doubleSize = 2;
        int newSize = heap.length * doubleSize; // doubling the original length
        T[] temp = heap; // saving the original heap
        heap = (T[]) new Comparable[newSize]; // creating a new array with doubled size
        for (int i = 0; i< temp.length; i++) { // adding the data to the new array
            heap[i] = temp[i];
        }
    }

    /**
     * This method calculate the parent of the given node.
     *
     * @param index the position of the node.
     * @return the index of its parent.
     */
    private int parent(int index) {
        if (index == 0) {
            return 0;
        }
        return (index - 1) / d;
    }

}
