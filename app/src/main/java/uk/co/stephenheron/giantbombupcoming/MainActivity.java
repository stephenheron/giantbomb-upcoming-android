package uk.co.stephenheron.giantbombupcoming;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uk.co.stephenheron.giantbombupcoming.model.Event;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDefaultValues();

        if(getUpcomingEvents().size() == 0) {
            displayNoEventsMessage();
        }

        initializeRecyclerView();
    }

    private void displayNoEventsMessage()
    {
        View upcomingList = findViewById(R.id.upcoming_recycler_view);
        View noEventsMessage = findViewById(R.id.nothing_upcoming);

        upcomingList.setVisibility(View.INVISIBLE);
        noEventsMessage.setVisibility(View.VISIBLE);
    }

    private void setDefaultValues()
    {
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    private void initializeRecyclerView()
    {
        RecyclerView upcomingRecyclerView = (RecyclerView) findViewById(R.id.upcoming_recycler_view);
        upcomingRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        upcomingRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new UpcomingRecyclerViewAdapter(getUpcomingEvents());
        upcomingRecyclerView.setAdapter(adapter);

    }

    private List<Event> getUpcomingEvents()
    {
        List<Event> upcomingEvents = new ArrayList<Event>();

        upcomingEvents.add(new Event(
                "Beyond Eyes",
                "Quick Look",
                new Date(),
                "A game about a blind 10 year-old girl who is looking for her pet cat. Developed by Tiger & Squid and published by Team 17.",
                "http://static.giantbomb.com/uploads/scale_super/18/187968/2731674-rsz_479001_251903824954442_1046625792_o.jpg",
                false
        ));

        upcomingEvents.add(new Event(
                "Submerged",
                "Quick Look",
                new Date(),
                "A game about being trapped in an ancient, half-submerged city",
                "http://static.giantbomb.com/uploads/scale_super/8/84290/2771166-2347371421-heade.jpg",
                false
        ));

        upcomingEvents.add(new Event(
                "Armello 08/06/2015",
                "Unfinished",
                new Date(),
                "Armello is a tablet multiplayer card and board game set in a fairy-tale animal kingdom. It is the debut title from League of Geeks.",
                "http://static.giantbomb.com/uploads/scale_super/0/1992/2529920-screen+shot+2013-08-15+at+1.53.51+pm.png",
                false
        ));

        upcomingEvents.add(new Event(
                "Metal Gear Scanlon 4",
                "Part 09",
                new Date(),
                "Kept you waiting huh?",
                "http://static.giantbomb.com/uploads/scale_super/0/8273/2676362-2675497-metal%2Bgear%2Bscanlon%2Blogo.jpg",
                true
        ));

        return upcomingEvents;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
