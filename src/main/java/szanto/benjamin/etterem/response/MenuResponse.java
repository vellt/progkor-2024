package szanto.benjamin.etterem.response;

import lombok.Getter;
import lombok.Setter;
import szanto.benjamin.etterem.entity.MenuEntity;

@Getter
@Setter
public class MenuResponse {
    private long id;

    private String name;

    private int energy;

    private double carbohydrate;

    private int price;

    private String category;

    public MenuResponse(MenuEntity menuEntity) {
        this.id = menuEntity.getId();
        this.name = menuEntity.getName();
        this.energy = menuEntity.getEnergy();
        this.carbohydrate = menuEntity.getCarbohydrate();
        this.price = menuEntity.getPrice();
        this.category = menuEntity.getCategory();
    }
}
