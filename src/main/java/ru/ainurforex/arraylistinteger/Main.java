package ru.ainurforex.arraylistinteger;

public class Main {
    public static void main(String[] args) {
        int numElements = 100000;
        IntegerList integerList1 = new IntegerList();
        long start = System.currentTimeMillis();
         integerList1.fillArrayRandomNumberBySize(numElements);

        System.out.println("Время формирования случайного массива мс. из " +
                numElements + " элементов- " + (System.currentTimeMillis() - start));

        IntegerList integerList2 = integerList1;
        IntegerList integerList3 = integerList1;

        start = System.currentTimeMillis();
        integerList1.sortBubble();
        System.out.println("Длительность пузырьковой сортировки (мс.) из " + numElements + " элементов- " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        integerList2.sortInsertion();
        System.out.println("Длительность сортировки вставкой (мс.) из " + numElements + " элементов-    " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        integerList3.sortSelection();
        System.out.println("Длительность сортировки выбором (мс.) из " + numElements + " элементов-     " + (System.currentTimeMillis() - start));

    }
}