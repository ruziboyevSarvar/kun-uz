package dasturlash.controller;

import dasturlash.dto.RegionDTO;
import dasturlash.service.RegionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping({"", "/"}) //   localhost:8080/api/v1/region
    public ResponseEntity<RegionDTO> create(@Valid @RequestBody RegionDTO dto) {
        return ResponseEntity.ok(regionService.create(dto));
    }


}
