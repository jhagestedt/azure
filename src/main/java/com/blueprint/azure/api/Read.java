package com.blueprint.azure.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Read {

    private List<String> values;

    public Read setValues(List<String> values) {
        this.values = values;
        return this;
    }
}
