package com.williamspires.acnhapi.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VillagerPercentage {
    private String wants;
    private List<String> have = new ArrayList<>();
}
