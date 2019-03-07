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
 * 多页模板1.0
 */
public class Template_p2 {


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
				String html = getGoodsHtml(searchurl);
				Document doc = Jsoup.parse(html);

				Elements elements1 = FMain.apply(doc);
				if (elements1.size()==0){
					break;
				}
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
					 System.out.println("第" + i + "页");

					 System.out.println("goodId    :  " + goodId);
					 System.out.println("goodName  :  " + goodName);
					 System.out.println("goodUrl   :  " + goodUrl);
					 System.out.println("imgUrl    :  " + imgUrl);
					 System.out.println("company   :  " + company);
					 System.out.println("goodsHtml :  " + goodsHtml.substring(0,50));
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
