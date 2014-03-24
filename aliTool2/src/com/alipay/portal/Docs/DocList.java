package com.alipay.portal.Docs;

import java.util.ArrayList;

import com.alipay.portal.Docs.DocList;
import com.example.alitool2.MainActivity;
import com.example.alitool2.R;
import com.example.alitool2.TargetActivity;
import com.example.alitool2.R.id;
import com.example.alitool2.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DocList extends Activity {
	/** Called when the activity is first created. */
	private ListView mylistview;
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mylistview = (ListView) findViewById(R.id.listView1);
		this.setTitle("商户相关文档");

		list.add("支付宝商户自动化方案文档");
		list.add("商户demo文档");
		list.add("商户业务文档");
		list.add("Alipay测试界");

		ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		mylistview.setAdapter(myArrayAdapter);
		/*
		 * mylistview.setOnTouchListener(new OnTouchListener(){
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { // TODO
		 * Auto-generated method stub if(event.getAction() ==
		 * MotionEvent.ACTION_DOWN) { mylistview.setBackgroundColor(Color.BLUE);
		 * } return false; }
		 * 
		 * });
		 */
		mylistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if (list.get(arg2).equals("支付宝商户自动化方案文档")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, PortalAutomationDoc.class);
					startActivity(intent);
					finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
				}
				if (list.get(arg2).equals("商户demo文档")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, PortalDemoDoc.class);
					startActivity(intent);
					finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
				}
				if (list.get(arg2).equals("商户业务文档")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, PortalFucDocs.class);
					startActivity(intent);
					finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
				}
				if (list.get(arg2).equals("Alipay测试界")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, AlipayBlog.class);
					startActivity(intent);
					finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
				}

			}

		});
	}

	public void onBackPressed() {
		Intent intent = new Intent();
		intent.setClass(DocList.this, MainActivity.class);
		startActivity(intent);
		finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
	}
}