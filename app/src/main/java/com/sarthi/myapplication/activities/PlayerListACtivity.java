package com.sarthi.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sarthi.myapplication.R;
import com.sarthi.myapplication.abstracts.BaseActivity;
import com.sarthi.myapplication.abstracts.Utility;
import com.sarthi.myapplication.abstracts.WebCallInterface;
import com.sarthi.myapplication.adapters.TopPlayersAdapter;
import com.sarthi.myapplication.databinding.ActivityPlayerListBinding;
import com.sarthi.myapplication.model.AllResponse;
import com.sarthi.myapplication.model.Batting;
import com.sarthi.myapplication.model.DemoClass;
import com.sarthi.myapplication.model.JsonMember4;
import com.sarthi.myapplication.model.Players;
import com.sarthi.myapplication.model.newclasses.UpdatedResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerListACtivity extends BaseActivity implements TopPlayersAdapter.GameInfoInterface {
    ActivityPlayerListBinding playerListBinding;

    private LinearLayoutManager mLayoutManager;
    private TopPlayersAdapter topPlayersAdapter;
    private ArrayList<DemoClass> demoClassArrayList = new ArrayList<>();
    private String selected_withdraw;
    public ArrayList<UpdatedResponse> updatedResponseslist = new ArrayList<>();
    String[] withdraw = {"All Players List", "India", "New Zealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerListBinding = DataBindingUtil.setContentView(this, R.layout.activity_player_list);

        playerListBinding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ArrayAdapter<String> arr1 = new ArrayAdapter<>(PlayerListACtivity.this, android.R.layout.simple_spinner_dropdown_item, withdraw);
        playerListBinding.spinnerList.setAdapter(arr1);


        playerListBinding.spinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                selected_withdraw = withdraw[i];
                demoClassArrayList.clear();
                if (selected_withdraw.equalsIgnoreCase("ALl Players List")) {
                    getTopPlayers("1");
                } else if (selected_withdraw.equalsIgnoreCase("India")) {
                    getTopPlayers("4");
                } else {
                    getTopPlayers("5");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void getTopPlayers(String selectedvalue) {
        Utility.showDialog(PlayerListACtivity.this);
        hitApi(new WebCallInterface() {
            @Override
            public void callApi() {
                PlayerListACtivity.this.getWebInterface().getALlData().enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Utility.closeDialog();


                        if (response.isSuccessful()) {
                            try {
                                String responseData = response.body().string();
                                parseJson(responseData, selectedvalue);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(PlayerListACtivity.this, getResources().getString(R.string.something_wrong), Toast.LENGTH_LONG).show();

                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Utility.closeDialog();
                        Toast.makeText(PlayerListACtivity.this, getResources().getString(R.string.something_wrong), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }


    private void parseJson(String response, String selectedvalue) {
        try {

            if (selectedvalue.equalsIgnoreCase("1"))
            {
                updatedResponseslist.clear();

                JSONObject jsonArray = new JSONObject(response);
                for (Iterator<String> it = jsonArray.getJSONObject("Teams").keys(); it.hasNext(); ) {
                    String team = it.next();
                    for (Iterator<String> iter = jsonArray.getJSONObject("Teams").getJSONObject(team).getJSONObject("Players").keys(); iter.hasNext(); ) {
                        String key = iter.next();
                        JSONObject player = jsonArray.getJSONObject("Teams").getJSONObject(team).getJSONObject("Players").getJSONObject(key);
                        Gson gson = new Gson();
                        UpdatedResponse updatedResponse = gson.fromJson(player.toString(), UpdatedResponse.class);
                        updatedResponseslist.add(updatedResponse);
                    }
                }

                playerListBinding.recyclerNotifications.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(PlayerListACtivity.this);
                playerListBinding.recyclerNotifications.setLayoutManager(mLayoutManager);
                topPlayersAdapter = new TopPlayersAdapter(PlayerListACtivity.this, updatedResponseslist, PlayerListACtivity.this);
                playerListBinding.recyclerNotifications.setAdapter(topPlayersAdapter);

            }


           else if (selectedvalue.equalsIgnoreCase("4"))
            {
                updatedResponseslist.clear();

                JSONObject jsonArray = new JSONObject(response);

                for (Iterator<String> iter = jsonArray.getJSONObject("Teams").getJSONObject(selectedvalue).getJSONObject("Players").keys(); iter.hasNext(); ) {
                    String key = iter.next();
                    JSONObject player = jsonArray.getJSONObject("Teams").getJSONObject("4").getJSONObject("Players").getJSONObject(key);
                    Gson gson = new Gson();
                    UpdatedResponse updatedResponse = gson.fromJson(player.toString(), UpdatedResponse.class);
                    updatedResponseslist.add(updatedResponse);
                }

                playerListBinding.recyclerNotifications.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(PlayerListACtivity.this);
                playerListBinding.recyclerNotifications.setLayoutManager(mLayoutManager);
                topPlayersAdapter = new TopPlayersAdapter(PlayerListACtivity.this, updatedResponseslist, PlayerListACtivity.this);
                playerListBinding.recyclerNotifications.setAdapter(topPlayersAdapter);

            }

            else if (selectedvalue.equalsIgnoreCase("5"))
            {
                updatedResponseslist.clear();

                JSONObject jsonArray = new JSONObject(response);

                for (Iterator<String> iter = jsonArray.getJSONObject("Teams").getJSONObject(selectedvalue).getJSONObject("Players").keys(); iter.hasNext(); ) {
                    String key = iter.next();
                    JSONObject player = jsonArray.getJSONObject("Teams").getJSONObject("5").getJSONObject("Players").getJSONObject(key);
                    Gson gson = new Gson();
                    UpdatedResponse updatedResponse = gson.fromJson(player.toString(), UpdatedResponse.class);
                    updatedResponseslist.add(updatedResponse);
                }


                playerListBinding.recyclerNotifications.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(PlayerListACtivity.this);
                playerListBinding.recyclerNotifications.setLayoutManager(mLayoutManager);
                topPlayersAdapter = new TopPlayersAdapter(PlayerListACtivity.this, updatedResponseslist, PlayerListACtivity.this);
                playerListBinding.recyclerNotifications.setAdapter(topPlayersAdapter);

            }





        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(UpdatedResponse listDataItem) {
        showDialogmessage(listDataItem);
    }

    private void showDialogmessage(UpdatedResponse listDataItem) {

        final AlertDialog dialogBuilder = new AlertDialog.Builder(PlayerListACtivity.this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        dialogBuilder.setCancelable(false);
        View dialogView = inflater.inflate(R.layout.custom_dialog_new, null);

        final TextView text_bat_style = dialogView.findViewById(R.id.text_bat_style);
        final TextView text_bat_average = dialogView.findViewById(R.id.text_bat_average);
        final TextView text_bat_strikerate = dialogView.findViewById(R.id.text_bat_strikerate);
        final TextView text_bat_runs = dialogView.findViewById(R.id.text_bat_runs);

        final TextView text_bowl_style = dialogView.findViewById(R.id.text_bowl_style);
        final TextView text_bowl_average = dialogView.findViewById(R.id.text_bowl_average);
        final TextView text_economy = dialogView.findViewById(R.id.text_economy);
        final TextView text_wickets = dialogView.findViewById(R.id.text_wickets);


        text_bat_style.setText(listDataItem.getBatting().getStyle());
        text_bat_average.setText(listDataItem.getBatting().getAverage());
        text_bat_strikerate.setText(listDataItem.getBatting().getStrikerate());
        text_bat_runs.setText(listDataItem.getBatting().getRuns());

        text_bowl_style.setText(listDataItem.getBowling().getStyle());
        text_bowl_average.setText(listDataItem.getBowling().getAverage());
        text_economy.setText(listDataItem.getBowling().getEconomyrate());
        text_wickets.setText(listDataItem.getBowling().getWickets());


        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(true);
        dialogBuilder.show();

    }


}