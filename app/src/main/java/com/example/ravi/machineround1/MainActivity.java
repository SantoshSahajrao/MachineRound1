package com.example.ravi.machineround1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Data> marrylist;
    ReyAdpter mRecyAdpter;
   // ArrayList<Chat> chatArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.xrey);
        marrylist = new ArrayList<>();
      //  chatArrayList = new ArrayList<>();


        mRecyAdpter = new ReyAdpter(marrylist,MainActivity.this);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest("http://www.bitcodeindia.com/android/ws_chatgroups.php", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray chatgeroup = response.getJSONArray("Chat_Groups");
                    for(int i=0;i<chatgeroup.length();i++)
                    {
                        Data data = new Data();
                        JSONObject jsonObject = chatgeroup.getJSONObject(i);
                        data.Groupname = jsonObject.getString("Group_Name");
                        data.GroupImg = jsonObject.getString("Group_Icon");
                        JSONArray chat = jsonObject.getJSONArray("Chat");
                        for (int j=0;j<chat.length();j++) {
                            JSONObject jsonObject1 = chat.getJSONObject(j);
                         //   data.MemeberName = jsonObject1.getString("Member_Name");
                           // data.Chattext = jsonObject1.getString("Chat_Text");
                           // data.ChatImg = jsonObject1.getString("Chat_Image");

                            Chat chat1  = new Chat();
                            chat1.memnane = jsonObject1.getString("Member_Name");
                            chat1.chattext = jsonObject1.getString("Chat_Text");
                            data.chatArrayList.add(chat1);


                        }
                        marrylist.add(data);
                        mRecyAdpter.notifyDataSetChanged();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(MainActivity.this, "Error Ocuured", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);



        recyclerView.setAdapter(mRecyAdpter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
}
