package ru.ainurforex.arraylistinteger;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.ainurforex.arraylistinteger.exceptions.ArrayIndexOutOfBoundsException;
import ru.ainurforex.arraylistinteger.exceptions.ArrayListIsEmptyException;
import ru.ainurforex.arraylistinteger.exceptions.NotSuchElementException;
import ru.ainurforex.arraylistinteger.exceptions.NullItemException;

import static ru.ainurforex.arraylistinteger.Constants.*;


public class IntegerListTests {
    @BeforeEach
    public IntegerList initialIntegerList() {
        IntegerList integerListExcepted = new IntegerList();
        integerListExcepted.add(ZERO);
        integerListExcepted.add(ONE);
        integerListExcepted.add(TWO);
        integerListExcepted.add(THREE);
        return integerListExcepted;
    }

    @Test
    public void shouldAddFirstItem() {
        IntegerList integerList = new IntegerList();
        integerList.add(ZERO);
        Assertions.assertEquals(ZERO, integerList.get(0));
    }

    @Test
    public void shouldAddMoreItem() {
        IntegerList integerList = new IntegerList();
        integerList.add(ZERO);
        Assertions.assertEquals(ZERO, integerList.get(0));
        integerList.add(ONE);
        Assertions.assertEquals(ONE, integerList.get(1));
        integerList.add(TWO);
        Assertions.assertEquals(TWO, integerList.get(2));
        Assertions.assertEquals(3, integerList.size());
    }

