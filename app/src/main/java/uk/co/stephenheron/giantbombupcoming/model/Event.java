package uk.co.stephenheron.giantbombupcoming.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Event {
    private String name;
    private Date startDateTime;
    private String description;
    private URL imageUrl;
    private Boolean premium;

    public Event(String name, Date startDateTime, String description, String imageUrl, Boolean premium) {
        this.name = name;
        this.startDateTime = startDateTime;
        this.description = description;
        this.premium = premium;

        try {
            this.imageUrl = new URL(imageUrl);
        } catch (MalformedURLException e) {
            this.imageUrl = null;
        }

    }

    public String getName() {
        return name;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getPremium() {
        return premium;
    }

    public URL getImageUrl() {
        return imageUrl;
    }
}
