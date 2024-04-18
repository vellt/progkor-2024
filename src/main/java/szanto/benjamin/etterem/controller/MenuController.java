package szanto.benjamin.etterem.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import szanto.benjamin.etterem.request.MenuRequest;
import szanto.benjamin.etterem.response.MenuResponse;
import szanto.benjamin.etterem.service.IMenuService;

@RestController
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @PostMapping("/menus")
    public MenuResponse saveMenu(@Valid @RequestBody MenuRequest menuRequest) {
        return menuService.saveMenu(menuRequest);
    }

    @GetMapping("/menus/{id}")
    public MenuResponse getMenu(@PathVariable("id") Long id) {
        return  menuService.getMenuById(id);
    }

    @PutMapping("/menus/{id}")
    public MenuResponse updateMenu(@PathVariable("id") Long id, @Valid @RequestBody MenuRequest menuRequest) {
        return  menuService.updateMenu(id, menuRequest);
    }

    @DeleteMapping("/menus/{id}")
    public void deleteMenu(@PathVariable("id") Long id) {
        menuService.deleteMenuById(id);
    }

    @GetMapping("/menus")
    public Iterable<MenuResponse> getMenus() {
        return menuService.getMenus();
    }

    @GetMapping("/desserts")
    public Iterable<MenuResponse> getDesserts() {
        return menuService.getDesserts();
    }

    @GetMapping("/main-courses")
    public Iterable<MenuResponse> getMainCourses() {
        return menuService.getMainCourses();
    }

    @GetMapping("/soups")
    public Iterable<MenuResponse> getSoups() {
        return menuService.getSoups();
    }
}
