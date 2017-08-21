package com.example.halfblood.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HalfBlood on 12/27/2016.
 */

public class Parser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    ListView lv;
    String data;

    ArrayList<String> players=new ArrayList<>();
    ProgressDialog pd;
    private String desc[] = {
            "Number ofPatient=2 \n" +
                    "Checkup Duration 8.00am to 10.00am",
            "Number ofPatient=13 \n" +
                    "Checkup Duration 11.00am to 12.00pm",
            "Number ofPatient=20 \n" +
                    "Checkup Duration 3.00pm to 5.00pm",
            "Number ofPatient=2 \n" +
                    "Checkup Duration 6.00pm to 7.00pm"
    };

    public Parser(Context c,String data,ListView lv){
        this.c=c;
        this.data=data;
        this.lv=lv;
    }





    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd =new ProgressDialog(c);
        pd.setTitle("Parser");
        pd.setMessage("Parsing.....Pleas Wait");
        pd.show();

    }

    @Override
    protected Integer doInBackground(Void... params) {


        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if(integer ==1){
            ArrayAdapter<String> adapter =new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,players);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Snackbar.make(view,desc[position],Snackbar.LENGTH_LONG).show();
                }
            });

        }else{
            Toast.makeText(c,"Unable Parsing........",Toast.LENGTH_SHORT).show();
        }
        pd.dismiss();
    }
    private int parse(){
        try {
            JSONArray ja =new JSONArray(data);
            JSONObject jo =null;
            players.clear();
           // Spececraft s=null;

            for(int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);
                String name = jo.getString("name");
                String email = jo.getString("email");
                players.add(name);








            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }

return 0;
    }
}