package hackathon.iron_man.Details;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import customfonts.MyTextView;
import hackathon.iron_man.R;
import hackathon.iron_man.cart;
import hackathon.iron_man.pusherchat.MainChat;

/**
 * Created by Iron_Man on 12/11/16.
 */
public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, View.OnClickListener {
    SliderLayout mDemoSlider;
    Button chatButton;
    MyTextView myTextView;
    String productname;
    LinearLayout linear0, linear1, linear2, linear3, linear4, linear5, linear6, linear20, linear7, linear8,linear10,linear11,linearRating;
    VideoView videoView;
    Context context = this;
    TextView discription3, discription2, discription1, link1, link2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        // For retrieving the product name of clicked product
        Intent i = getIntent();
//        productname = i.getStringExtra("title");
//        Log.e("ProductName String :: ", productname);

        chatButton = (Button) findViewById(R.id.chatButton);
        myTextView = (MyTextView) findViewById(R.id.buy);
        linear0 = (LinearLayout) findViewById(R.id.linear0);
        linear20 = (LinearLayout) findViewById(R.id.linear20);
        videoView = (VideoView) findViewById(R.id.video2);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);


        linear0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear20.setVisibility(View.VISIBLE);
                linear0.setVisibility(View.GONE);
                videoView.setVisibility(View.VISIBLE);
                videoView.start();
            }
        });

        linear20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear0.setVisibility(View.VISIBLE);
                linear20.setVisibility(View.GONE);
                videoView.pause();
                videoView.setVisibility(View.GONE);
            }
        });


//                ***********discription**********

        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        discription1 = (TextView) findViewById(R.id.discription1);


        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                discription1.setVisibility(View.VISIBLE);

            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.VISIBLE);
                discription1.setVisibility(View.GONE);


            }
        });

        //                ***********related video**********

        linear7 = (LinearLayout) findViewById(R.id.linear7);
        linear8 = (LinearLayout) findViewById(R.id.linear8);
        link1 = (TextView) findViewById(R.id.link1);
        link2 = (TextView) findViewById(R.id.link2);

        linear7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear8.setVisibility(View.VISIBLE);
                linear7.setVisibility(View.GONE);
                link1.setVisibility(View.VISIBLE);
                link2.setVisibility(View.VISIBLE);

            }
        });

        linear8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear7.setVisibility(View.VISIBLE);
                linear8.setVisibility(View.GONE);
                link1.setVisibility(View.GONE);
                link2.setVisibility(View.GONE);


            }
        });
 //                ***********Rating**********

        linear10 = (LinearLayout) findViewById(R.id.linear10);
        linear11 = (LinearLayout) findViewById(R.id.linear11);
        linearRating = (LinearLayout)findViewById(R.id.linearRating);
        linear10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear11.setVisibility(View.VISIBLE);
                linear10.setVisibility(View.GONE);
                linearRating.setVisibility(View.VISIBLE);

            }
        });

        linear11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear10.setVisibility(View.VISIBLE);
                linear11.setVisibility(View.GONE);
                linearRating.setVisibility(View.GONE);


            }
        });


//                ***********use and care**********

        linear3 = (LinearLayout) findViewById(R.id.linear3);
        linear4 = (LinearLayout) findViewById(R.id.linear4);
        discription2 = (TextView) findViewById(R.id.discription2);


        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear4.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.GONE);
                discription2.setVisibility(View.VISIBLE);

            }
        });

        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear4.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);
                discription2.setVisibility(View.GONE);


            }
        });


//                ***********design**********

        linear5 = (LinearLayout) findViewById(R.id.linear5);
        linear6 = (LinearLayout) findViewById(R.id.linear6);
        discription3 = (TextView) findViewById(R.id.discription3);


        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear6.setVisibility(View.VISIBLE);
                linear5.setVisibility(View.GONE);
                discription3.setVisibility(View.VISIBLE);

            }
        });

        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear6.setVisibility(View.GONE);
                linear5.setVisibility(View.VISIBLE);
                discription3.setVisibility(View.GONE);


            }
        });


//         ********Slider*********

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.rain4);
        file_maps.put("2", R.drawable.rain5);
        file_maps.put("3", R.drawable.rain6);
//      file_maps.put("4",R.layout.videolayout);


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


        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainChat.class);
                startActivity(intent);

            }
        });

        myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Your item has been successfully added to the Cart!", Toast.LENGTH_LONG).show();

            }
        });




        link1=(TextView)findViewById(R.id.link1);
        link1=(TextView)findViewById(R.id.link2);
        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent internetIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(link1.toString()));
                internetIntent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
                internetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(internetIntent);

            }
        });

        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent internetIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(link2.toString()));
                internetIntent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
                internetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(internetIntent);
            }
        });
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cartImage:
                Intent intent = new Intent(MainActivity.this, cart.class);
                intent.putExtra("title", productname);
                startActivity(intent);
                break;
            case R.id.heart:
                ImageView heart = (ImageView)findViewById(R.id.heart);
                heart.setImageResource(R.drawable.heart_liked);
                break;
            case R.id.back:
                finish();
            case R.id.reviewChat:
                Intent i = new Intent(MainActivity.this, MainChat.class);
                startActivity(i);
                finish();
                break;

        }
    }
}
