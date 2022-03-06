package com.demo.comparecars.data.enums;

public enum FieldType {

    BODY_TYPE("bodyType"),
    FUEL_TYPE("fuelType"),
    PRICE("price");

    private String fieldName;

    FieldType(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }


}
