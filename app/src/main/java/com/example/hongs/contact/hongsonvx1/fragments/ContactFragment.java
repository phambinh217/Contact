package com.example.hongs.contact.hongsonvx1.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hongs.contact.R;
import com.example.hongs.contact.hongsonvx1.fragments.adapter_contact.RecyclerAdapterContact;
import com.example.hongs.contact.hongsonvx1.objects.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private List<Contact> contacts = new ArrayList<>();

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        getContacts();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapterContact adapterContact = new RecyclerAdapterContact(getContext(), contacts);
        recyclerView.setAdapter(adapterContact);

        return view;
    }

    private void getContacts() {
        Cursor phones = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        assert phones != null;
        while (phones.moveToNext()) {
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            contacts.add(new Contact(name, phoneNumber));
        }
        phones.close();
    }
}
