package uk.co.stephenheron.giantbombupcoming.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private String title;
    private String subtitle;
    private Date startDateTime;
    private String description;
    private URL imageUrl;
    private Boolean premium;

    public Event(String title, String subtitle, Date startDateTime, String description, String imageUrl, Boolean premium) {
        this.title = title;
        this.subtitle = subtitle;
        this.startDateTime = startDateTime;
        this.description = description;
        this.premium = premium;

        try {
            this.imageUrl = new URL(imageUrl);
        } catch (MalformedURLException e) {
            this.imageUrl = null;
        }

    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public String getStartDateTimeAsString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy h:m a");
        return formatter.format(startDateTime);
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
