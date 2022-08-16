import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CashBox {
    private final Map<Character, Goods> goodsMap;

    public CashBox(Warehouse warehouse) {
        goodsMap = warehouse.getGoodsMap();
    }

    public Double calcBasketCost(String basket) {
        List<Double> prices = new ArrayList<>();
        Basket.getItemsAmountMap(basket)
                .forEach((key, value) -> prices.add(getCost(key, value)));
        return prices.stream().collect(Collectors.summarizingDouble(d -> d)).getSum();
    }

    public Double getCost(Character key, Long count) {
        return (goodsMap.get(key).getPromoPrice() == null) ?
                getNoDiscountPrice(key, count) :
                getDiscountedPrice(key, count);
    }

    public Double getNoDiscountPrice(Character key, Long count) {
        return goodsMap.get(key).getPrice() * count;
    }

    public Double getDiscountedPrice(Character name, Long count) {
        if(goodsMap.get(name).getPromoPrice() == null){
            throw new IllegalArgumentException("Product doesn't have discount price");
        }
        return goodsMap.get(name).getPromoPrice() * (Long) (count / goodsMap.get(name).getPromoCount()) +
                goodsMap.get(name).getPrice() * (count % goodsMap.get(name).getPromoCount());
    }
}
