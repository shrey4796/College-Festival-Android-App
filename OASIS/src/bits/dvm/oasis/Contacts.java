package bits.dvm.oasis;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Contacts extends ActionBarActivity implements SHARED_CONSTANTS {

	WebView webView;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

	    if ( keyCode == KeyEvent.KEYCODE_MENU ) {
	        // do nothing
	        return true;
	    }
	
		// Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
		
		
	}
	
	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		
		final ProgressBar loadingPB = (ProgressBar)findViewById(R.id.progressBar1);
		
		TextView textView = (TextView)findViewById(R.id.textView1);
		
		//get typeface
		Typeface typeFace = Typeface.createFromAsset(getAssets(), FONT_PATH_MOJAVE);
		textView.setTypeface(typeFace);
		
		webView = (WebView)findViewById(R.id.webView1);
		
		String webContent = "";
		String title = "";
		
		String page = getIntent().getExtras().getString("page");
		
		if(page.equalsIgnoreCase("contacts")){
			title = "CONTACTS";
			webContent = HTML_STARTER + CONTACTS_HTML;
			loadingPB.setVisibility(View.GONE);
			webView.loadDataWithBaseURL("file:///android_asset/", webContent, "text/html", "utf-8", null);
		}
		else if(page.equalsIgnoreCase("reach")){
			title = "HOW TO REACH";
			webContent = HTML_STARTER + REACH_PILANI;
			loadingPB.setVisibility(View.GONE);
			webView.loadDataWithBaseURL("file:///android_asset/", webContent, "text/html", "utf-8", null);
		}
		else if(page.equalsIgnoreCase("developer")){
			title = "DEVELOPER INFORMATION";
			webContent = HTML_STARTER + DEVELOPER_INFORMATION;
			loadingPB.setVisibility(View.GONE);
			webView.loadDataWithBaseURL("file:///android_asset/", webContent, "text/html", "utf-8", null);
		}
		else if(page.equalsIgnoreCase("facebook")){
			title = "FACEBOOK";
			webContent = "https://www.facebook.com/oasis.bitspilani";
			
			WebSettings wbset = webView.getSettings();
			wbset.setJavaScriptEnabled(true);
			
			webView.setWebViewClient(new WebViewClient());
			

			webView.loadUrl(webContent);
			webView.setWebChromeClient(new WebChromeClient(){
				@Override
				public void onProgressChanged(WebView view, int newProgress) {
					// TODO Auto-generated method stub
					super.onProgressChanged(view, newProgress);
					loadingPB.setProgress(newProgress);
					
					if (newProgress == 100)
						loadingPB.setVisibility(View.GONE);
					else
						loadingPB.setVisibility(View.VISIBLE);
					
				}
			});
			
		}
		else if(page.equalsIgnoreCase("twitter")){
			title = "TWITTER";
			webContent = "https://twitter.com/BITSOasis";
			
			WebSettings wbset = webView.getSettings();
			wbset.setJavaScriptEnabled(true);
			
			webView.setWebViewClient(new WebViewClient());
			

			webView.loadUrl(webContent);
			webView.setWebChromeClient(new WebChromeClient(){
				@Override
				public void onProgressChanged(WebView view, int newProgress) {
					// TODO Auto-generated method stub
					super.onProgressChanged(view, newProgress);
					loadingPB.setProgress(newProgress);
					
					if (newProgress == 100)
						loadingPB.setVisibility(View.GONE);
					else
						loadingPB.setVisibility(View.VISIBLE);
					
				}
			});
			
		}
		else if(page.equalsIgnoreCase("youtube")){
			title = "YOUTUBE";
			webContent = "http://www.youtube.com/playlist?list=PLnx9KurOVkQPOLWXIh5ldzPjM6J9aET1j";
			
			WebSettings wbset = webView.getSettings();
			wbset.setJavaScriptEnabled(true);
			
			webView.setWebViewClient(new WebViewClient());
			

			webView.loadUrl(webContent);
			webView.setWebChromeClient(new WebChromeClient(){
				@Override
				public void onProgressChanged(WebView view, int newProgress) {
					// TODO Auto-generated method stub
					super.onProgressChanged(view, newProgress);
					loadingPB.setProgress(newProgress);
					
					if (newProgress == 100)
						loadingPB.setVisibility(View.GONE);
					else
						loadingPB.setVisibility(View.VISIBLE);
					
				}
			});
			
		}
		else if(page.equalsIgnoreCase("blog")){
			title = "BLOG";
			webContent = "http://bits-oasis.org/blogs/english/";
			
			WebSettings wbset = webView.getSettings();
			wbset.setJavaScriptEnabled(true);
			
			webView.setWebViewClient(new WebViewClient());
			

			webView.loadUrl(webContent);
			webView.setWebChromeClient(new WebChromeClient(){
				@Override
				public void onProgressChanged(WebView view, int newProgress) {
					// TODO Auto-generated method stub
					super.onProgressChanged(view, newProgress);
					loadingPB.setProgress(newProgress);
					
					if (newProgress == 100)
						loadingPB.setVisibility(View.GONE);
					else
						loadingPB.setVisibility(View.VISIBLE);
					
				}
			});
			
		}

		
		textView.setText(title);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.contacts, menu);
		return true;
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}
}
