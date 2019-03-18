package aaaa.work.科睿驰医疗科技发展有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 科睿驰（北京）医疗科技发展有限公司
 */

public class PWork3048 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> {
			if (i ==1) {
				return  "http://www.cardiolink.com.cn/product_category.php";
			}
			else {
				System.exit(1);
			}
			return null;
		};

		/**公司名称*/
		String company = "科睿驰（北京）医疗科技发展有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("id", "productList")
				.select("dl");
		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->e.select("dt a img").attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.select("dd p a").text();

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> e.select("dd p a")
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
