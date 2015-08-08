package uk.co.stephenheron.giantbombupcoming;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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

        viewHolder.textView.setText(event.getName());
        setEventImage(viewHolder.imageView, event);
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
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.upcoming_event_info_text);
            this.imageView = (ImageView) itemView.findViewById(R.id.upcoming_event_image);
        }
    }

}
