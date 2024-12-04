package com.drm.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String emailId;
    private String mobile;
}
