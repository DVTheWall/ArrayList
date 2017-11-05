package com.example.dhaval.arraylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Bean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  ()

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_recyclveiw);
        //set Linear/Grid layoutmanger
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        list = new ArrayList<>(); //  Arraylist is assign

        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean(); // create bean class instance
            //  then this Instance through  access all inside bean class member [variable]..
            bean.setName("Dhaval" + i);
            bean.setAddress("katargam" + i);
            bean.setId(i);

            list.add(bean);// then this bean class Instance are  add into ArrayList.
        }

        // all list are add into recycleview adapter.
        recyclerView.setAdapter(new MyRecycleviewAdapter(MainActivity.this, list));

        try {
            // get particular postion in ArrayList
            Bean bean50 = list.get(50);
            //  Bean bean101 = list.get(101);
            //  int i = 1 / 0;

            bean50.getName();
            bean50.getAddress();
            bean50.getId();

            System.out.println("bea50 : " + bean50.getName() + " " + bean50.getAddress() + " " + bean50.getId());
            //  System.out.println("bea50 : " + bean101.getName() + " " + bean101.getAddress() + " " + bean101.getId());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("bea50 IndexOutOfBoundsException");

        } catch (Exception e) {
            System.out.println("bea50  Exception");
        }
    }
}
