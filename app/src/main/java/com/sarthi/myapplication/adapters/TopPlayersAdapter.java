package com.sarthi.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


import com.sarthi.myapplication.R;
import com.sarthi.myapplication.model.DemoClass;
import com.sarthi.myapplication.model.JsonMember4;
import com.sarthi.myapplication.model.Players;
import com.sarthi.myapplication.model.newclasses.UpdatedResponse;

import java.util.ArrayList;

public class TopPlayersAdapter extends RecyclerView.Adapter<TopPlayersAdapter.ToplPlayerHolder> {

    private Context context;
    private ArrayList<UpdatedResponse> topPlayersdataitems;
    private GameInfoInterface gameInfoInterface;



    public TopPlayersAdapter(Context context, ArrayList<UpdatedResponse> topPlayersdataitems,GameInfoInterface gameInfoInterface) {
        this.context = context;
        this.topPlayersdataitems = topPlayersdataitems;
        this.gameInfoInterface = gameInfoInterface;
    }


    public interface GameInfoInterface {
        //void onClick(String id,String choosebatsman,String choosebowler, String matchtype);
        void onClick(UpdatedResponse listDataItem);
    }


    @NonNull
    @Override
    public ToplPlayerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_player, parent, false);
        ToplPlayerHolder toplPlayerHolder = new ToplPlayerHolder(view);
        return toplPlayerHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ToplPlayerHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.playerName.setText(topPlayersdataitems.get(position).getNameFull());
        //holder.playerPosition.setText(topPlayersdataitems.get(position).getPosition());
        holder.playerPosition.setText("#"+String.valueOf(position+1));

        if (topPlayersdataitems.get(position).getIscaptain()!=null)
        {
            if (topPlayersdataitems.get(position).getIscaptain().equalsIgnoreCase("true"))
            {
                holder.playerName.setTextColor(context.getColor(R.color.green_new));
                holder.playerPosition.setTextColor(context.getColor(R.color.green_new));
            }


            else
            {
                holder.playerName.setTextColor(context.getColor(R.color.grey_low));
                holder.playerPosition.setTextColor(context.getColor(R.color.grey_low));

            }

        }
        else
        {
            holder.playerName.setTextColor(context.getColor(R.color.grey_low));
            holder.playerPosition.setTextColor(context.getColor(R.color.grey_low));

        }



        holder.linear_main_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                gameInfoInterface.onClick(topPlayersdataitems.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return topPlayersdataitems.size();
    }

    public static class ToplPlayerHolder extends RecyclerView.ViewHolder {

        private TextView playerPosition,playerName,playerWinning;
        private LinearLayout root_linear;
        private LinearLayout linear_main_last;

        public ToplPlayerHolder(@NonNull View itemView) {
            super(itemView);
            playerPosition=itemView.findViewById(R.id.pos);
            playerName=itemView.findViewById(R.id.playernameok);
            playerWinning=itemView.findViewById(R.id.playerWinning);
            root_linear=itemView.findViewById(R.id.root_linear);
            linear_main_last=itemView.findViewById(R.id.linear_main_last);
        }
    }
}
