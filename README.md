# Programozási környezetek - BPI1220L

Ez egy **Spring Boot**-os szerveroldali alkalmazás, amely egy képzeletbeli étterem ételeinek menedzselésére szolgál. Az alkalmazás támogatja a teljes **CRUD** (**C**reate **R**ead **U**pdate **D**elete) műveleteket: új ételek hozzáadását az étterem menüjéhez, valamint a meglévő ételek módosítását, törlését és lekérdezését. Az ételek lekérdezése külön útvonalakon is történhet, például  levesek, főételek és desszertek szerint.



## H2 adatbázis

Az alkalmazás H2 adatbázist használ, amely egy könnyű, beágyazott adatbázis. Az adatbázis indításkor memóriában tárolja az adatokat, így gyors hozzáférést biztosít a kezdeti adatokhoz. Az alkalmazás konfigurációja biztosítja, hogy a H2 konzol elérhető legyen a fejlesztés és hibakeresés során, valamint meghatározza az adatbázis kapcsolat beállításait.

Az alábbi konfiguráció van az alkalmazáshoz beállítva:

```properties
spring.h2.console.enabled=true  
spring.datasource.url=jdbc:h2:mem:springcore  
spring.datasource.driverClassName=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=password  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

Ezek a beállítások biztosítják, hogy az alkalmazás memóriában futó H2 adatbázist használjon a gyorsabb hozzáférés érdekében, és hogy a fejlesztők könnyen elérhessék az adatbázis konzolt a `http://localhost:8080/h2-console` URL-en keresztül. Az adatbázis konzol lehetővé teszi az adatbázis tartalmának megtekintését és módosítását a fejlesztés során.

![h2](https://raw.githubusercontent.com/vellt/progkor-2024/master/pictures/h2.png)

## Swagger UI

Az alkalmazás Swagger UI integrációval is rendelkezik, amely egy interaktív felületet biztosít az API dokumentációhoz. A Swagger UI automatikusan generálódik és lehetővé teszi a fejlesztők számára, hogy teszteljék az API végpontokat közvetlenül a böngészőből. Az API végpontok, a kérés paraméterei és a válasz formátuma mind vizuálisan jelennek meg, így könnyen érthetővé válik az API működése.

A Swagger UI az alkalmazás indítása követően az alábbi URL-en keresztül érhető el:

`http://localhost:8080/swagger-ui.html`

Ez az interaktív dokumentációs felület nagyban megkönnyíti a fejlesztést és a tesztelést, mivel valós időben lehet kipróbálni az API hívásokat, és azonnali visszajelzést kapni azok működéséről.

![swagger](https://raw.githubusercontent.com/vellt/progkor-2024/master/pictures/swaggerui.png)

## JaCoCo Kódlefedettség

Az alkalmazás JaCoCo-t használ a kódlefedettség mérésére. A JaCoCo egy nyílt forráskódú eszköz, amely pontos és részletes kódlefedettségi jelentéseket generál. Ezek a jelentések segítenek azonosítani, hogy a kódbázis mely részei vannak lefedve tesztekkel, és mely részek szorulnak további tesztelésre. A kódlefedettség javítása fontos szerepet játszik a kód minőségének és megbízhatóságának növelésében.

Az alábbi képen látható a JaCoCo által generált kódlefedettségi jelentés:

![jacoco](https://raw.githubusercontent.com/vellt/progkor-2024/master/pictures/jacoco.png)

A jelentés tartalmazza az egyes osztályok, metódusok és sorok lefedettségi arányát. A fenti képen látható, hogy a `szanto.benjamin.etterem.service` osztály 97%-os sor- és 100%-os Branch lefedettséggel rendelkezik. A JaCoCo konfigurációja az alkalmazás `pom.xml` fájljában található
