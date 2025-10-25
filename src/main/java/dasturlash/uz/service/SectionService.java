package dasturlash.uz.service;

import dasturlash.uz.dto.SectionDTO;
import dasturlash.uz.entity.SectionEntity;
import dasturlash.uz.exp.AppBadException;
import dasturlash.uz.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
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

    private SectionDTO toDto(SectionEntity entity) {
        SectionDTO dto = new SectionDTO();
        dto.setId(entity.getId());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setNameEn(entity.getNameEn());
        dto.setSectionKey(entity.getSectionKey());
        dto.setCreatedDate(entity.getCreatedDate());
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

    public List<SectionDTO> getAll() {
        Iterable<SectionEntity> iterable = sectionRepository.findAll();
        List<SectionDTO> dtos = new LinkedList<>();
        iterable.forEach(entity -> dtos.add(toDto(entity)));
        return dtos;
    }
}
