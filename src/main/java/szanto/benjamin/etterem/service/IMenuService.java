package szanto.benjamin.etterem.service;

import szanto.benjamin.etterem.entity.MenuEntity;
import szanto.benjamin.etterem.request.MenuRequest;
import szanto.benjamin.etterem.response.MenuResponse;

public interface IMenuService {

    MenuResponse saveMenu(MenuRequest menuRequest);

    MenuResponse getMenuById(Long id);

    MenuResponse updateMenu(Long id, MenuRequest menuRequest);

    void deleteMenuById(Long id);

    Iterable<MenuResponse> getMenus();

    Iterable<MenuResponse> getDesserts();

    Iterable<MenuResponse> getMainCourses();

    Iterable<MenuResponse> getSoups();
}
