package com.app.locations.infrastructure;

public class LocationDto {
    private Long id;
    private String name;
    private String address;

    // Empty constructor
    public LocationDto() {
    }

    // Constructor with parameters
    public LocationDto(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString() method
    @Override
    public String toString() {
        return "LocationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
