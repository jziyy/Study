package aaaa.template;

import aaaa.util.HttpClient_Get_Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;
import static aaaa.template.Template_P.insert;

/**
 * 多页模板1.0
 */
public class Template_p2_2312 {


	public static void pcTemplate(Function<Integer,String> Fsearch, Function<Document,Elements> FMain,
							Function<Element,String> FimgUrl,Function<Element,String> FgoodName,
							Function<Element,String> FgoodUrl,String company,int state) {
		
		try {
			//查询地址
			String  searchurl =null;
			//商品详细信息
			String goodsHtml =null;
			//图片地址
			String imgUrl  =null;
			//商品名称
			String goodName =null;
			//商品id
			String goodId =null;
			//商品url
			String goodUrl =null;
			int i = 1;
			while (true) {

				searchurl = Fsearch.apply(i);
				if (StringUtils.isEmpty(searchurl)){
					return;
				}
				String html = HttpClient_Get_Url.getHtmlByHttpclientgb2312(searchurl);
				if (StringUtils.isEmpty(html.trim())){
					break;
				}
				Document doc = Jsoup.parse(html);

				Elements elements1 = FMain.apply(doc);
				if (elements1.size()==0){
					System.out.println(elements1.size());
					break;
				}
				int a = 1;
				for (Element e:elements1) {
					 System.out.println(a++);
					 imgUrl = FimgUrl.apply(e);
					 goodName = FgoodName.apply(e);
					try {
					 goodUrl =  FgoodUrl.apply(e);


						 goodsHtml = getGoodsHtml(goodUrl);
					 }catch (Exception e1){

					 }
					 goodId = UUID.randomUUID().toString().replaceAll("-", "");
					 HashMap<Object,Object> map = new HashMap<>();
					 map.put("goodId", goodId);
					 map.put("goodName", goodName);
					 map.put("goodUrl", goodUrl);
					 map.put("imgUrl", imgUrl);
				 	 map.put("goodsHtml", goodsHtml);
					 map.put("ptname", company);
					 System.out.println("第" + i + "页");

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

			}i++;

			}



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	 


}
