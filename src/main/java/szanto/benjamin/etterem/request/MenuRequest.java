package szanto.benjamin.etterem.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import szanto.benjamin.etterem.entity.MenuEntity;
import szanto.benjamin.etterem.model.Menu;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MenuRequest {

    @NotEmpty
    @NotNull
    private String name;

    @PositiveOrZero
    private int energy;

    @PositiveOrZero
    private double carbohydrate;

    @PositiveOrZero
    private int price;

    @NotEmpty
    @NotNull
    private String category;
}
