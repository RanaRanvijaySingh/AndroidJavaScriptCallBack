package com.webonise.javascriptbridgedemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {
	WebView myWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myWebView = (WebView) this.findViewById(R.id.myWebView);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.addJavascriptInterface(new JavaScriptHandler(this), "Android");
		myWebView.loadUrl("file:///android_asset/index.html");
	}

	public void callJavaScript(View view) {
		Log.v(null, "Calling java Script");
		myWebView.loadUrl("javascript:displayMessage()");
	}
}
