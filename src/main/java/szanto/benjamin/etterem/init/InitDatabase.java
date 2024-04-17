package szanto.benjamin.etterem.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import szanto.benjamin.etterem.entity.MenuEntity;
import szanto.benjamin.etterem.repository.IMenuRepository;

@Configuration
public class InitDatabase {

    @Autowired
    IMenuRepository repository;

    @Bean
    public CommandLineRunner initData(IMenuRepository repository) {
        return args -> {
            repository.save(
                    MenuEntity.builder()
                            .name("Almaleves")
                            .energy(130)
                            .carbohydrate(9)
                            .price(550)
                            .category("L")
                            .build()
            );
            repository.save(
                    MenuEntity.builder()
                            .name("Fehérboros gombakrémleves")
                            .energy(120)
                            .carbohydrate(4)
                            .price(550)
                            .category("L")
                            .build()
            );
            repository.save(
                    MenuEntity.builder()
                            .name("Fokhagymakrémleves")
                            .energy(360)
                            .carbohydrate(8)
                            .price(550)
                            .category("L")
                            .build()
            );
            repository.save(
                    MenuEntity.builder()
                            .name("Gyümölcsleves")
                            .energy(120)
                            .carbohydrate(14)
                            .price(550)
                            .category("L")
                            .build()
            );
            repository.save(
                    MenuEntity.builder()
                            .name("Málnakrémleves")
                            .energy(90)
                            .carbohydrate(6)
                            .price(550)
                            .category("L")
                            .build()
            );
        };
    }
}
