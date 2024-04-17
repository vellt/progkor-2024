package szanto.benjamin.etterem.model;

public class Menu {
    private long id;
    private String name;
    private int energy;
    private double carbohydrate;
    private int price;
    private String category;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", carbohydrate=" + carbohydrate +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
