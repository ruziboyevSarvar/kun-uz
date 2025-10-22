package dasturlash.dto;

import dasturlash.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileDTO {
    private Integer id;
    private String name;
    private String surname;
    private String username;   // login, email yoki phone
    private String password;
    private ProfileStatus status;
    private String photoId;
    private Boolean visible;
    private LocalDateTime createdDate;
}
