package com.appium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SampleDto {
    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleDto sampleDto = (SampleDto) o;
        return Objects.equals(name, sampleDto.name) && Objects.equals(description, sampleDto.description);
    }

}
