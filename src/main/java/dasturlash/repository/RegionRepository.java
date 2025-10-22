package dasturlash.repository;

import dasturlash.entity.RegionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends CrudRepository<RegionEntity, Integer> {

    Optional<RegionEntity> findByRegionKey(String key);

    boolean existsByRegionKey(String key);
}
