package dasturlash.service;

import dasturlash.dto.CategoryDTO;
import dasturlash.dto.RegionDTO;
import dasturlash.entity.CategoryEntity;
import dasturlash.entity.RegionEntity;
import dasturlash.exp.AppBadException;
import dasturlash.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO create(CategoryDTO dto) {
        boolean exists = categoryRepository.existsByCategoryKey(dto.getCategoryKey().toLowerCase());
        if (exists) {
            throw new AppBadException("Category key already exists: " + dto.getCategoryKey());
        }

        CategoryEntity entity = new CategoryEntity();
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setCategoryKey(dto.getCategoryKey().toLowerCase());

        categoryRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public boolean delete(Integer id){
        Optional<CategoryEntity> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    public boolean update(CategoryDTO dto, Integer id){
        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        CategoryEntity entity = optional.get();
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setNameUz(dto.getNameUz());
        entity.setCategoryKey(dto.getCategoryKey());
        entity.setOrderNumber(dto.getOrderNumber());

       categoryRepository.save(entity);
        return  true;
    }
}
