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

            repository.save(
                    MenuEntity.builder()
                            .name("Málnakrémleves")
                            .energy(90)
                            .carbohydrate(6)
                            .price(550)
                            .category("L")
                            .build()
            );
            repository.save(
                    MenuEntity.builder()
                            .name("Paradicsomleves")
                            .energy(310)
                            .carbohydrate(9)
                            .price(600)
                            .category("L")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Póréhagyma krémleves")
                            .energy(360)
                            .carbohydrate(8)
                            .price(550)
                            .category("L")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Szederkrémleves")
                            .energy(110)
                            .carbohydrate(5)
                            .price(550)
                            .category("L")
                            .build()
            );
            repository.save(
                    MenuEntity.builder()
                            .name("Szilvaleves")
                            .energy(110)
                            .carbohydrate(12)
                            .price(550)
                            .category("L")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Tárkonyos csirkeraguleves")
                            .energy(290)
                            .carbohydrate(9)
                            .price(600)
                            .category("L")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Kapros tökfőzelék vagdalttal")
                            .energy(440)
                            .carbohydrate(23)
                            .price(880)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Parajfőzelék vagdalttal")
                            .energy(520)
                            .carbohydrate(7)
                            .price(920)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Rántott csirkemell meggymártással")
                            .energy(490)
                            .carbohydrate(13)
                            .price(1040)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Sóskafőzelék tükörtojással")
                            .energy(290)
                            .carbohydrate(6)
                            .price(840)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Zöldbabfőzelék rántott csirkemellel")
                            .energy(670)
                            .carbohydrate(22)
                            .price(970)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Zöldborsófőzelék töltött csirkemellel")
                            .energy(720)
                            .carbohydrate(24)
                            .price(920)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Cordon Bleu csirkemell spárgapürével")
                            .energy(700)
                            .carbohydrate(12)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Csirkepaprikás galuskával")
                            .energy(520)
                            .carbohydrate(8)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Fehérboros csirkemell paradicsomsalátával")
                            .energy(410)
                            .carbohydrate(10)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Gombás-tejszínes pulykamellszelet galuskával")
                            .energy(470)
                            .carbohydrate(17)
                            .price(970)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Joghurtos csirkecomb galuskával")
                            .energy(600)
                            .carbohydrate(9)
                            .price(1040)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Májjal töltött rántott pulykamell salátával")
                            .energy(490)
                            .carbohydrate(12)
                            .price(1090)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Mézes-mustáros csirkecomb párolt karfiollal")
                            .energy(510)
                            .carbohydrate(13)
                            .price(970)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Pirított pulykamell sopszka salátával")
                            .energy(350)
                            .carbohydrate(9)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Pulykaragu pitában zöldsalátával és joghurtos önte")
                            .energy(380)
                            .carbohydrate(7)
                            .price(980)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Sült csirkecomb tejszínes gombamártással")
                            .energy(590)
                            .carbohydrate(5)
                            .price(970)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Sült csirkemell tojásos zöldsalátával")
                            .energy(440)
                            .carbohydrate(5)
                            .price(1080)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Sült csirkemellcsíkok almás salátával")
                            .energy(470)
                            .carbohydrate(14)
                            .price(1080)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Sült pulykacomb mozzarellás sült zöldségekkel")
                            .energy(550)
                            .carbohydrate(18)
                            .price(1160)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Vadas pulykatokány spagettivel")
                            .energy(500)
                            .carbohydrate(12)
                            .price(1040)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Vajban sült csirkemell paradicsomos gombasalátával")
                            .energy(310)
                            .carbohydrate(9)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Csőben sült brokkoli sajttal")
                            .energy(340)
                            .carbohydrate(10)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Rakott karalábé (pulykacombból)")
                            .energy(500)
                            .carbohydrate(25)
                            .price(1040)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Rakott sajtos patisszon")
                            .energy(590)
                            .carbohydrate(25)
                            .price(1000)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Rántott cukkini almás sajtsalátával")
                            .energy(560)
                            .carbohydrate(30)
                            .price(1000)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Székelykáposzta (pulykacombból)")
                            .energy(390)
                            .carbohydrate(15)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Tojásos lecsó virslivel és galuskával")
                            .energy(630)
                            .carbohydrate(8)
                            .price(1000)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Töltött padlizsán tejfölös zöldmártással")
                            .energy(470)
                            .carbohydrate(21)
                            .price(1000)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Csirkés pizza")
                            .energy(930)
                            .carbohydrate(14)
                            .price(1470)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Juhtúrós sztrapacska")
                            .energy(790)
                            .carbohydrate(8)
                            .price(1040)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Milánói spagetti")
                            .energy(470)
                            .carbohydrate(14)
                            .price(1090)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Mustáros szűzpecsenye spagettivel")
                            .energy(470)
                            .carbohydrate(12)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Négysajtos pizza")
                            .energy(770)
                            .carbohydrate(11)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Sajtos-sonkás pizza")
                            .energy(780)
                            .carbohydrate(10)
                            .price(1210)
                            .category("F")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Almás-fahéjas palacsinta vaníliaöntettel")
                            .energy(130)
                            .carbohydrate(9)
                            .price(470)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Barackos lepény")
                            .energy(190)
                            .carbohydrate(6)
                            .price(480)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Császármorzsa")
                            .energy(330)
                            .carbohydrate(14)
                            .price(550)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Cseresznyés pite")
                            .energy(220)
                            .carbohydrate(10)
                            .price(480)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Máglyarakás")
                            .energy(310)
                            .carbohydrate(11)
                            .price(550)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Meggyes piskóta")
                            .energy(330)
                            .carbohydrate(18)
                            .price(480)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Somlói galuska")
                            .energy(380)
                            .carbohydrate(9)
                            .price(470)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Szilvás lepény")
                            .energy(340)
                            .carbohydrate(20)
                            .price(480)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Túrógombóc fahéjas öntettel")
                            .energy(440)
                            .carbohydrate(11)
                            .price(600)
                            .category("D")
                            .build()
            );

            repository.save(
                    MenuEntity.builder()
                            .name("Túrós palacsinta eperöntettel")
                            .energy(240)
                            .carbohydrate(9)
                            .price(480)
                            .category("D")
                            .build()
            );

        };
    }
}
