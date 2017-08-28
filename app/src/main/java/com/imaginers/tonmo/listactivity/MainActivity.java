package com.imaginers.tonmo.listactivity;


import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] mContacts ={"Rafi","Tusher","Ishayat","Shohag","Armaan"};
    ArrayAdapter<String> adapter;
    ListView mContactList;
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSearch = (EditText) findViewById(R.id.inputSearch);
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                adapter.getFilter().filter(cs);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        mContactList=getListView();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mContacts);
        mContactList.setAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView temp = (TextView) v;

        Toast.makeText(this,temp.getText()+" "+position,Toast.LENGTH_SHORT).show();
    }
}
