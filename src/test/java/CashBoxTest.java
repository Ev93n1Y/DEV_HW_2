import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CashBoxTest {
    static CashBox cashBox;

    @BeforeAll
    static void setUp() {
        Warehouse testWarehouse = new Warehouse();
        testWarehouse.addGoods(new Goods('A', 1.25, 3, 3.00));
        testWarehouse.addGoods(new Goods('B', 4.25));
        testWarehouse.addGoods(new Goods('C', 1.00, 6, 5.00));
        testWarehouse.addGoods(new Goods('D', 0.75));
        cashBox = new CashBox(testWarehouse);
    }

    @ParameterizedTest()
    @CsvSource({
            "1.25, A",
            "2.50, AA",
            "3.00, AAA",
            "5.50, AB",
            "7.25, ABCD",
            "13.25, ABCDABA"
    })
    void testThatCalcBasketCostWorksOk(Double expected, String name) {
        Assertions.assertEquals(expected,
                cashBox.calcBasketCost(name), "Basket: \"" + name + "\" cost ");
    }

    @ParameterizedTest()
    @CsvSource({
            "1.25, A, 1",
            "3.00, A, 3",
            "4.25, A, 4,",
            "4.25, B, 1,",
            "17.00, B, 4"
    })
    void testThatGetCostWorksOk(Double expected, Character name, Long count) {
        Assertions.assertEquals(expected,
                cashBox.getCost(name, count), "Product name: '" + name + "' count: " + count);
    }

    @ParameterizedTest()
    @CsvSource({
            "1.25, A, 1",
            "2.50, A, 2",
            "3.75, A, 3,",
            "5.00, A, 4,",
            "6.25, A, 5",
            "4.25, B, 1",
            "8.50, B, 2",
            "12.75, B, 3",
            "17.00, B, 4",
            "21.25, B, 5"
    })
    void testThatGetNoDiscountPriceWorksOk(Double expected, Character name, Long count) {
        Assertions.assertEquals(expected,
                cashBox.getNoDiscountPrice(name, count), "Product name: '" + name + "' count: " + count);

    }

    @ParameterizedTest()
    @CsvSource({
            "1.25, A, 1",
            "3.00, A, 3",
            "4.25, A, 4",
            "5.50, A, 5,",
            "6.00, A, 6,",
            "7.25, A, 7",
            "12.00, A, 12",
            "1.00, C, 1",
            "2.00, C, 2",
            "3.00, C, 3",
            "4.00, C, 4",
            "5.00, C, 5",
            "5.00, C, 6",
            "6.00, C, 7",
            "10.00, C, 12",
            "15.00, C, 18",
            "16.00, C, 19"
    })
    void testThatGetDiscountedPriceWorksOk(Double expected, Character name, Long count) {
        Assertions.assertEquals(expected,
                cashBox.getDiscountedPrice(name, count), "Product name: '" + name + "' count: " + count);
    }

    @ParameterizedTest()
    @CsvSource({
            "B, 1",
            "B, 2",
            "B, 3",
            "B, 4",
            "B, 10",
            "D, 15"
    })
    void testThatGetDiscountedPriceThrowIllegalArgumentException(Character name, Long count) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                cashBox.getDiscountedPrice(name, count), "Product name: " + name + " count: " + count);

    }
}