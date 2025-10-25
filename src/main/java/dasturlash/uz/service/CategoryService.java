package dasturlash.uz.service;

import dasturlash.uz.dto.CategoryDTO;
import dasturlash.uz.entity.CategoryEntity;
import dasturlash.uz.exp.AppBadException;
import dasturlash.uz.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
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

    private CategoryDTO toDto(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setNameEn(entity.getNameEn());
        dto.setCategoryKey(entity.getCategoryKey());
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

    public List<CategoryDTO> getAll() {
        Iterable<CategoryEntity> iterable = categoryRepository.getAllByOrderSorted();
        List<CategoryDTO> dtos = new LinkedList<>();
        iterable.forEach(entity -> dtos.add(toDto(entity)));
        return dtos;
    }


}
