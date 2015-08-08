package uk.co.stephenheron.giantbombupcoming;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import uk.co.stephenheron.giantbombupcoming.model.Event;

public class UpcomingRecyclerViewAdapter extends RecyclerView.Adapter<UpcomingRecyclerViewAdapter.ViewHolder> {

    private List<Event> upcomingEvents;

    public UpcomingRecyclerViewAdapter(List<Event> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upcoming_event, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Event event = upcomingEvents.get(position);

        viewHolder.titleTextView.setText(event.getTitle());
        viewHolder.subtitleTextView.setText(event.getSubtitle() + " - " + event.getStartDateTimeAsString());
        viewHolder.descriptionTextView.setText(event.getDescription());
        setEventImage(viewHolder.imageView, event);

        if(event.getPremium()) {
            viewHolder.itemView.findViewById(R.id.upcoming_event_premium).setVisibility(View.VISIBLE);
        }
    }

    private void setEventImage(ImageView imageView, Event event)
    {
        Context context = imageView.getContext();
        String imageUrl = event.getImageUrl().toString();
        Picasso.with(context).load(imageUrl).into(imageView);
    }

    @Override
    public int getItemCount() {
        return upcomingEvents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView subtitleTextView;
        public TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.upcoming_event_image);
            this.titleTextView = (TextView) itemView.findViewById(R.id.upcoming_event_title_text);
            this.subtitleTextView = (TextView) itemView.findViewById(R.id.upcoming_event_subtitle_text);
            this.descriptionTextView = (TextView) itemView.findViewById(R.id.upcoming_event_description);
        }
    }

}
