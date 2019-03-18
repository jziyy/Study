package aaaa.work.北京恒瑞天创机电设备有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京恒瑞天创机电设备有限公司
 */

public class PWork3314 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) ->   "http://www.60301676.com/Products-p" + i + "/";

		/**公司名称*/
		String company = "北京恒瑞天创机电设备有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) ->
			e.getElementsByAttributeValue("id", "ind_pro_img");
		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->
				e.select("img").attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) ->e
				.select("h1 a")
				.text();

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.60301676.com"  + e.select("a")
				.get(0)
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
