package aaaa.work.康铂创想北京科技有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 康铂创想（北京）科技有限公司
 */

public class PWork_comper3028 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> {
			if (i ==1) {
				return  "https://www.comper.com/cn/";
			}
			else {
				System.exit(1);
			}
			return null;
		};

		/**公司名称*/
		String company = "康铂创想（北京）科技有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> {
			Elements elements = e.getElementsByAttributeValue("class", "bzw_list");
			elements.addAll(e.getElementsByAttributeValue("class","bzw_list bzw_list_bottom"));
			return elements;
		};
		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) -> "https://www.comper.com/cn/" +
				e.select("a img").attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("class","bzw_list_con")
				.select("span.bzw_title")
				.text();

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "https://www.comper.com/cn/"  + e.select("a")
				.get(0)
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
