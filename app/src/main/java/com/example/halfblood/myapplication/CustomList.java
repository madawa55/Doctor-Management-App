package com.example.halfblood.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Belal on 7/22/2015.
 */
public class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private String[] desc;
    private String[] timea;
    private Integer[] imageid;
    private Activity context;

    public CustomList(Activity context, String[] names, String[] desc, String timea[], Integer[] imageid) {
        super(context, R.layout.list_layout, names);
        this.context = context;
        this.names = names;
        this.desc = desc;
        this.timea=timea;
        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.txthname);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.txtmaxpat);
        TextView textViewtime = (TextView) listViewItem.findViewById(R.id.txttime);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.imageView);

        textViewName.setText(names[position]);
        textViewDesc.setText(desc[position]);
        textViewtime.setText(timea[position]);
        image.setImageResource(imageid[position]);
        return  listViewItem;
    }
}