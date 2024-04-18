package szanto.benjamin.etterem;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import szanto.benjamin.etterem.entity.MenuEntity;
import szanto.benjamin.etterem.exception.MenuNotFoundException;
import szanto.benjamin.etterem.repository.IMenuRepository;
import szanto.benjamin.etterem.request.MenuRequest;
import szanto.benjamin.etterem.response.MenuResponse;
import szanto.benjamin.etterem.service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class MenuServiceTests {

    @Mock
    private IMenuRepository menuRepository;

    @InjectMocks
    private MenuService menuService;

    @Test
    void saveMenuShouldGiveAppropriateValueIntoRepository(){
        MenuRequest menuRequest= new MenuRequest("Csirke ragu",200,15,500,"F");
        MenuEntity savedMenuEntity= new MenuEntity(1L, "Csirke ragu",200,15,500,"F");
        when(menuRepository.save(any(MenuEntity.class))).thenReturn(savedMenuEntity);

        MenuResponse savedMenuResponse= menuService.saveMenu(menuRequest);

        assertEquals("Csirke ragu",savedMenuResponse.getName());
        assertEquals(200,savedMenuResponse.getEnergy());
        assertEquals(15,savedMenuResponse.getCarbohydrate());
        assertEquals(500,savedMenuResponse.getPrice());
        assertEquals("F",savedMenuResponse.getCategory());

        verify(menuRepository, times(1)).save(any(MenuEntity.class));
    }

    @Test
    void getMenuByIdShouldGivenCorrectResponse(){
        MenuEntity existingMenuEntity = new MenuEntity(1L, "Csirke ragu",200,15,500,"F");
        when(menuRepository.findById(1L)).thenReturn(Optional.of(existingMenuEntity));

        MenuResponse menuResponse = menuService.getMenuById(1L);

        assertEquals("Csirke ragu", menuResponse.getName());
        assertEquals(200, menuResponse.getEnergy());
        assertEquals(15, menuResponse.getCarbohydrate());
        assertEquals(500, menuResponse.getPrice());
        assertEquals("F", menuResponse.getCategory());

        verify(menuRepository, times(1)).findById(1L);
    }

    @Test
    void getMenuByIdShouldNotFoundTheEntityFromRepository() {
        when(menuRepository.findById(2L)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(MenuNotFoundException.class, () -> {
            menuService.getMenuById(2L);
        });

        verify(menuRepository, times(1)).findById(2L);
    }

    @Test
    void getMenusShouldGivenTheCorrectResponses(){
        // Arrange
        List<MenuEntity> menuEntities = new ArrayList<>();
        menuEntities.add(new MenuEntity(1L, "Menu 1", 300, 20, 600, "F"));
        menuEntities.add(new MenuEntity(2L, "Menu 2", 250, 15, 550, "D"));
        when(menuRepository.findAll()).thenReturn(menuEntities);

        // Act
        Iterable<MenuResponse> menuResponses = menuService.getMenus();

        // Assert
        List<MenuResponse> expectedMenuResponses = new ArrayList<>();
        expectedMenuResponses.add(new MenuResponse(menuEntities.get(0)));
        expectedMenuResponses.add(new MenuResponse(menuEntities.get(1)));

        assertEquals(expectedMenuResponses.size(), ((List<MenuResponse>) menuResponses).size());
        for (int i = 0; i < expectedMenuResponses.size(); i++) {
            assertEquals(expectedMenuResponses.get(i).getName(), ((List<MenuResponse>) menuResponses).get(i).getName());
            assertEquals(expectedMenuResponses.get(i).getEnergy(), ((List<MenuResponse>) menuResponses).get(i).getEnergy());
            assertEquals(expectedMenuResponses.get(i).getCarbohydrate(), ((List<MenuResponse>) menuResponses).get(i).getCarbohydrate());
            assertEquals(expectedMenuResponses.get(i).getPrice(), ((List<MenuResponse>) menuResponses).get(i).getPrice());
            assertEquals(expectedMenuResponses.get(i).getCategory(), ((List<MenuResponse>) menuResponses).get(i).getCategory());
        }

        verify(menuRepository, times(1)).findAll();
    }

    @Test
    void updateMenuShouldShouldUpdateData(){
        // Arrange
        Long id = 1L;
        MenuRequest menuRequest = new MenuRequest("Updated Menu", 400, 25, 700, "F");
        MenuEntity existingMenuEntity = new MenuEntity(id, "Existing Menu", 300, 20, 600, "F");
        when(menuRepository.findById(id)).thenReturn(Optional.of(existingMenuEntity));
        when(menuRepository.save(any(MenuEntity.class))).thenAnswer(invocation -> invocation.getArgument(0)); // Echo back the modified entity

        // Act
        MenuResponse updatedMenuResponse = menuService.updateMenu(id, menuRequest);

        // Assert
        assertEquals("Updated Menu", updatedMenuResponse.getName());
        assertEquals(400, updatedMenuResponse.getEnergy());
        assertEquals(25, updatedMenuResponse.getCarbohydrate());
        assertEquals(700, updatedMenuResponse.getPrice());
        assertEquals("F", updatedMenuResponse.getCategory());

        verify(menuRepository, times(1)).findById(id);
        verify(menuRepository, times(1)).save(any(MenuEntity.class));
    }

    @Test
    void updateMenuShouldGivenNotFoundException() {
        // Arrange
        Long id = 2L;
        MenuRequest menuRequest = new MenuRequest("Updated Menu", 400, 25, 700, "F");
        when(menuRepository.findById(id)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(MenuNotFoundException.class, () -> {
            menuService.updateMenu(id, menuRequest);
        });

        verify(menuRepository, times(1)).findById(id);
        verify(menuRepository, never()).save(any(MenuEntity.class));
    }

    @Test
    void getDessertsShouldGiveAllOfDessertsData() {
        // Arrange
        List<MenuEntity> desserts = new ArrayList<>();
        desserts.add(new MenuEntity(1L, "Chocolate Cake", 400, 30, 800, "D"));
        desserts.add(new MenuEntity(2L, "Tiramisu", 350, 25, 700, "D"));
        desserts.add(new MenuEntity(3L, "Cheesecake", 380, 28, 750, "D"));

        when(menuRepository.findAllByCategory("D")).thenReturn(desserts);

        // Act
        Iterable<MenuResponse> dessertResponses = menuService.getDesserts();

        // Assert
        List<MenuResponse> dessertResponseList = new ArrayList<>();
        dessertResponses.forEach(dessertResponseList::add);

        assertEquals(3, dessertResponseList.size());

        // Check each dessert response
        MenuResponse firstDessert = dessertResponseList.get(0);
        assertEquals("Chocolate Cake", firstDessert.getName());
        assertEquals(400, firstDessert.getEnergy());
        assertEquals(30, firstDessert.getCarbohydrate());
        assertEquals(800, firstDessert.getPrice());
        assertEquals("D", firstDessert.getCategory());

        MenuResponse secondDessert = dessertResponseList.get(1);
        assertEquals("Tiramisu", secondDessert.getName());
        assertEquals(350, secondDessert.getEnergy());
        assertEquals(25, secondDessert.getCarbohydrate());
        assertEquals(700, secondDessert.getPrice());
        assertEquals("D", secondDessert.getCategory());

        MenuResponse thirdDessert = dessertResponseList.get(2);
        assertEquals("Cheesecake", thirdDessert.getName());
        assertEquals(380, thirdDessert.getEnergy());
        assertEquals(28, thirdDessert.getCarbohydrate());
        assertEquals(750, thirdDessert.getPrice());
        assertEquals("D", thirdDessert.getCategory());
    }

    @Test
    void getMainCoursesShouldGivenAllOfMainCourses() {
        // Arrange
        List<MenuEntity> mainCourses = new ArrayList<>();
        mainCourses.add(new MenuEntity(1L, "Grilled Chicken", 400, 25, 800, "F"));
        mainCourses.add(new MenuEntity(2L, "Beef Steak", 450, 30, 1000, "F"));
        mainCourses.add(new MenuEntity(3L, "Salmon Fillet", 380, 20, 900, "F"));

        when(menuRepository.findAllByCategory("F")).thenReturn(mainCourses);

        // Act
        Iterable<MenuResponse> mainCourseResponses = menuService.getMainCourses();

        // Assert
        List<MenuResponse> mainCourseResponseList = new ArrayList<>();
        mainCourseResponses.forEach(mainCourseResponseList::add);

        assertEquals(3, mainCourseResponseList.size());

        // Check each main course response
        MenuResponse firstMainCourse = mainCourseResponseList.get(0);
        assertEquals("Grilled Chicken", firstMainCourse.getName());
        assertEquals(400, firstMainCourse.getEnergy());
        assertEquals(25, firstMainCourse.getCarbohydrate());
        assertEquals(800, firstMainCourse.getPrice());
        assertEquals("F", firstMainCourse.getCategory());

        MenuResponse secondMainCourse = mainCourseResponseList.get(1);
        assertEquals("Beef Steak", secondMainCourse.getName());
        assertEquals(450, secondMainCourse.getEnergy());
        assertEquals(30, secondMainCourse.getCarbohydrate());
        assertEquals(1000, secondMainCourse.getPrice());
        assertEquals("F", secondMainCourse.getCategory());

        MenuResponse thirdMainCourse = mainCourseResponseList.get(2);
        assertEquals("Salmon Fillet", thirdMainCourse.getName());
        assertEquals(380, thirdMainCourse.getEnergy());
        assertEquals(20, thirdMainCourse.getCarbohydrate());
        assertEquals(900, thirdMainCourse.getPrice());
        assertEquals("F", thirdMainCourse.getCategory());
    }

    @Test
    void getSoupsShouldGivenAllOfSoups() {
        // Arrange
        List<MenuEntity> soups = new ArrayList<>();
        soups.add(new MenuEntity(1L, "Paradicsomleves", 310, 9, 600, "L"));
        soups.add(new MenuEntity(2L, "Gombaleves", 250, 7, 550, "L"));
        soups.add(new MenuEntity(3L, "Zöldborsókrémleves", 280, 8, 580, "L"));

        when(menuRepository.findAllByCategory("L")).thenReturn(soups);

        // Act
        Iterable<MenuResponse> soupResponses = menuService.getSoups();

        // Assert
        List<MenuResponse> soupResponseList = new ArrayList<>();
        soupResponses.forEach(soupResponseList::add);

        assertEquals(3, soupResponseList.size());

        // Check each soup response
        MenuResponse firstSoup = soupResponseList.get(0);
        assertEquals("Paradicsomleves", firstSoup.getName());
        assertEquals(310, firstSoup.getEnergy());
        assertEquals(9, firstSoup.getCarbohydrate());
        assertEquals(600, firstSoup.getPrice());
        assertEquals("L", firstSoup.getCategory());

        MenuResponse secondSoup = soupResponseList.get(1);
        assertEquals("Gombaleves", secondSoup.getName());
        assertEquals(250, secondSoup.getEnergy());
        assertEquals(7, secondSoup.getCarbohydrate());
        assertEquals(550, secondSoup.getPrice());
        assertEquals("L", secondSoup.getCategory());

        MenuResponse thirdSoup = soupResponseList.get(2);
        assertEquals("Zöldborsókrémleves", thirdSoup.getName());
        assertEquals(280, thirdSoup.getEnergy());
        assertEquals(8, thirdSoup.getCarbohydrate());
        assertEquals(580, thirdSoup.getPrice());
        assertEquals("L", thirdSoup.getCategory());
    }

}
