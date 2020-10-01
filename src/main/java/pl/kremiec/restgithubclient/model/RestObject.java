package pl.kremiec.restgithubclient.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RestObject {

    public RestObject() {
        this.fullName = "repository or user not found";
        this.description = "repository or user not found";
        this.cloneUrl = "repository or user not found";
        this.stars = 0;
        this.createdAt = LocalDateTime.now();
    }

    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stars;
    private LocalDateTime createdAt;

    public static class Builder {

        String fullName;
        String description;
        String cloneUrl;
        Integer stars;
        LocalDateTime createdAt;

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder cloneUrl(String cloneUrl) {
            this.cloneUrl = cloneUrl;
            return this;
        }

        public Builder stars(Integer stars) {
            this.stars = stars;
            return this;
        }

        public Builder createdAt(String date) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            this.createdAt = LocalDateTime.parse(date, dateTimeFormatter);
            return this;
        }

        public RestObject build(){
            return new RestObject(this);
        }
    }

        private RestObject(Builder builder){
            this.fullName = builder.fullName;
            this.description = builder.description;
            this.cloneUrl = builder.cloneUrl;
            this.stars = builder.stars;
            this.createdAt = builder.createdAt;
        }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public Integer getStars() {
        return stars;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

