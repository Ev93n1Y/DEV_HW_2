import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final Map<Character, Goods> goodsMap = new HashMap<>();

    public void addGoods(Goods goods) {
        goodsMap.put(goods.getName(), goods);
    }

    public Map<Character, Goods> getGoodsMap(){
        return goodsMap;
    }
}
