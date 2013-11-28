AndroidJavaScriptCallBack
=========================
This application shows how to call back a class function from a java script .<br/>
For this all you need is to follow few simple steps : <br/>
<br/><br/>
Step 1: Create html file with a simple java script.<br/>
	  The html file has to be placed in the assets folder.<br/>
Step 2: Create a simple layout with a button and webview.<br/>
Step 3: Create the main activity class .<br/>
Step 4: Create a java script handler class to get the response back from the java script.<br/><br/>

____________________________________________________________________________________________________________________________________________
Step 1: Create html file with a simple java script.<br/>
	  The html file has to be placed in the assets folder.<br/>

<script type="text/javascript">
        function displayMessage(){
        	document.getElementById('test1').innerHTML = 'This is from java script.';
        	Android.returnResult();
        }
</script>


	<h1 id="test1">Hello World</h1>

____________________________________________________________________________________________________________________________________________
Step 2: Create a simple layout with a button and webview.

    <WebView
        android:id="@+id/myWebView"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent" />

____________________________________________________________________________________________________________________________________________
Step 3: Create the main activity class .

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



____________________________________________________________________________________________________________________________________________
Step 4: Create a java script handler class to get the response back from the java script.

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

