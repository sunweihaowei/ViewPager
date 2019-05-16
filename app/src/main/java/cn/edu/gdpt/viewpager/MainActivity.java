package cn.edu.gdpt.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private android.support.v4.view.ViewPager ViewPager;
    private String[] strings=new String[]{"唯美1","唯美2","唯美3","唯美4","唯美5"};
    private int[] ints=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    List<ImageView> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int a = 0; a<ints.length; a++){
              ImageView imageView=new ImageView(MainActivity.this);
              imageView.setBackgroundResource(ints[a]);
              list.add(imageView);
              MyAdapter myAdapter=new MyAdapter();
              ViewPager.setAdapter(myAdapter);
        }

    }
    class MyAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            //判断是否这个view与o相等
            return view==o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ImageView imageView= (ImageView) object;//让object等于object，object表示的是我们看到的界面
            container.removeView(imageView);//移除object
           /* ImageView imageView=(ImageView)object;
            container.removeView(imageView);*/
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView=list.get(position);//创建ImageView，并为list的position项，position为list的第几项
            container.addView(imageView);//
            return imageView;
        }
    }
    private void initView() {
        ViewPager = (ViewPager) findViewById(R.id.ViewPager);
    }
}
