package com.example.jacob.myapplication2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


/**
 * Created by jacob on 9/11/14.
 */
public class MyFragment extends Fragment{
    public MyFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        final EditText my_text = (EditText) rootView.findViewById(R.id.text_to_add);
        Button my_button = (Button) rootView.findViewById(R.id.add_button);
        final ListView my_list_view = (ListView) rootView.findViewById(R.id.my_list_view);
        final ArrayList<String> chat_list = new ArrayList<String>();
        final ChatAdapter my_adapter = new ChatAdapter(getActivity(), R.layout.chat_item,chat_list);


        my_button.setText(R.string.button_press);
        my_button.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v){
                my_adapter.add(my_text.getText().toString());
                my_text.setText("");
                my_adapter.notifyDataSetChanged();
                my_list_view.setSelection(chat_list.size());
            }
        });


        my_list_view.setAdapter(my_adapter);
        return rootView;
    }
}