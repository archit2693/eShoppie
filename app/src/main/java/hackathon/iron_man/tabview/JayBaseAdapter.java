package hackathon.iron_man.tabview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hackathon.iron_man.R;
/**
 * Created by Iron_Man on 12/11/16.
 */

public class JayBaseAdapter extends BaseAdapter {

    Context context;

    ArrayList<Bean>bean;






    Typeface fonts1,fonts2;





    public JayBaseAdapter(Context context, ArrayList<Bean> bean) {


        this.context = context;
        this.bean = bean;
    }











    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        fonts1 =  Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

//        fonts2 = Typeface.createFromAsset(context.getAssets(),
//                "fonts/Lato-Regular.ttf");

        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list,null);

            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView)convertView.findViewById(R.id.image);
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.discription = (TextView)convertView.findViewById(R.id.description);
            viewHolder.date = (TextView)convertView.findViewById(R.id.date);
//            viewHolder.min = (ImageView)convertView.findViewById(R.id.min);
            viewHolder.text = (TextView)convertView.findViewById(R.id.text);
//            viewHolder.plus = (ImageView)convertView.findViewById(R.id.plus);


            viewHolder.title.setTypeface(fonts1);
            viewHolder.discription.setTypeface(fonts1);
            viewHolder.text.setTypeface(fonts1);
            viewHolder.date.setTypeface(fonts1);

            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }







        Bean bean = (Bean)getItem(position);

        viewHolder.image.setImageResource(bean.getImage());
        viewHolder.title.setText(bean.getTitle());
        viewHolder.discription.setText(bean.getDiscription());
        viewHolder.date.setText(bean.getDate());


//        number = 01;
//        viewHolder.text.setText(""+number);
//
//        final ViewHolder finalViewHolder = viewHolder;
//        viewHolder.min.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (number == 1){
//                    finalViewHolder.text.setText("" + number);
//            }
//
//                if (number > 1){
//
//                    number = number -1;
//                    finalViewHolder.text.setText(""+number);
//                }
//
//            }
//        });
//
//        final ViewHolder finalViewHolder1 = viewHolder;
//        viewHolder.plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (number == 10) {
//                    finalViewHolder1.text.setText("" + number);
//                }
//
//                if (number < 10) {
//
//                    number = number + 1;
//                    finalViewHolder1.text.setText("" + number);
//
//                }
//
//
//
//
//            }
//        });




        return convertView;
    }









    private class ViewHolder{
        ImageView image;
        TextView title;
        TextView discription;
        TextView date;
        ImageView min;
        TextView text;
        ImageView plus;













    }
}




