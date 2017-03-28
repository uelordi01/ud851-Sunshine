import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;

import com.example.android.sunshine.R;

import java.util.prefs.Preferences;

/**
 * Created by uelordi on 10/03/17.
 */

public class SettingsFramgment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener{

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_general);
        SharedPreferences sp = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen ps = getPreferenceScreen();
        int count = ps.getPreferenceCount();
        for (int i=0;i < count; i++)
        {
            Preference p = ps.getPreference(i);
            if(!( p instanceof CheckBoxPreference) )
            {
                String value = sp.getString(p.getKey(),"");
                setPreferenceSummary(p,value);
            }

        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (null != preference) {
            if (!(preference instanceof CheckBoxPreference)) {
                setPreferenceSummary(preference, sharedPreferences.getString(key, ""));
            }
        }
    }
    public void setPreferenceSummary(Preference preferences, Object value)
    {
        String _value = value.toString();
        String _key = preferences.getKey();

        if( preferences instanceof ListPreference )
        {
            ListPreference lp = (ListPreference) preferences;
            int prefIndex = lp.findIndexOfValue(_value);
            if( prefIndex >= 0)
            {
               preferences.setSummary(lp.getEntries()[prefIndex]);
            }
            else
            {
                preferences.setSummary(_value);
            }
        }

    }
    @Override
    public void onStop() {
        super.onStop();
        /* Unregister the preference change listener */
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    // COMPLETED (12) Register SettingsFragment (this) as a SharedPreferenceChangedListener in onStart
    @Override
    public void onStart() {
        super.onStart();
        /* Register the preference change listener */
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }


}
