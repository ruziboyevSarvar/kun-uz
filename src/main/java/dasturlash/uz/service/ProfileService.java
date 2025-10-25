package dasturlash.uz.service;

import dasturlash.uz.dto.ProfileDTO;
import dasturlash.uz.entity.ProfileEntity;
import dasturlash.uz.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
