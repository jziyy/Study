package aaaa.work.康帕国际科技;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 康帕国际科技（北京）有限公司
 */

public class PWork3051 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> {
			if (i ==1) {
				return  "http://www.compassinternational.cn/cpzx";
			}
			else {
				System.exit(1);
			}
			return null;
		};

		/**公司名称*/
		String company = "康帕国际科技（北京）有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) ->  e.getElementsByAttributeValue("class", "w_piclist_item clearfix");

		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->e.select("div.w_piclist_img a img").attr("data-original");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.select("div.w_piclist_img a img")
				.get(0)
				.attr("alt").replaceAll(" ","");

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.compassinternational.cn/"  + e.select("div a")
				.get(0)
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
