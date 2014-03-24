package com.alipay.portal.Docs;

import com.alipay.portal.Docs.PortalAutomationDoc.MyWebViewClient;
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
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

public class PortalDemoDoc extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		Intent intent = getIntent();
		this.setTitle("商户应用Demo文档");


		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.requestFocus();
		myWebView.setWebViewClient(new MyWebViewClient() {

			@Override
			public void onReceivedSslError(WebView view,
					SslErrorHandler handler, SslError error) {
				handler.proceed();

			}
		});

		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setSupportMultipleWindows(true);
		myWebView.getSettings().setSupportZoom(true);
		myWebView.getSettings().setUseWideViewPort(true);

		myWebView.getSettings().setLoadWithOverviewMode(true); // 设置出现缩放工具
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView
				.loadUrl("http://demo.alibaba-inc.com/categories/358/projects/7018?ticket=2049d407-10a5-426e-a1c7-e8b6eabc932e");

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

	private class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			view.loadUrl(url); 
			Log.e("xxxx","xxx");
			return true; 	}
	}

	public void onBackPressed() {
		Intent intent = new Intent();
		intent.setClass(PortalDemoDoc.this, DocList.class);
		startActivity(intent);
		finish();// 停止当前的Activity,如果不写,则按返回键会跳转回原来的Activity
	}
}
