package aaaa.work.北京神鹿医疗器械有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京神鹿医疗器械有限公司
 */

public class Work_bjshenlu3024 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) ->"http://www.bjshenlu.com/html/cpzx/list_5_"+ i +".html";

		/**公司名称*/
		String company = "北京神鹿医疗器械有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("class","col-sm-4 col-md-3 col-mm-6 product_img");

		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->  "http://www.bjshenlu.com" + e.getElementsByAttributeValue("class","img-thumbnail").attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("class","product_title")
				.select("a").text();

		/**获取商品的URL详细页方法     http://www.bjshenlu.com*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.bjshenlu.com" + e.getElementsByAttributeValue("class","product_title")
				.select("a")
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
