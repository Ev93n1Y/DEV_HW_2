import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

class BasketTest {
    @Test
    void testThatGetItemsAmountWorksOk(){
        Map<String, Map<Character, Long>>  testGoods = new HashMap<>();
        testGoods.put("", Map.of());
        testGoods.put("A", Map.of('A', 1L));
        testGoods.put("AA", Map.of('A', 2L));
        testGoods.put("AAA", Map.of('A', 3L));
        testGoods.put("AAAB", Map.of('A', 3L, 'B', 1L));
        testGoods.put("AAABB", Map.of('A', 3L, 'B', 2L));
        testGoods.put("AAABBB", Map.of('A', 3L, 'B', 3L));
        testGoods.put("ABABAB", Map.of('A', 3L, 'B', 3L));
        testGoods.put("BABABA", Map.of('A', 3L, 'B', 3L));
        testGoods.put("BBBAAA", Map.of('A', 3L, 'B', 3L));
        testGoods.put("ABCDAADCBA", Map.of('A', 4L, 'B', 2L,
                'C', 2L, 'D', 2L));
        testGoods.put("ABCDAADCBADD", Map.of('A', 4L, 'B', 2L,
                'C', 2L, 'D', 4L));
        testGoods.forEach((key, value) ->
                Assertions.assertEquals(testGoods.get(key), Basket.getItemsAmountMap(key)));
    }

}