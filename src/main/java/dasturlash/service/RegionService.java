package dasturlash.service;

import dasturlash.dto.RegionDTO;
import dasturlash.dto.SectionDTO;
import dasturlash.entity.RegionEntity;
import dasturlash.entity.SectionEntity;
import dasturlash.exp.AppBadException;
import dasturlash.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public RegionDTO create(RegionDTO dto) {
        // checking ...
        boolean exists = regionRepository.existsByRegionKey(dto.getRegionKey().toLowerCase());
        if (exists) {
            throw new AppBadException("Region key exists: " + dto.getRegionKey());
        }
        RegionEntity entity = new RegionEntity();
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setRegionKey(dto.getRegionKey().toLowerCase());
//        entity.setVisible(Boolean.TRUE);
//        entity.setCreatedDate(LocalDateTime.now());
        regionRepository.save(entity);

        // response
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public boolean delete(Integer id){
        Optional<RegionEntity> byId = regionRepository.findById(id);
        if (byId.isEmpty()) {
            return false;
        }
        regionRepository.deleteById(id);
        return true;
    }

    public boolean update(RegionDTO dto, Integer id){
        Optional<RegionEntity> optional = regionRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        RegionEntity entity = optional.get();
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setNameUz(dto.getNameUz());
        entity.setRegionKey(dto.getRegionKey());
        entity.setOrderNumber(dto.getOrderNumber());

        regionRepository.save(entity);
        return  true;
    }

}
