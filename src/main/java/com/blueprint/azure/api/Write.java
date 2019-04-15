package com.blueprint.azure.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Write {

    private String value;

    public Write setValue(String value) {
        this.value = value;
        return this;
    }
}
