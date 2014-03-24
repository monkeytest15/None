package com.alipay.portal.Docs;

import com.example.alitool2.MainActivity;
import com.example.alitool2.R;
import com.example.alitool2.R.id;
import com.example.alitool2.R.layout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PortalAutomationDoc extends Activity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);       
        Intent intent = getIntent();
		this.setTitle("�̻�Ӧ�ò��Լ����ĵ�");

        
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true); 
        myWebView.requestFocus();
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true); 
        myWebView.getSettings().setSupportMultipleWindows(true);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setUseWideViewPort(true); 
        myWebView.getSettings().setLoadWithOverviewMode(true);         //���ó������Ź���   
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.loadUrl("http://doc.alipay.net/pages/viewpage.action?pageId=68422645");
        
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

	public void onBackPressed() {
		Intent intent = new Intent();
		intent.setClass(PortalAutomationDoc.this, DocList.class);
		startActivity(intent);
		finish();// ֹͣ��ǰ��Activity,�����д,�򰴷��ؼ�����ת��ԭ����Activity
	}
}
