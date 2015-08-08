package uk.co.stephenheron.giantbombupcoming;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    }

    @Override
    public int getItemCount() {
        return upcomingEvents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.upcoming_event_info_text);
        }
    }

}
