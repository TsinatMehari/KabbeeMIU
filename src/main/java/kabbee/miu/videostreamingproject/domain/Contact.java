package kabbee.miu.videostreamingproject.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contact {
    private String phone;
    @Email
    @NotNull(message="email should not be empty")
    private String email;
}
