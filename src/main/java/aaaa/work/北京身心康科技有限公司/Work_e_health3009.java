package aaaa.work.北京身心康科技有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京身心康科技有限公司
 */

public class Work_e_health3009 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> {
			if (i == 1) {
				return  "http://www.e-health.cc/html/product/";
			}
			else {
				System.exit(1);
			}
			return null;
			};


		/**公司名称*/
		String company = "北京身心康科技有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> e.select("ul.ProductList li");

		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->"http://www.e-health.cc" + e.select("p.PP1 a img")
				.attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.select("p.PP2 a").text();

		/**获取商品的URL详细页方法    http://www.dlmedical.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.e-health.cc" + e.select("p.PP2 a")
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}

}

