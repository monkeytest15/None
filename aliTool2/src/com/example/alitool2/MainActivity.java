package com.example.alitool2;
import java.util.ArrayList;

import com.alipay.portal.Docs.DocList;
import com.alipay.portal.Docs.PortalDemoDoc;
import com.example.alitool2.TargetActivity;
import com.example.alitool2.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview = (ListView)findViewById(R.id.listView1);
        this.setTitle("AliPay Test Tool");

        list.add("商户新账号注册(暂不可用)");
        list.add("商户aboss查询(暂不可用)");
        list.add("商户TaskID日志查询(暂不可用)");
        list.add("商户性能监控(暂不可用)");
        list.add("商户版相关文档");
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>
                            (this,android.R.layout.simple_list_item_1,list);
        mylistview.setAdapter(myArrayAdapter);
        /*mylistview.setOnTouchListener(new OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    mylistview.setBackgroundColor(Color.BLUE);
                }
                return false;
            }

        });*/
        mylistview.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                // TODO Auto-generated method stub
                if(list.get(arg2).equals("商户新账号注册"))
                {
        			Intent intent = new Intent();
					intent.setClass(MainActivity.this, TargetActivity.class);
					startActivity(intent);
					finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
                }
                if(list.get(arg2).equals("AbsoluteLayout"))
                {
                    Intent intent = new Intent("com.wps.android.ABSOLUTELAYOUT");
                    startActivity(intent);
                }
                if(list.get(arg2).equals("TableLayout"))
                {
                    Intent intent = new Intent("com.wps.android.TABLELAYOUT");
                    startActivity(intent);
                }
                if(list.get(arg2).equals("RelativeLayout"))
                {
                    Intent intent = new Intent("com.wps.android.RELATIVELAYOUT");
                    startActivity(intent);
                }
                if(list.get(arg2).equals("商户版相关文档"))
                {
        			Intent intent = new Intent();
					intent.setClass(MainActivity.this, DocList.class);
					startActivity(intent);
					finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
                }
            }

        });
    }
}