package com.hujtb.datastructure;

/**
 * 数组
 */
public class MyArray<E> {

    private E[] array;
    // 数组中存放元素长度
    private int size;

    public MyArray(int capacity) {
        this.array = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 数组插入元素
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insert(E element, int index) throws Exception {

        //判断访问下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        //如果实际元素达到数组容量上限，则对数组进行扩容
        if (size >= array.length) {
            resize();
        }

        //从右向左循环，将元素逐个向右挪1位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        //腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     * 数组删除元素
     *
     * @param index 删除的位置
     */
    public E delete(int index) throws Exception {

        //判断访问下标是否超出范围
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        E deletedElement = array[index];
        //从左向右循环，将元素逐个向左挪1位
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        return deletedElement;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        E[] arrayNew = (E[]) new Object[array.length * 2];
        //从旧数组复制到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        // 旧数组指向新数组
        array = arrayNew;
    }

    /**
     * 输出数组
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(4);
        myArray.insert(3, 0);
        myArray.insert(7, 1);
        myArray.insert(9, 2);
        myArray.insert(5, 3);
        myArray.insert(6, 1);
        myArray.output();
    }

}
