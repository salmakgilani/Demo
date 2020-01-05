package Links;

	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.MalformedURLException;
	import java.net.URL;

	public class imageUtility {
		public static void responseForLink(String image)
		{
			try {
				URL url = new URL(image);
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
				
			} catch (IOException e) {
				System.out.println("image is broken");
			}
		}

}
