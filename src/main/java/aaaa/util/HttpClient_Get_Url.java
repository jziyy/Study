package aaaa.util;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class HttpClient_Get_Url {
	/**
	 * 根据百度url,获取原本url
	 * @throws IOException 
	 * @throws HttpException 
	 * */
	public static String GetTrueUrlByBaiduUrl(String baidu_url) throws HttpException, IOException{
		//---------------------------1
		HttpClient client = new HttpClient();
		//设置代理IP
		//client.getHostConfiguration().setProxy("172.22.40.20", 8080);
		GetMethod getMethod = new GetMethod(baidu_url);
		//获取状态码
		int stateCode =client.executeMethod(getMethod);
		String text=getMethod.getResponseBodyAsString();
		String url =getMethod.getName()+getMethod.getPath();
		System.out.println(url);
		//释放
		getMethod.releaseConnection();
		if (stateCode == HttpStatus.SC_OK) {
			//text=text.split("URL='")[1].split("'")[0];
			//System.out.println("访问成功,网址:"+text);
			return text;
		}
		return null;
	}
	/**
	 * 根据百度url,获取stateCode
	 * @throws IOException 
	 * @throws HttpException 
	 * */
	
	public static int GetStateCode(String url) throws HttpException, IOException{
		//---------------------------1
		HttpClient client = new HttpClient();
		//设置代理IP
		//client.getHostConfiguration().setProxy("172.22.40.20", 8080);
		GetMethod getMethod = new GetMethod(url);
		//获取状态码
		int stateCode =client.executeMethod(getMethod);
		return stateCode;
	}
	
	public static void trustEveryone() {
		try {
			HttpsURLConnection
					.setDefaultHostnameVerifier(new HostnameVerifier() {
						public boolean verify(String hostname,
								SSLSession session) {
							return true;
						}
					});
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[] { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			} }, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context
					.getSocketFactory());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}	
	
	
	/**
	 * httpclient请求url返回html
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * */
	public static String getHtmlByHttpclient(String url) throws ClientProtocolException, IOException{
		trustEveryone();
		//httpclient访问
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		String ahtml = EntityUtils.toString(entity, "UTF-8");
		httpget.releaseConnection();//释放连接
		//System.out.println(ahtml);
		return ahtml;
	}
	
	
	/**
	 * httpclient请求url返回html
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * */
	public static String getHtmlByHttpclientgb2312(String url) throws ClientProtocolException, IOException{
		trustEveryone();
		//httpclient访问
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		String ahtml = EntityUtils.toString(entity, "gb2312");
		httpget.releaseConnection();//释放连接
		//System.out.println(ahtml);
		return ahtml;
	}
	/**
	 * httpclient请求url返回html
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * */
	public static String getHtmlByHttpclientPost(String url) throws ClientProtocolException, IOException{
		//httpclient访问
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		RequestConfig requestConfig = RequestConfig.custom()
		.setConnectTimeout(5000)
		.setSocketTimeout(5000)
		.setConnectionRequestTimeout(3000).build();
		httpPost.setConfig(requestConfig);
		String ahtml = EntityUtils.toString(entity, "UTF-8");
		httpPost.releaseConnection();//释放连接
		System.out.println(ahtml);
		return ahtml;
	}
	public static void main(String[] args) throws HttpException, IOException {
		//String url="https://mainsite-restapi.ele.me/shopping/restaurant/150781362?extras%5B%5D=activities&extras%5B%5D=license&extras%5B%5D=identification&extras%5B%5D=albums&extras%5B%5D=flavors&latitude=29.533694&longitude=106.486673";
		//String url="https://shopsearch.taobao.com/search?app=shopsearch&q=%E5%90%8A%E5%B8%A6%E8%83%8C%E5%BF%83&imgfile=&commend=all&ssid=s5-e&search_type=shop&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306&isb=1&shop_type=&ratesum=&goodrate=&loc=%E5%8C%97%E4%BA%AC&s=20";
		//System.out.println(getHtmlByHttpclient(url));
		String text=getHtmlByHttpclientgb2312("http://www.jiakangdiag.com/cpzx.htm");
		System.out.println(text);
		
	}
	

	public static  String getRealUrlFromBaiduUrl(String url) {
	        Connection.Response res = null;
	        int itimeout = 60000;
	        try {
	            res = Jsoup.connect(url).timeout(itimeout).method(Connection.Method.GET).followRedirects(false).execute();
	            return res.header("Location");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "";
	}
}
