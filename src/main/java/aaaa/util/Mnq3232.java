package aaaa.util;

	/**
	 * 店铺的评论
	 * */

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserPreferences;
import com.teamdev.jxbrowser.chromium.LoggerProvider;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;

import static aaaa.template.Template_P.getGoodsHtml;
import static aaaa.template.Template_P.insert;


public class Mnq3232 {
		private static String html;
		private static Document doc;
		private static Document parse;


	/**
	 *
	 * @param searchUrl
	 * @param document
	 * @param FMain
	 * @param FimgUrl
	 * @param FgoodName
	 * @param FgoodUrl
	 * @param company
	 * @param state
	 * @throws ParseException
	 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void search_url(String searchUrl, String document,Function<Document,Elements> FMain,
									  Function<Element,String> FimgUrl,Function<Element,String> FgoodName,
									  Function<Element,String> FgoodUrl,String company,int state) throws ParseException{

			//初始化模拟器
			LoggerProvider.getBrowserLogger().setLevel(Level.SEVERE);
			LoggerProvider.getIPCLogger().setLevel(Level.SEVERE);
			LoggerProvider.getChromiumProcessLogger().setLevel(Level.SEVERE);

			final Browser browser = new Browser();
			BrowserView browserView = new BrowserView(browser);

			BrowserPreferences preferences = browser.getPreferences();
			preferences.setImagesEnabled(false);

			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.add(browserView, BorderLayout.CENTER);
			frame.setSize(1000, 500);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			invokeAndWaitReady(browser, ()->browser.loadURL(searchUrl));





			
			// 设置滚动条滚动速度
			scrollbarspeed(browser);
			//"document.getElementsByClassName('time js_item')[0].click()"
			browser.executeJavaScriptAndReturnValue(document);
			try {
				Thread.sleep(2000 * 1);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			html= browser.getHTML().replaceAll("&nbsp;","");
			doc = Jsoup.parse(html);

			System.out.println("update===================================================================================");
			Elements elements = FMain.apply(doc);
			System.out.println("条数="+elements.size());
			String content;
			String user;
			String time= null;
			String ev_num = null;
			String hpl = null;
			int is_bad=0;

			for (Element e:elements) {
				String imgUrl = FimgUrl.apply(e);
				String goodName = FgoodName.apply(e);
				String goodUrl = FgoodUrl.apply(e);
				String goodsHtml = getGoodsHtml(goodUrl);
				String goodId = UUID.randomUUID().toString().replaceAll("-", "");
				HashMap<Object,Object> map = new HashMap<>();
				map.put("goodId", goodId);
				map.put("goodName", goodName);
				map.put("goodUrl", goodUrl);
				map.put("imgUrl", imgUrl);
				map.put("goodsHtml", goodsHtml);
				map.put("ptname", company);

				System.out.println("goodId    :  " + goodId);
				System.out.println("goodName  :  " + goodName);
				System.out.println("goodUrl   :  " + goodUrl);
				System.out.println("imgUrl    :  " + imgUrl);
				System.out.println("company   :  " + company);
				if (goodsHtml.length() > 50){
					System.out.println("goodsHtml :  " + goodsHtml.substring(0,50));
				}else {
					System.out.println(goodsHtml);
				}
				System.out.println();
				System.out.println("-------------------------------------------");
				System.out.println();
				if (state==1) {

					String insert = insert(map);
					System.out.println(insert);
				}

			}
			
//			//判断是否存在下一页
//			while( !doc.getElementsByAttributeValue("class","item next js_next abled").select("div").isEmpty()){
//				browser.executeJavaScriptAndReturnValue("document.getElementsByClassName('item next js_next abled')[0].getElementsByTagName('span')[0].click()");
//				try {
//					Thread.sleep(2000);//沉睡2s
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				// 设置滚动条滚动速度
//				scrollbarspeed(browser);
//
//				//点击时间排序
//
//				html= browser.getHTML().replaceAll("&nbsp;","");
//				doc = Jsoup.parse(html);
//				elements = doc.getElementsByAttributeValue("class","cmt-list js_commentList").select("div");
//				System.out.println("条数="+elements.size());
//
//
//				for(Element e : elements){
//
//						user = e.select("p.nickname a").text();
//						content = e.select("p.js_contentAll").text();
//						if (e.select("p.ct-extra span").text().contains("月")){
//							String [] strings = e.select("p.ct-extra span").text().split("\\|");
//							for (int i = 0; i < strings.length; i++) {
//								if (strings [i].contains("月")){
//									time=strings [i].replace("年", "-").replace("月", "-").replace("日", "").replace("发表于","")
//											.replace(" ","");
//									System.out.println(time);
//									break;
//								}
//							}
//						}
//						hpl=e.select("div.cmt-content p.num").text();
//						hpl=hpl.replace("width:", "").replace("%;", "").replace(" ","");
//
//						Double a=Double.valueOf(hpl);
//						if(a>30){
//							is_bad=0;
//						}else{
//							is_bad=1;
//						}
//						if(time.contains("2019-01")){
//							System.out.println("ev_user=" + user);
//							System.out.println("ev_time=" + time);
//							System.out.println("is_bad=" + is_bad);
//							System.out.println("ev_content=" + content);
//							System.out.println("---------------------------------------------------------------------------------------------");
//							//插入数据库
//						}else if(time.contains("2019-02") || time.contains("2019-03") ){
//							continue;
//						}else{
//							return;
//						}
//				}
//				}
			}

		private static void scrollbarspeed(Browser browser) {
			for (int j = 1; j < 15; j++) {
				browser.executeJavaScriptAndReturnValue("window.scrollTo(100," + j*400 + ")");
				try {
					Thread.sleep(400 * 1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		public static void invokeAndWaitReady(Browser browser, Runnable runnable) {
			final CountDownLatch latch = new CountDownLatch(1);
			LoadAdapter listener = new LoadAdapter() {
				@Override
				public void onFinishLoadingFrame(FinishLoadingEvent event) {
					if (event.isMainFrame()) {
						latch.countDown();
					}
				}
			};
			browser.addLoadListener(listener);
			try {
				runnable.run();
				try {
					if (!latch.await(30, TimeUnit.SECONDS)) {
						// throw new RuntimeException(new TimeoutException());
					}
				} catch (InterruptedException ignore) {
					ignore.printStackTrace();
					Thread.currentThread().interrupt();
				}
			} finally {
				browser.removeLoadListener(listener);
			}
		}

	}

