public class Goods {
    private Character name;
    private Double price;
    private Integer promoCount;
    private Double promoPrice;

    public Goods(Character name, Double price, Integer promoCount, Double promoPrice) {
        this(name, price);
        this.promoCount = promoCount;
        this.promoPrice = promoPrice;
    }

    public Goods(Character name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Character getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPromoCount() {
        return promoCount;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

}
