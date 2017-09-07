package info.firozansari.nestedfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

import info.firozansari.nestedfragment.fragment.ParentViewPagerFragment;
import info.firozansari.nestedfragment.fragment.SingleChildFragment;

public class TabHostFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.activity_tabhost_title);

        FragmentTabHost tabHost = new FragmentTabHost(this);
        setContentView(tabHost);

        tabHost.setup(this, getSupportFragmentManager(), R.layout.activity_nest_list);

        tabHost.addTab(tabHost.newTabSpec("ParentViewPagerFragment").setIndicator("Pager Tab"),
                ParentViewPagerFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("SingleFragment").setIndicator("Fragment Tab"),
                SingleChildFragment.class, null);
    }

}
