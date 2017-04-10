package hackathon.iron_man.Home;

/**
 * Created by Iron_Man on 12/11/16.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

import hackathon.iron_man.R;
import hackathon.iron_man.cart;
import hackathon.iron_man.navigation_drawer.FragmentDrawer;
import hackathon.iron_man.pusherchat.MainChat;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, View.OnClickListener {
    SliderLayout mDemoSlider;
    DrawerLayout mDrawer;
    private ListView list, list_nav;
    private ArrayList<Beanclass> Bean;
    private ListbaseAdapter baseAdapter;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    Context context=this;
    private int[] IMAGE = {R.drawable.slidertea, R.drawable.slider2, R.drawable.slider3,};

    private String[] TITLE = {"Electronics", "Fashion", "Home and Decor"};

    private String[] SUBTITLE = {"Great Deals on Electronics! Grab it!", "Great Deals in Fashion! Grab it!", "Great Deals on Home and deco! Grab it!"};

    private String[] SHOP = {"Shop Now", "Shop Now", "Shop Now"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        mDrawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        list = (ListView) findViewById(R.id.list);
//        ListView
        Bean = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {

            Beanclass bean = new Beanclass(IMAGE[i], TITLE[i], SUBTITLE[i], SHOP[i]);
            Bean.add(bean);

        }
        baseAdapter = new ListbaseAdapter(MainActivity.this, Bean) {
        };
        list.setAdapter(baseAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(MainActivity.this, hackathon.iron_man.Category.MainActivity.class);
                        i.putExtra("title", Bean.get(0).getTitle());                                         // Putting Title of ListItem in intent
                        startActivity(i);

                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, hackathon.iron_man.Category.MainActivity.class);
                        intent.putExtra("title", Bean.get(1).getTitle());                                            // Putting Title of ListItem in intent
                        startActivity(intent);

                        break;
                    case 2:
                        Intent in = new Intent(MainActivity.this, hackathon.iron_man.Category.MainActivity.class);
                        in.putExtra("title", Bean.get(2).getTitle());                                        // Putting Title of ListItem in intent
                        startActivity(in);

                        break;

                }
            }
        });

//        Slider
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.s1);
        file_maps.put("2", R.drawable.s2);
        file_maps.put("3", R.drawable.s3);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        // Nav drawer
        String[] web = MainActivity.this.getResources().getStringArray(R.array.nav_drawer_labels);
        Integer[] imageId = {
                R.drawable.ic_home,
                R.drawable.ic_tv,
                R.drawable.ic_ticket,
                R.drawable.ic_offers,
                R.drawable.ic_earning,
                R.drawable.ic_usemoney,
                R.drawable.ic_ranking,
                R.drawable.ic_faq,
                R.drawable.ic_symbol21,
        };

        list_nav = (ListView) findViewById(R.id.list_nav);

        CustomList adapter1 = new
                CustomList(MainActivity.this, web, imageId);

        list_nav.setAdapter(adapter1);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);

        list_nav.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_home:
                Intent intent = new Intent(hackathon.iron_man.Home.MainActivity.this, cart.class);
                intent.putExtra("title", "");
                startActivity(intent);
                break;
            case R.id.reviewChat:
                Intent i = new Intent(hackathon.iron_man.Home.MainActivity.this, MainChat.class);
                startActivity(i);
                break;

        }
    }

    // on menu click

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {
        switch (position) {
            case 0:
                Toast.makeText(context,"Clickked",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(context,"Clickked 1",Toast.LENGTH_SHORT).show();
                break;
            case 2:

                break;

            default:
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(context,"Clickked",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }



    public class CustomList extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;

        public CustomList(Activity context,
                          String[] web, Integer[] imageId) {
            super(context, R.layout.nav_drawer_row, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.nav_drawer_row, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
            txtTitle.setText(web[position]);
            imageView.setImageResource(imageId[position]);
            return rowView;
        }
    }
}



