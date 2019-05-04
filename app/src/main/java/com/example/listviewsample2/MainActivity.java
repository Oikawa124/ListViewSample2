package com.example.listviewsample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvMenu = findViewById(R.id.lvMenu);

        List<String> menuList = new ArrayList<>();

        menuList.add("唐揚げ定食");
        menuList.add("ステーキ定食");
        menuList.add("卵定食");
        menuList.add("とんかつ定食");
        menuList.add("コロッケ定食");
        menuList.add("焼き魚定食");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, menuList);

        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ListItemClickListener());

    }

    private class ListItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // 注文確認用ダイアログフラグメントオブジェクトを生成

            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();

            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");

        }
    }
}
