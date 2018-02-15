package info.firozansari.nestedfragment.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import info.firozansari.nestedfragment.R;

public class AttachFragmentActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG_KEY = "FragmentTagKey";
    public static final String ACTIVITY_TITLE_KEY = "ActivityTitleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.attach_fragment);

        Bundle extras = getIntent().getExtras();
        String tag = extras.getString(FRAGMENT_TAG_KEY);
        String title = getString(extras.getInt(ACTIVITY_TITLE_KEY));

        setTitle(title);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(tag);

        if (fragment == null) {
            fragment = Fragment.instantiate(this, tag);
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.main_content_frame, fragment, tag);
            ft.commit();
        }
    }

}
