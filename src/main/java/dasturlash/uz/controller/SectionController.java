package dasturlash.uz.controller;

import dasturlash.uz.dto.SectionDTO;
import dasturlash.uz.service.SectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping({"", "/"}) //   localhost:8080/api/v1/section
    public ResponseEntity<SectionDTO> create(@Valid @RequestBody SectionDTO dto) {
        return ResponseEntity.ok(sectionService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id){
        boolean result = sectionService.delete(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody SectionDTO dto,
                                          @PathVariable("id") Integer id){
        boolean update = sectionService.update(dto, id);
        return ResponseEntity.ok(update);
    }

    @GetMapping("")
    public ResponseEntity<List<SectionDTO>> all() {
        return ResponseEntity.ok(sectionService.getAll());
    }
}
