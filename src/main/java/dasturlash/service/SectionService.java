package dasturlash.service;

import dasturlash.dto.SectionDTO;
import dasturlash.entity.SectionEntity;
import dasturlash.exp.AppBadException;
import dasturlash.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public SectionDTO create(SectionDTO dto){
        boolean exists = sectionRepository.existsBySectionKey(dto.getSectionKey().toLowerCase());
        if (exists) {
            throw new AppBadException("Section key already exists: " + dto.getSectionKey());
        }
        SectionEntity entity = new SectionEntity();
        entity.setImageId(dto.getImageId());
        entity.setNameEn(dto.getNameEn());
        entity.setNameRu(dto.getNameRu());
        entity.setNameUz(dto.getNameUz());
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setSectionKey(dto.getSectionKey().toLowerCase());
        sectionRepository.save(entity);

        entity.setId(dto.getId());
        entity.setCreatedDate(dto.getCreatedDate());

        return dto;

    }

    public boolean delete(Integer id){
        Optional<SectionEntity> byId = sectionRepository.findById(id);
        if (byId.isEmpty()) {
            return false;
        }
        sectionRepository.deleteById(id);
        return true;
    }

    public boolean update(SectionDTO dto, Integer id){
        Optional<SectionEntity> optional = sectionRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        SectionEntity entity = optional.get();
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setNameUz(dto.getNameUz());
        entity.setSectionKey(dto.getSectionKey());
        entity.setImageId(dto.getImageId());
        entity.setOrderNumber(dto.getOrderNumber());

        sectionRepository.save(entity);
        return  true;
    }
}
