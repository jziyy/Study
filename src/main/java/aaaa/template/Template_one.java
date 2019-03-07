package aaaa.template;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;
import static aaaa.template.Template_P.insert;

/**
 * 单页模板
 */
public class Template_one {


	public static void pcTemplate(String  searchurl, Function<Document,Elements> FMain,
							Function<Element,String> FimgUrl,Function<Element,String> FgoodName,
							Function<Element,String> FgoodUrl,String company) {
		
		try {

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
				String html = getGoodsHtml(searchurl);
				Document doc = Jsoup.parse(html);

				Elements elements1 = FMain.apply(doc);
				for (Element e:elements1) {
					 imgUrl = FimgUrl.apply(e);
					 goodName = FgoodName.apply(e);
					 goodUrl =  FgoodUrl.apply(e);
					 goodsHtml = getGoodsHtml(goodUrl);
					 goodId = UUID.randomUUID().toString().replaceAll("-", "");
					 HashMap<Object,Object> map = new HashMap<>();
					 map.put("goodId", goodId);
					 map.put("goodName", goodName);
					 map.put("goodUrl", goodUrl);
					 map.put("imgUrl", imgUrl);
				 	 map.put("goodsHtml", goodsHtml);
					 map.put("ptname", company);

					System.out.println(goodId);
					System.out.println(goodName);
					System.out.println(goodUrl);
					System.out.println(imgUrl);
					System.out.println(company);

 					 String insert = insert(map);
 					 System.out.println(insert);


			}
			
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	 


}
