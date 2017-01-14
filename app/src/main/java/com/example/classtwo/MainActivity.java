package com.example.classtwo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView image_View;
    int j;
    private RecyclerView recycler_View;
    Button button1;
    private WhoAdapter adapter = new WhoAdapter();
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_View = (ImageView) findViewById(R.id.image_view);
        recycler_View = (RecyclerView) findViewById(R.id.recycler_view);
        button1 = (Button) findViewById(R.id.button_1);
        image_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Random random = new Random();
                //产生的值是0-100的随机数
                int index = random.nextInt(100);
                if (adapter.data.size() == 0) {
                    adapter.data.add(index + "");

                    //使RecyclerView滚动到底部
                    adapter.notifyItemInserted(adapter.data.size() - 1);

                    //通知adapter数据已经改变了

                    recycler_View.scrollToPosition(adapter.data.size() - 1);
                } else {

                    for (int i = 0, j = 0; i < adapter.data.size(); i++) {
                        if (index == Integer.parseInt(adapter.data.get(i))) {

                            break;

                        } else {
                            j++;
                        }
                        if (j == adapter.data.size()) {

                            //添加数据到列表中
                            adapter.data.add(index + "");

                            //使RecyclerView滚动到底部
                            adapter.notifyItemInserted(adapter.data.size() - 1);

                            //通知adapter数据已经改变了

                            recycler_View.scrollToPosition(adapter.data.size() - 1);
                        }

                    }
                }
                /*ObjectAnimator.ofFloat(image_View,"rotation",0f,180f)
                        .setDuration(500)//
                        .start();*/
                ObjectAnimator oJA = ObjectAnimator.ofFloat(image_View, "scaleX", 1f, 1.5f);
                ObjectAnimator oJA2 = ObjectAnimator.ofFloat(image_View, "rotation", 0f, 360f)
                        .setDuration(500);
                ObjectAnimator oJA3 = ObjectAnimator.ofFloat(image_View, "scaleY", 1f, 1.5f);
                AnimatorSet set = new AnimatorSet();
                set.play(oJA).after(oJA2).after(oJA3);
                set.start();


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.data.clear();  //清空数据
                adapter.notifyDataSetChanged();  //通知RecyclerView数据已经改变
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayout.VERTICAL, false);
        recycler_View.setLayoutManager(layoutManager);

        recycler_View.setAdapter(adapter);


    }
}
