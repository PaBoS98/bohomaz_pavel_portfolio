package com.dto.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Ads {

    private String name;
    private String description;
    private String[] linksPhoto;
    private int price;

    public Ads() {

    }

}
