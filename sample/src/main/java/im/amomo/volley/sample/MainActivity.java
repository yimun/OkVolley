package im.amomo.volley.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import com.douban.volley.sample.R;
import im.amomo.volley.sample.fragment.ImageFragment;
import im.amomo.volley.sample.fragment.RequestFragment;

/**
 * Created by GoogolMo on 12/30/13.
 */
public class MainActivity extends ActionBarActivity implements DrawerFragment.DrawerCallbacks{


    private DrawerLayout mDrawerLayout;
    private DrawerFragment mDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        mDrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.left_drawer);

        mDrawerFragment.setUp(R.id.left_drawer, mDrawerLayout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public void onDrawerItemSelected(int position) {
        Fragment fragment;
        if (position == 0) {
            fragment = new RequestFragment();
        } else {
            fragment = new ImageFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
    }
}
