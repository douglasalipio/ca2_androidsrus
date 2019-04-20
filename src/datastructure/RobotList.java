/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author hal-9000
 */
public class RobotList {

    private Object[] data; // list itself. null values at the end
    private int capacity;  // maximum capacity of the list
    private int num;  // current size of the list
    private static final int DEFAULT_CAPACITY = 1000;

    public RobotList() {
        this(DEFAULT_CAPACITY);
    }

    public RobotList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity]; // null array
        num = 0;
    }

    public void add(Object a) throws ArrayIndexOutOfBoundsException {
        if (num == capacity) {
            throw new ArrayIndexOutOfBoundsException("list capacity exceeded");
        }
        data[num] = a;
        num++;
    }

    public Object get(int index) {
        // find the element at given index
        if (index < 0 || index >= num) {
            throw new RuntimeException("index out of bounds");
        }
        return data[index];
    }

    public void deleteLastElement() {
        // delete the last element from the list
        // fill in the code in the class.
        if (num == 0) {
            throw new RuntimeException("list is empty: cannot delete");
        }
        num--;
        data[num] = null;
    }

    public void deleteFirstElement() {
        // delete first element from the list
        for (int i = 0; i < num - 1; i++) {
            data[i] = data[i + 1];
        }
        data[num - 1] = null;
        num--; // IMPORTANT. Re-establish invariant
    }
}
