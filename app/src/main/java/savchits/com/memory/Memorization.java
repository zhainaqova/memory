package savchits.com.memory;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;


import savchits.com.memory.databinding.ActivityMemorizationBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Timer;

public class  Memorization extends AppCompatActivity {
    ActivityMemorizationBinding binding;
    List<String> item;
    Context context;
    int value1;
    int life=5;
    private  CountDownTimer countDownTimer;
    //  RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemorizationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        item = initData();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timer();
            }
        },1000);


        LinearLayoutManager layoutManager =  new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        binding.rv.setLayoutManager(layoutManager);
        binding.rv.setNestedScrollingEnabled(false);
        RvAdapter rvAdapter = new RvAdapter(item, this);
        binding.rv.setAdapter(rvAdapter);

        // getLife();

        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        value1 = sharedPreferences.getInt("life", 0);
        binding.tvLife.setText(value1 +"");
        binding.progressBar.setProgress(value1*20);
        if (value1 <= 0) {
            value1 = 5;
            SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("life", value1);
            editor.apply();
            startActivity(new Intent(Memorization.this, ResultActivity.class));
        }


        binding.dalee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                String mword1 = item.get(0).toLowerCase ();
                String mword2 = item.get(1).toLowerCase ();
                String mword3 = item.get(2).toLowerCase ();
                String mword4 = item.get(3).toLowerCase ();
                String mword5 = item.get(4).toLowerCase ();

                SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("mword1", mword1);
                editor.putString("mword2", mword2);
                editor.putString("mword3", mword3);
                editor.putString("mword4", mword4);
                editor.putString("mword5", mword5);
                editor.putInt("life", value1);
                editor.apply();
                Intent intent = new Intent(Memorization.this, CheckActivity.class);
                startActivity(intent);

            }
        });

    }


    private void timer() {
        countDownTimer =  new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                binding.time.setText("00:" + millisUntilFinished / 1000);
                //cancel();
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                //  finish();
                cancel();
                binding.time.setText("Done!");
                startActivity(new Intent(getApplicationContext(), CheckActivity.class));
                //  cancel();

            }

        }.start();
    }

    private List<String> initData() {
        List<String> list = new ArrayList<String>();
        list.add("Воробей");
        list.add("Лиса");
        list.add("Волк");
        list.add("Лиса");
        list.add("Утка");
        list.add("Заяц");
        list.add("Медведь");
        list.add("Акула");
        list.add("Крокодил");
        list.add("Афиша");
        list.add("Ягода");
        list.add("Капуста");
        list.add("Вздорожание");
        list.add("Питон");
        list.add("Цепочка");
        Collections.shuffle(list);

        return list;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}