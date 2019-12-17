package com.littlexx.SpringMvcDemo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Date;

public class Spittle {

    private final Long id;
    private final String message;
    private final Date date;
    private Double longitude;
    private Double latitude;

    public Spittle(String message, Date date) {
        this(null, message, date, null, null);
    }

    public Spittle(Long id, String message, Date date, Double longitude, Double latitude) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getDate() {
        return date;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
