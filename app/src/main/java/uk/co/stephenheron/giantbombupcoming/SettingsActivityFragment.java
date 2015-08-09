package uk.co.stephenheron.giantbombupcoming;

import android.preference.CheckBoxPreference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.os.Bundle;

import java.util.ArrayList;

import uk.co.stephenheron.giantbombupcoming.model.Category;


public class SettingsActivityFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        PreferenceCategory targetPreferenceCategory = (PreferenceCategory)findPreference("notifications");
        for(Category category: getCategories()) {
            CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this.getActivity());
            checkBoxPreference.setKey(category.getId());
            checkBoxPreference.setTitle(category.getName());
            checkBoxPreference.setDefaultValue(true);

            targetPreferenceCategory.addPreference(checkBoxPreference);
        }

    }

    private ArrayList<Category> getCategories()
    {
        ArrayList<Category> categories = new ArrayList<Category>();

        categories.add(new Category("Quick Look", "quick_look"));
        categories.add(new Category("Upcoming", "upcoming"));
        categories.add(new Category("Unprofessional Fridays", "unprofessional_fridays"));
        categories.add(new Category("Live Steams", "live_streams"));
        categories.add(new Category("Others", "others"));

        return categories;
    }
}
