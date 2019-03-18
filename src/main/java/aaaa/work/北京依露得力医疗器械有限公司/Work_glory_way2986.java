package aaaa.work.北京依露得力医疗器械有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京依露得力医疗器械有限公司
 */

public class Work_glory_way2986 {

	public static void main(String[] args) {
		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> "http://www.glory-way.com/products.php?sortid=0&sortid2=0&sortid3=0&kws=&page=" + i;

		/**公司名称*/
		String company = "北京依露得力医疗器械有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> e.select("ul.productslist li");

		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->"http://www.glory-way.com/" + e.select("img.fl").attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("class","fl wz")
				.select("h1 a").text();

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.glory-way.com/" + e.getElementsByAttributeValue("class","fl wz")
				.select("h1 a").attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,1);
	}


}
