package com.example.superrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public View onCreateViewHolder(int position, View convertView, ViewGroup parent) {
                if (position % 2 == 0) {
                    convertView = MainActivity.this.getLayoutInflater().inflate(R.layout.item_table, parent, false);
                    TextView textView = convertView.findViewById(R.id.text1);
                    textView.setText("第" + position + "行");
                } else {
                    convertView = MainActivity.this.getLayoutInflater().inflate(R.layout.item_table2, parent, false);
                    TextView textView = convertView.findViewById(R.id.text2);
                    textView.setText("第" + position + "行");
                }
                return convertView;
            }

            @Override
            public View onBinderViewHolder(int position, View convertView, ViewGroup parent) {
                if (position % 2 == 0) {
                    TextView textView = convertView.findViewById(R.id.text1);
                    textView.setText("网易课堂" + position);
                } else {
                    TextView textView = convertView.findViewById(R.id.text2);
                    textView.setText("网易图标" + position);
                }
                return convertView;
            }

            @Override
            public int getItemViewType(int row) {
                if (row % 2 == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }

            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getCount() {
                return 300000;
            }

            @Override
            public int getHeight(int index) {
                return 100;
            }
        });
    }
}
