package dasturlash.service;

import dasturlash.dto.ProfileDTO;
import dasturlash.dto.RegionDTO;
import dasturlash.entity.ProfileEntity;
import dasturlash.enums.ProfileStatus;
import dasturlash.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileEntity create(ProfileDTO dto){

        ProfileEntity entity = new ProfileEntity();
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        entity.setPhotoId(dto.getPhotoId());
        entity.setUsername(dto.getUsername());

        profileRepository.save(entity);
        entity.setId(dto.getId());
        return entity;

    }
}
