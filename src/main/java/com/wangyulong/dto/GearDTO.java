package com.wangyulong.dto;

public class GearDTO {

    private Integer gear_id;
    private String gear_name;

    public Integer getGear_id() {
        return gear_id;
    }

    public void setGear_id(Integer gear_id) {
        this.gear_id = gear_id;
    }

    public String getGear_name() {
        return gear_name;
    }

    public void setGear_name(String gear_name) {
        this.gear_name = gear_name;
    }

    @Override
    public String toString() {
        return "GearDTO{" +
                "gear_id=" + gear_id +
                ", gear_name='" + gear_name + '\'' +
                '}';
    }
}