    @Test
    public void shouldAddItemInIndex0() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.add(0, TEN);
        Integer[] IntegerArrayActual = {TEN, ZERO, ONE, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldAddItemInIndexToEndArray() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.add(2, TWELVE);
        Integer[] IntegerArrayActual = {ZERO, ONE, TWELVE, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldAddItemInIndexToMiddleArray() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.add(1, ELEVEN);
        Integer[] IntegerArrayActual = {ZERO, ELEVEN, ONE, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());

    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionByAddItemInArrayIndexOutOfBounds() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.add(4, THREE));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.add(-1, THREE));
    }

    @Test
    public void shouldThrowNullItemExceptionByAddNullItem() {
        IntegerList integerList = new IntegerList();
        Assertions.assertThrows(NullItemException.class, () ->
                integerList.add(null));
    }

    @Test
    public void shouldSetItemInIndex() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.set(0, TEN);
        Integer[] IntegerArrayActual = {TEN, ONE, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionBySetItemInArrayIndexOutOfBounds() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.set(4, THREE));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.set(-1, THREE));
    }

    @Test
    public void shouldRemoveItemByItemZeroPositionInArray() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.remove(ZERO);
        Integer[] IntegerArrayActual = {ONE, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldRemoveItemByItemEndPositionInArray() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.remove(THREE);
        Integer[] IntegerArrayActual = {ZERO, ONE,TWO};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldRemoveItemByItemMiddlePositionInArray() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.remove(ONE);
        Integer[] IntegerArrayActual = {ZERO, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldThrowNotSuchElementExceptionByRemoveItemByNotSushItem() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertThrows(NotSuchElementException.class, () ->
                integerListExcepted.remove(TEN));
    }

    @Test
    public void shouldRemoveItemByIndex0() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.remove(0);
        Integer[] IntegerArrayActual = {ONE, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldRemoveItemByIndexEndOfArray() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.remove(3);
        Integer[] IntegerArrayActual = {ZERO, ONE,TWO};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldRemoveItemByIndexMiddleOfArray() {
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.remove(1);
        Integer[] IntegerArrayActual = {ZERO, TWO,THREE};
        Assertions.assertEquals(IntegerArrayActual.length, integerListExcepted.size());
        Assertions.assertEquals(arraytoString(IntegerArrayActual), integerListExcepted.toString());
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionByRemoveItemInArrayIndexOutOfBounds() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.remove(4));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.remove(-1));
    }

    @Test
    public void shouldTrueContainsByItem() {
        IntegerList integerListExcepted = new IntegerList();
        integerListExcepted.add(TWO);
        integerListExcepted.add(ZERO);
        integerListExcepted.add(THREE);
        integerListExcepted.add(ONE);
        Assertions.assertEquals(true, integerListExcepted.contains(ZERO));
    }

    @Test
    public void shouldFalseContainsByItem() {
        IntegerList integerListExcepted = new IntegerList();
        integerListExcepted.add(TWO);
        integerListExcepted.add(ZERO);
        integerListExcepted.add(THREE);
        integerListExcepted.add(ONE);
        Assertions.assertEquals(false, integerListExcepted.contains(TEN));
    }

    @Test
    public void shouldIndexOfItemPresentInArray() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertEquals(1, integerListExcepted.indexOf(ONE));
    }

    @Test
    public void shouldIndexOfItemAbscentInArray() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertEquals(-1, integerListExcepted.indexOf(TEN));
    }


    @Test
    public void shouldLastIndexOfItemPresentInArray() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertEquals(1, integerListExcepted.indexOf(ONE));
    }

    @Test
    public void shouldLastIndexOfItemAbscentInArray() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertEquals(-1, integerListExcepted.indexOf(TEN));
    }


    @Test
    public void shouldGetIndexByItem() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertEquals(TWO, integerListExcepted.get(2));
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionByGetIndexByItemInArrayIndexOutOfBounds() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.get(4));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                integerListExcepted.get(-1));
    }


    @Test
    public void shouldSizeOfListArray() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertEquals(4, integerListExcepted.size());
    }


    @Test
    public void shouldFalseIsEmpyArray() {
        IntegerList integerListExcepted = initialIntegerList();
        Assertions.assertEquals(false, integerListExcepted.isEmpty());
    }

    @Test
    public void shouldTrueIsEmpyArray() {
        IntegerList integerListExcepted = new IntegerList();
        Assertions.assertEquals(true, integerListExcepted.isEmpty());
    }

    @Test
    public void shouldClearArray() {
        IntegerList integerListActual = new IntegerList();
        IntegerList integerListExcepted = initialIntegerList();
        integerListExcepted.clear();
        Assertions.assertEquals(integerListActual.toString(), integerListExcepted.toString());
    }

    @Test
    public void shouldIntegerArrayToArrayList() {
        IntegerList integerListExcepted = initialIntegerList();
        Integer[] actualArrayInteger = {ZERO, ONE, TWO,THREE};

        Assertions.assertEquals(arraytoString(actualArrayInteger), integerListExcepted.toString());
    }

    @Test
    public void shouldTrueEqualsTwoArrayList() {
        IntegerList integerListExcepted = initialIntegerList();
        IntegerList integerListActual = initialIntegerList();

        Assertions.assertEquals(true, integerListExcepted.equals(integerListActual));
    }

    @Test
    public void shouldFalseEqualsTwoArrayList() {
        IntegerList integerListExcepted = initialIntegerList();
        IntegerList integerListActual = new IntegerList();
        integerListActual.add(ONE);
        integerListActual.add(TWO);
        integerListActual.add(THREE);

        Assertions.assertEquals(false, integerListExcepted.equals(integerListActual));
    }



    @Test
    public void shouldThrowArrayListIsEmptyExceptionByEqualsByArrayListIsEmpty() {
        IntegerList integerListNull = new IntegerList();
        IntegerList integerList = initialIntegerList();
        Assertions.assertThrows(ArrayListIsEmptyException.class, () ->
                integerList.equals(integerListNull));
    }

    @Test
    public void shoulResizeArrayByAddItem() {
        IntegerList integerList = new IntegerList(1);
        integerList.add(ZERO);
        integerList.add(ONE);
        integerList.add(TWO);
        integerList.add(THREE);
        Assertions.assertEquals(4, integerList.size());
    }

    @Test
    public void shoulSortBubble() {
        IntegerList integerListActual = initialIntegerList();
        IntegerList integerListExcepted = new IntegerList();
        integerListExcepted.add(TWO);
        integerListExcepted.add(ZERO);
        integerListExcepted.add(THREE);
        integerListExcepted.add(ONE);
        integerListExcepted.sortBubble();
        Assertions.assertEquals(true, integerListExcepted.equals(integerListActual));
    }

    @Test
    public void shoulSortSelection() {
        IntegerList integerListActual = new IntegerList();
        integerListActual.add(ZERO);
        integerListActual.add(ONE);
        integerListActual.add(TWO);
        integerListActual.add(THREE);
        IntegerList integerListExcepted = new IntegerList();
        integerListExcepted.add(TWO);
        integerListExcepted.add(ZERO);
        integerListExcepted.add(THREE);
        integerListExcepted.add(ONE);
        integerListExcepted.sortSelection();
        Assertions.assertEquals(true, integerListExcepted.equals(integerListActual));
    }
    @Test
    public void shoulSortInsertion() {
        IntegerList integerListActual = new IntegerList();
        integerListActual.add(ZERO);
        integerListActual.add(ONE);
        integerListActual.add(TWO);
        integerListActual.add(THREE);
        IntegerList integerListExcepted = new IntegerList();
        integerListExcepted.add(TWO);
        integerListExcepted.add(ZERO);
        integerListExcepted.add(THREE);
        integerListExcepted.add(ONE);
        integerListExcepted.sortInsertion();
        Assertions.assertEquals(true, integerListExcepted.equals(integerListActual));
    }
    private static String arraytoString(Integer[] array) {
        String arrayInteger = "";
        for (int i = 0; i < array.length; i++) {
            arrayInteger = arrayInteger + array[i] + " ";
        }
        return arrayInteger;
    }
}
