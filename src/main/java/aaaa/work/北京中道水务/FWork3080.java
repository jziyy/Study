package aaaa.work.北京中道水务;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京中道水务
 */

public class FWork3080 {

	public static void main(String[] args) {
//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer, String> Fsearchurl = (i) -> {
			if (i <= 6) {
				return  "http://www.bjzdsw.com.cn/cpzs/index_" + i + ".html";
			}
			else {
				System.exit(0);
				return "";
			}
		};
		/**公司名称*/
		String company = "北京中道水务";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("class","gsjj cpzs left").select("dd");


		/**获取单个产品标签的图片url方法*/
		Function<Element, String> FimgUrl = (e) -> "http://www.bjzdsw.com.cn" +
				e.getElementsByAttributeValue("class","tp").select("a img").attr("src");


		/**获取商品名称的方法*/
		Function<Element, String> FgoodName = (e) ->e.getElementsByAttributeValue("class","tp").select("a img").attr("alt");

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element, String> FgoodUrl = (e) -> e.getElementsByAttributeValue("class","tp")
				.select("a")
				.get(0)
				.attr("href");
		Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);
	}

}
