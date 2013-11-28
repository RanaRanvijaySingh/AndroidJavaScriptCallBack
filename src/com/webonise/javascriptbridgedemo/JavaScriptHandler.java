package com.webonise.javascriptbridgedemo;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class JavaScriptHandler {
	Context mContext;

	public JavaScriptHandler(Context context) {
		mContext = context;
	}

	@JavascriptInterface
	public void returnResult() {
	    Log.v(null, "result received");
	}
}