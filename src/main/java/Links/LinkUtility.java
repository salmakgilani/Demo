package Links;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkUtility {
	public static void responseForLink(String link) 
	{
		
		try {
			URL url = new URL(link);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(2000);
			httpUrlConnection.connect();
			int code = httpUrlConnection.getResponseCode();
			String msg = httpUrlConnection.getResponseMessage();
			URL url1 = httpUrlConnection.getURL();
			if (code == 200) {
				System.out.println(url1 + "is working fine. And the response code is: " +code+ "response msg is: " + msg);
			}
			else {
				System.out.println(url1 + "is not working fine. And the response code is: " +code+ "response msg is: " + msg);
		
			}
			
		} catch (Exception e) {
			System.out.println("Link is broken");
			System.out.println(e.getMessage());
		}
	}

}
