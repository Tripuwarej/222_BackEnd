package sit.int221.oasip.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int221.oasip.Entity.role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditUserDTO {
    private String name;
    private String email;
    private sit.int221.oasip.Entity.role role;
}
