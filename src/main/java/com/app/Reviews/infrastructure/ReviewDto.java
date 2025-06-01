package com.app.reviews.infrastructure;

public class ReviewDto {
    private Long id;
    private Integer rating;
    private String comment;
    private Long userId;
    private Long serviceId;

    public ReviewDto() {}

    public ReviewDto(Long id, Integer rating, String comment, Long userId, Long serviceId) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.userId = userId;
        this.serviceId = serviceId;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
               "id=" + id +
               ", rating=" + rating +
               ", comment='" + comment + '\'' +
               ", userId=" + userId +
               ", serviceId=" + serviceId +
               '}';
    }
}
