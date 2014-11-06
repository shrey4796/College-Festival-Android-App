package bits.dvm.oasis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

public class ServiceHandler {

	static String response = null;
	public final static int GET = 1;
	public final static int POST = 2;
	
	public ServiceHandler(){
	}
	
	public String makeServiceCall(String url, int method){
		return this.makeServiceCall(url, method, null);
	}
	
	public String makeServiceCall(String url, int method, List<NameValuePair> params){
		
		InputStream is = null;
		
		try{
			
			// http client setup
            DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpEntity httpentity = null;
			HttpResponse httpresponse = null;
			
			//check http request method type
			if(method == POST){
				HttpPost httppost = new HttpPost(url);
				//add post parameters
				if(params!=null){
					httppost.setEntity(new UrlEncodedFormEntity(params));
				}
				
				httpresponse = httpclient.execute(httppost);
			}
			
			else if (method == GET){
				HttpGet httpget = new HttpGet(url);
				//add parameters to url
				if(params!=null){
					String paramString = URLEncodedUtils.format(params, "utf-8");
					url = url + "?" + paramString;
				}
				
				httpresponse = httpclient.execute(httpget);
					
			}
			
			httpentity = httpresponse.getEntity();
			is = httpentity.getContent();
			//response = EntityUtils.toString(httpentity);
			
		}
		catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		catch(ClientProtocolException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Read response to string
		try {	    	
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			response = sb.toString();	            
		} catch(Exception e) {
			return null;
		}
	

			
		return response;
		
	}

	
}
