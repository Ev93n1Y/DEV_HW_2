public class Launch {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        CashBox cashBox = new CashBox(warehouse);
        warehouse.addGoods(new Goods('A', 1.25, 3, 3.00));
        warehouse.addGoods(new Goods('B', 4.25));
        warehouse.addGoods(new Goods('C', 1.00, 6, 5.00));
        warehouse.addGoods(new Goods('D', 0.75));
        String basket = "ABCDBBCBADCCAAB";
        System.out.println(Basket.getItemsAmountMap(basket));
        Double price = cashBox.calcBasketCost(basket);
        System.out.println("Price for basket: " + basket + " = " + price);
    }
}
