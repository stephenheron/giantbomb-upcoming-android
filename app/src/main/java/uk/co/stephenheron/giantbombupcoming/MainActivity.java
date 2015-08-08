package uk.co.stephenheron.giantbombupcoming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uk.co.stephenheron.giantbombupcoming.model.Event;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeRecyclerView();
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
                "Quick Look: Beyond Eyes",
                new Date(),
                "A game about a blind 10 year-old girl who is looking for her pet cat. Developed by Tiger & Squid and published by Team 17.",
                "http://static.giantbomb.com/uploads/scale_super/18/187968/2731674-rsz_479001_251903824954442_1046625792_o.jpg",
                false
        ));

        upcomingEvents.add(new Event(
                "Quick Look: Submerged",
                new Date(),
                "A game about being trapped in an ancient, half-submerged city",
                "http://static.giantbomb.com/uploads/scale_super/8/84290/2771166-2347371421-heade.jpg",
                false
        ));

        upcomingEvents.add(new Event(
                "Unfinished: Armello 08/06/2015",
                new Date(),
                "Armello is a tablet multiplayer card and board game set in a fairy-tale animal kingdom. It is the debut title from League of Geeks.",
                "http://static.giantbomb.com/uploads/scale_super/0/1992/2529920-screen+shot+2013-08-15+at+1.53.51+pm.png",
                false
        ));

        upcomingEvents.add(new Event(
                "Metal Gear Scanlon 4 - Part 09",
                new Date(),
                "Kept you waiting huh?",
                "http://static.giantbomb.com/uploads/scale_super/0/8273/2676362-2675497-metal%2Bgear%2Bscanlon%2Blogo.jpg",
                true
        ));

        return upcomingEvents;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
