package com.example.sacred_heart.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.sacred_heart.R;
import com.example.sacred_heart.data.Contact;
import com.example.sacred_heart.data.DatabaseHelper;

import java.util.List;

public class contactList extends Fragment {

    DatabaseHelper dbHelper;
    TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        tableLayout = view.findViewById(R.id.table_layout_entries);
        dbHelper = new DatabaseHelper(getContext());


        List<Contact> contactList = dbHelper.getAllContacts();
        for (Contact contact : contactList) {
            TableRow tableRow = new TableRow(getContext());
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, 16); // Adds 16dp spacing between rows
            tableRow.setLayoutParams(params);

            TextView textViewId = new TextView(getContext());
            textViewId.setText(String.valueOf(contact.getId()));
            textViewId.setPadding(8, 8, 8, 8);
            tableRow.addView(textViewId);

            TextView textViewName = new TextView(getContext());
            textViewName.setText(contact.getName());
            textViewName.setPadding(8, 8, 8, 8);
            tableRow.addView(textViewName);

            TextView textViewMobile = new TextView(getContext());
            textViewMobile.setText(contact.getMobile());
            textViewMobile.setPadding(8, 8, 8, 8);
            tableRow.addView(textViewMobile);

            TextView textViewEmail = new TextView(getContext());
            textViewEmail.setText(contact.getEmail());
            textViewEmail.setPadding(8, 8, 8, 8);
            tableRow.addView(textViewEmail);

            TextView textViewMessage = new TextView(getContext());
            textViewMessage.setText(contact.getMessage());
            textViewMessage.setPadding(8, 8, 8, 8);
            tableRow.addView(textViewMessage);

            tableLayout.addView(tableRow);
        }


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dbHelper.close();
    }
}