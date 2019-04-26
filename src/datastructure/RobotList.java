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
    private int capacity; // maximum capacity of the list
    private int num; // current size of the list
    private static final int DEFAULT_CAPACITY = 1000;

    public RobotList() {
        this(DEFAULT_CAPACITY); // call RobotList (capacity).
    }

    public RobotList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity]; // null array
        num = 0;
    }

    public Object get(int index) {
        // find the element at given index
        if (index < 0 || index >= num) {
            throw new RuntimeException("index out of bounds");
        }
        return data[index];
    }

    public void add(Object a) {
        if (num == capacity) {
            Object[] datanew = new Object[capacity * 2];
            capacity = capacity * 2;
            // copy old data to new data
            System.arraycopy(data, 0, datanew, 0, num);
            data = datanew; // data now refers to he new array
        }
        data[num] = a;
        num++;
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
}
