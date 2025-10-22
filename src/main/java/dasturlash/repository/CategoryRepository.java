package dasturlash.repository;

import dasturlash.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity , Integer> {

    boolean existsByCategoryKey(String key);
}
