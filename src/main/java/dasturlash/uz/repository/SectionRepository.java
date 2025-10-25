package dasturlash.uz.repository;

import dasturlash.uz.entity.SectionEntity;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<SectionEntity,Integer> {

    boolean existsBySectionKey(String key);

}
