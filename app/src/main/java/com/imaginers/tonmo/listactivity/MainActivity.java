package com.imaginers.tonmo.listactivity;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] mContacts ={"Rafi","Tusher","Ishayat","Shohag","Armaan"};
    ListView mContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContactList=getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mContacts);
        mContactList.setAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView temp = (TextView) v;

        Toast.makeText(this,temp.getText()+" "+position,Toast.LENGTH_SHORT).show();
    }
}
