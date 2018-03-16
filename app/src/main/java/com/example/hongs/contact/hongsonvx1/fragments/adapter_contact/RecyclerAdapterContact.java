package com.example.hongs.contact.hongsonvx1.fragments.adapter_contact;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hongs.contact.R;
import com.example.hongs.contact.hongsonvx1.objects.Contact;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hongs on 2018-03-16.
 * object contact detail
 */

public class RecyclerAdapterContact extends RecyclerView.Adapter<RecyclerAdapterContact.RecyclerViewHolder>
        implements View.OnClickListener {

    private Context context;
    private List<Contact> contacts = new ArrayList<>();

    public RecyclerAdapterContact(Context context, List<Contact> callHistories) {
        this.context = context;
        this.contacts = callHistories;
    }

    @Override
    public RecyclerAdapterContact.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_call_history, parent, false);

        return new RecyclerAdapterContact.RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerAdapterContact.RecyclerViewHolder holder, int position) {
//        holder.circleImageView
        holder.textViewCallName.setText(contacts.get(position).getName());
        holder.textViewCallDate.setText(PhoneNumberUtils.formatNumber(contacts.get(position).getNumberPhone()));

    }

    @Override
    public int getItemCount() {
        Log.d("my_adapter", "Size: " + contacts.size());
        return contacts.size();
    }

    @Override
    public void onClick(View v) {

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
            textViewCallName = itemView.findViewById(R.id.text_call_name);
            textViewCallDate = itemView.findViewById(R.id.text_call_date);
            imageButtonCall = itemView.findViewById(R.id.image_button_call);
        }
    }
}