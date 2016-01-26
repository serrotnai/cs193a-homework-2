package com.example.ian.to_dolist;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> todoItems;
    ArrayAdapter<String> todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoItems = new ArrayList<String>();
        todoAdapter = new ArrayAdapter<>(
                this,
                R.layout.mylistlayout,
                R.id.list_row_text,
                todoItems);
        ListView todoList = (ListView) findViewById(R.id.todo_list);
        todoList.setAdapter(todoAdapter);

        todoList.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> list,
                                            View row,
                                            int index,
                                            long rowID) {
                    todoItems.remove(index);
                    todoAdapter.notifyDataSetChanged();
                    return true;
                }
            }
        );
    }

    public void addButtonClick(View view) {
        EditText itemEdit = (EditText) findViewById(R.id.item_edit);
        String itemText = itemEdit.getText().toString();
        if (!itemText.isEmpty()) {
            todoItems.add(itemText);
            todoAdapter.notifyDataSetChanged();
        }
    }
}
