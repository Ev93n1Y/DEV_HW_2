import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basket {
    public static Map<Character, Long> getItemsAmountMap(String goods) {
        return goods.toUpperCase().chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
    }

}
