package ait.imagga.colors;

import lombok.Getter;

import java.util.List;


@Getter
public class ColorsDto {
    private List<ColorDto> background_colors;
    private List<ColorDto> foreground_colors;
    private List<ColorDto> image_colors;
}
