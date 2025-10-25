package dasturlash.uz.controller;

import dasturlash.uz.dto.RegionDTO;
import dasturlash.uz.service.RegionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping({"", "/"}) //   localhost:8080/api/v1/region
    public ResponseEntity<RegionDTO> create(@Valid @RequestBody RegionDTO dto) {
        return ResponseEntity.ok(regionService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id){
        boolean result = regionService.delete(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody RegionDTO dto,
                                          @PathVariable("id") Integer id){
        boolean update = regionService.update(dto, id);
        return ResponseEntity.ok(update);
    }

    @GetMapping("")
    public ResponseEntity<List<RegionDTO>> all() {
        return ResponseEntity.ok(regionService.getAll());
    }




}
