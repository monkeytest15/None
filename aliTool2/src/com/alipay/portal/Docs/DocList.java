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
		this.setTitle("�̻�����ĵ�");

		list.add("֧�����̻��Զ��������ĵ�");
		list.add("�̻�demo�ĵ�");
		list.add("�̻�ҵ���ĵ�");
		list.add("Alipay���Խ�");

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
				if (list.get(arg2).equals("֧�����̻��Զ��������ĵ�")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, PortalAutomationDoc.class);
					startActivity(intent);
					finish();// ֹͣ��ǰ��Activity,�����д,�򰴷��ؼ�����ת��ԭ����Activity
				}
				if (list.get(arg2).equals("�̻�demo�ĵ�")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, PortalDemoDoc.class);
					startActivity(intent);
					finish();// ֹͣ��ǰ��Activity,�����д,�򰴷��ؼ�����ת��ԭ����Activity
				}
				if (list.get(arg2).equals("�̻�ҵ���ĵ�")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, PortalFucDocs.class);
					startActivity(intent);
					finish();// ֹͣ��ǰ��Activity,�����д,�򰴷��ؼ�����ת��ԭ����Activity
				}
				if (list.get(arg2).equals("Alipay���Խ�")) {
					Intent intent = new Intent();
					intent.setClass(DocList.this, AlipayBlog.class);
					startActivity(intent);
					finish();// ֹͣ��ǰ��Activity,�����д,�򰴷��ؼ�����ת��ԭ����Activity
				}

			}

		});
	}

	public void onBackPressed() {
		Intent intent = new Intent();
		intent.setClass(DocList.this, MainActivity.class);
		startActivity(intent);
		finish();// ֹͣ��ǰ��Activity,�����д,�򰴷��ؼ�����ת��ԭ����Activity
	}
}