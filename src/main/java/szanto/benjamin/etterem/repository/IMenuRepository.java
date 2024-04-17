package szanto.benjamin.etterem.repository;

import org.springframework.data.repository.CrudRepository;
import szanto.benjamin.etterem.entity.MenuEntity;

public interface IMenuRepository extends CrudRepository<MenuEntity, Long> {

    // plus lekérdezéseket lehet írni elnevezési konvenciók használatával
}
