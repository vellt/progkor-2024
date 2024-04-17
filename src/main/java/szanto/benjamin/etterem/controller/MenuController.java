package szanto.benjamin.etterem.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import szanto.benjamin.etterem.request.MenuRequest;
import szanto.benjamin.etterem.response.MenuResponse;
import szanto.benjamin.etterem.service.IMenuService;

@RestController
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @PostMapping("/menus")
    public MenuResponse saveMenu(@Valid @RequestBody MenuRequest menuRequest){
        return menuService.saveMenu(menuRequest);
    }

    @GetMapping("/menus")
    public Iterable<MenuResponse> getMenus(){
        return menuService.getMenus();
    }

    @GetMapping("/menus/{id}")
    public MenuResponse getMenu(@PathVariable("id") Long id){
        return  menuService.getMenuById(id);
    }

    @PutMapping("/menus/{id}")
    public MenuResponse updateMenu(@PathVariable("id") Long id, @Valid @RequestBody MenuRequest menuRequest){
        return  menuService.updateMenu(id, menuRequest);
    }

    @DeleteMapping("/menus/{id}")
    public void deleteMenu(@PathVariable("id") Long id){
        menuService.deleteMenuById(id);
    }


}
