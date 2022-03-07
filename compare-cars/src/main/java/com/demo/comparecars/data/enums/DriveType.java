package com.demo.comparecars.data.enums;

public enum DriveType {

    MON("monday"), RWD("RWD");

    private String fieldName;

    DriveType(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
