package dasturlash.uz.controller;

import dasturlash.uz.dto.CategoryDTO;
import dasturlash.uz.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping({"", "/"}) //   localhost:8080/api/v1/category
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO dto) {
        return ResponseEntity.ok(categoryService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id){
        boolean result = categoryService.delete(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@RequestBody CategoryDTO dto,
                                          @PathVariable("id") Integer id){
        boolean update = categoryService.update(dto, id);
        return ResponseEntity.ok(update);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> all() {
        return ResponseEntity.ok(categoryService.getAll());
    }

}
