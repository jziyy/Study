package aaaa.work.北京康华科仪科技有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京康华科仪科技有限公司
 */

public class PWork3175 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> {
			if (i <=3) {
				return  "http://www.kh-ky.cn/kh/product.asp?class=&classname=&key=&price1=&price2=&page="+ i +"&section=1";
			}
			else {
				System.exit(1);
			}
			return null;
		};

		/**公司名称*/
		String company = "北京康华科仪科技有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> {
			Elements elements = e.getElementsByAttributeValue("id", "table4")
					.select("tbody tr td table tbody tr td table tbody");
			elements.removeIf(element -> element.select("tr").size() < 2);
			return elements;
		};
		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) -> "http://www.kh-ky.cn/kh/" +
				e.select("a img").attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("class","title2")
				.text();

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.kh-ky.cn/kh/"  + e.select("a")
				.get(0)
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
