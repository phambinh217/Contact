package com.example.hongs.contact.binhpham.fragments.adapter_history;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hongs.contact.R;
import com.example.hongs.contact.binhpham.objects.CallHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by phambinh on 2018-03-15.
 *
 */

public class RecyclerAdapterHistory extends RecyclerView.Adapter<RecyclerAdapterHistory.RecyclerViewHolder> {

    private Context context;
    private List<CallHistory> callHistories = new ArrayList<>();

    public RecyclerAdapterHistory(Context context, List<CallHistory> callHistories) {
        this.context = context;
        this.callHistories = callHistories;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_call_history, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, @SuppressLint("RecyclerView") final int position) {
//        holder.circleImageView

        holder.textViewCallName.setText(callHistories.get(callHistories.size()-position-1).getCallName());
        String name = callHistories.get(callHistories.size()-position-1).getCallName();
        if (name == null || name.isEmpty()) {
            holder.textViewCallName.setText(callHistories.get(callHistories.size()-position-1).getPhoneNumber());
        }
        switch (callHistories.get(callHistories.size()-position-1).getCallType()) {
            case CallLog.Calls.OUTGOING_TYPE:
                holder.imageViewCallType.setImageResource(R.drawable.ic_call_made_green_24dp);
                break;

            case CallLog.Calls.INCOMING_TYPE:
                holder.imageViewCallType.setImageResource(R.drawable.ic_call_received_blue_24dp);
                break;

            case CallLog.Calls.MISSED_TYPE:
                holder.imageViewCallType.setImageResource(R.drawable.ic_call_missed_red_24dp);
                break;
        }

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm, E dd/MM/yyyy");
        holder.textViewCallDate.setText(simpleDateFormat.format(callHistories.get(callHistories.size()-position-1).getCallDate()));

        holder.imageButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String strNumberPhone = "tel:" + callHistories.get(callHistories.size()-position-1).getCallName();
                intent.setData(Uri.parse(strNumberPhone));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    context.startActivity(intent);
                    return;
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return callHistories.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView circleImageView;
        private ImageView imageViewCallType;
        private TextView textViewCallName;
        private TextView textViewCallDate;
        private ImageButton imageButtonCall;

        RecyclerViewHolder(View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.circle_image_avatar);
            imageViewCallType = itemView.findViewById(R.id.image_call_type);
            imageViewCallType.setVisibility(View.VISIBLE);
            textViewCallName = itemView.findViewById(R.id.text_call_name);
            textViewCallDate = itemView.findViewById(R.id.text_call_date);
            imageButtonCall = itemView.findViewById(R.id.image_button_call);
        }
    }
}
