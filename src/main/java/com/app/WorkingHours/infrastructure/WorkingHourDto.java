package com.app.users.infrastructure;

public class WorkingHourDto {
    private Long id;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private Long barberId;

    // Empty constructor
    public WorkingHourDto() {
    }

    // Constructor with parameters
    public WorkingHourDto(Long id, String dayOfWeek, String startTime, String endTime, Long barberId) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.barberId = barberId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    @Override
    public String toString() {
        return "WorkingHourDto{" +
                "id=" + id +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", barberId=" + barberId +
                '}';
    }
}
