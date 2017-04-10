package hackathon.iron_man;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import hackathon.iron_man.tabview.JayBaseAdapter;
import hackathon.iron_man.tabview.MainActivity;
import hackathon.iron_man.tabview.Bean;

/**
 * Created by Iron_Man on 06/04/17.
 */

public class cart extends AppCompatActivity {

    private ListView listview;

    private int[] IMAGE = {hackathon.iron_man.R.drawable.box, hackathon.iron_man.R.drawable.ball, hackathon.iron_man.R.drawable.bag,
            hackathon.iron_man.R.drawable.box, hackathon.iron_man.R.drawable.ball};

    private String[] TITLE = {"Teak & Steel Petanque Set", "Lemon Peel Baseball", "Seil Marschall Hiking Pack", "Teak & Steel Petanque Set", "Lemon Peel Baseball"};

    private String[] DESCRIPTION = {"One Size", "One Size", "Size L", "One Size", "One Size"};

    private String[] DATE = {"$ 220.00", "$ 49.00", "$ 320.00", "$ 220.00", "$ 49.00"};
    private ArrayList<Bean> Bean;
    private JayBaseAdapter baseAdapter;
    customfonts.MyTextView ct;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(hackathon.iron_man.R.layout.cart);
        listview = (ListView) findViewById(hackathon.iron_man.R.id.listview1);
        ct = (customfonts.MyTextView) findViewById(hackathon.iron_man.R.id.cpay);

        Bean = new ArrayList<Bean>();

        for (int i = 0; i < TITLE.length; i++) {

            Bean bean = new Bean(IMAGE[i], TITLE[i], DESCRIPTION[i], DATE[i]);
            Bean.add(bean);

        }


        baseAdapter = new JayBaseAdapter(getApplicationContext(), Bean) {
        };

        listview.setAdapter(baseAdapter);

        ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cart.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
