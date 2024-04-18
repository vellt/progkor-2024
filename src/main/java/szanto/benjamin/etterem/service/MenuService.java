package szanto.benjamin.etterem.service;

import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szanto.benjamin.etterem.entity.MenuEntity;
import szanto.benjamin.etterem.exception.MenuNotFoundException;
import szanto.benjamin.etterem.repository.IMenuRepository;
import szanto.benjamin.etterem.request.MenuRequest;
import szanto.benjamin.etterem.response.MenuResponse;





@Service
public class MenuService implements IMenuService {

    // dependency injection
    @Autowired
    private IMenuRepository menuRepository;

    @Override
    public MenuResponse saveMenu(MenuRequest menuRequest) {
        MenuEntity menuEntity = MenuEntity.builder()
                .name(menuRequest.getName())
                .energy(menuRequest.getEnergy())
                .carbohydrate(menuRequest.getCarbohydrate())
                .price(menuRequest.getPrice())
                .category(menuRequest.getCategory())
                .build();

        return new MenuResponse(menuRepository.save(menuEntity));
    }

    @Override
    @SneakyThrows
    public MenuResponse getMenuById(Long id) {
        return new MenuResponse(menuRepository.findById(id).orElseThrow(MenuNotFoundException::new));
    }

    @Override
    @SneakyThrows
    public MenuResponse updateMenu(Long id, MenuRequest menuRequest) {
        MenuEntity menuEntity = menuRepository.findById(id).orElseThrow(MenuNotFoundException::new);
        menuEntity.setName(menuRequest.getName());
        menuEntity.setEnergy(menuRequest.getEnergy());
        menuEntity.setCarbohydrate(menuRequest.getCarbohydrate());
        menuEntity.setPrice(menuRequest.getPrice());
        menuEntity.setCategory(menuRequest.getCategory());
        return new MenuResponse(menuRepository.save(menuEntity));
    }

    @Override
    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public Iterable<MenuResponse> getMenus() {
        List<MenuResponse> menuResponses = new ArrayList<>();
        for (MenuEntity entity : menuRepository.findAll()) {
            menuResponses.add(new MenuResponse(entity));
        }
        return menuResponses;
    }

    @Override
    public Iterable<MenuResponse> getDesserts() {
        List<MenuResponse> menuResponses = new ArrayList<>();
        for (MenuEntity entity : menuRepository.findAllByCategory("D")) {
            menuResponses.add(new MenuResponse(entity));
        }
        return menuResponses;
    }

    @Override
    public Iterable<MenuResponse> getMainCourses() {
        List<MenuResponse> menuResponses = new ArrayList<>();
        for (MenuEntity entity : menuRepository.findAllByCategory("F")) {
            menuResponses.add(new MenuResponse(entity));
        }
        return menuResponses;
    }

    @Override
    public Iterable<MenuResponse> getSoups() {
        List<MenuResponse> menuResponses = new ArrayList<>();
        for (MenuEntity entity : menuRepository.findAllByCategory("L")) {
            menuResponses.add(new MenuResponse(entity));
        }
        return menuResponses;
    }
}
