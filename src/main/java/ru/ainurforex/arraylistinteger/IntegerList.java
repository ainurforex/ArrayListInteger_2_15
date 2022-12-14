package ru.ainurforex.arraylistinteger;

import ru.ainurforex.arraylistinteger.exceptions.*;
import ru.ainurforex.arraylistinteger.exceptions.ArrayIndexOutOfBoundsException;

import java.util.Arrays;

public class IntegerList implements IntegerListInterface {
    public Integer[] arrayList;
    private int size;

    public IntegerList() {
        size = 0;
        arrayList = new Integer[10];
    }

    public IntegerList(int initSize) {
        size = 0;
        arrayList = new Integer[initSize];
    }

    @Override
    public String toString() {
        String arrayInteger = "";
        if (size == 0) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            arrayInteger = arrayInteger + arrayList[i] + " ";
        }
        return arrayInteger;
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        arrayList[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            arrayList[size++] = item;
            return item;
        }

        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        arrayList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new NotSuchElementException();
        }

        if (index != size) {
            System.arraycopy(arrayList, index + 1, arrayList, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = arrayList[index];
        if (index != size) {
            System.arraycopy(arrayList, index + 1, arrayList, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = arrayList.length - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    @Override
    public boolean equals(IntegerListInterface otherList) {
        if (otherList.toString() == null) {
            throw new ArrayListIsEmptyException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return arrayList;
    }

    public void fillArrayRandomNumberBySize(int newSize) {
        if (newSize < 0) {
            newSize=0;
        }
        size=newSize;
        validateSize();
        for (int i = 0; i < size; i++) {
            arrayList[i]=getRandomIntegerBetweenRange(0,size*2);
        }
    }

    public  void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arrayList[j] > arrayList[j + 1]) {
                    swapElements( j, j + 1);
                }
            }
        }
    }

    public void sortSelection() {
        for (int i = 0; i < size- 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arrayList[j] < arrayList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(i, minElementIndex);
        }
    }

    public  void sortInsertion() {
        for (int i = 1; i < size; i++) {
            int temp = arrayList[i];
            int j = i;
            while (j > 0 && arrayList[j - 1] >= temp) {
                arrayList[j] = arrayList[j - 1];
                j--;
            }
            arrayList[j] = temp;
        }
    }
    public  void sortInsertionByInt() {
        int[]arrayInt=new int[size];
        for (int i = 0; i < size; i++) {
            arrayInt[i]=arrayList[i];
        }
        int sizeArrayInt=arrayInt.length;
        for (int i = 1; i < sizeArrayInt; i++) {
            int temp = arrayInt[i];
            int j = i;
            while (j > 0 && arrayInt[j - 1] >= temp) {
                arrayInt[j] = arrayInt[j - 1];
                j--;
            }
            arrayInt[j] = temp;
        }
        for (int i = 0; i < size; i++) {
            arrayList[i]=arrayInt[i];
        }
    }
    public  void sortQuick(int[] array, int low, int high) {
        if (array.length == 0)
            return;//?????????????????? ????????????????????, ???????? ?????????? ?????????????? ?????????? 0

        if (low >= high)
            return;//?????????????????? ???????????????????? ???????? ?????? ???????????? ????????????

        // ?????????????? ?????????????? ??????????????
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // ?????????????????? ???? ????????????????????, ?????????????? ???????????? ?? ???????????? ???????????????? ????????????????
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//???????????? ??????????????
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }


        if (low < j)
            sortQuick(array, low, j);

        if (high > i)
            sortQuick(array, i, high);
    }
    private void validateIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }


    private void validateSize() {
        if (size >= arrayList.length) {
            Integer[] arrayListCopy = arrayList;
            arrayList = new Integer[size + 1 + Math.abs(size / 3)];
            System.arraycopy(arrayListCopy, 0, arrayList, 0, arrayListCopy.length);
        }
    }

    private  void swapElements(int indexA, int indexB) {
        int tmp = arrayList[indexA];
        arrayList[indexA] = arrayList[indexB];
        arrayList[indexB] = tmp;
    }

    public static Integer getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
