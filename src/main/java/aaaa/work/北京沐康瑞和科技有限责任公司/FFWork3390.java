package aaaa.work.北京沐康瑞和科技有限责任公司;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京沐康瑞和科技有限责任公司
 */

public class FFWork3390 {

	public static void main(String[] args) {


		String html = getGoodsHtml("http://www.mklifecare.com/");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("div.content-left").select("a");
		System.out.println(elements.size());
		//为1时进行插入
		int state = 1;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl =elements.get(i).attr("href");


			System.out.println(searchurl);
			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) -> { if(j==1){ return searchurl;}
			return null;

			};

			/**公司名称*/
			String company = "北京沐康瑞和科技有限责任公司";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("class","ct")
					.select("ul li");

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) ->
					e.select("a img")
					.attr("src");

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.select("strong").text();

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) ->
					e.select("a").get(0)
							.attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
		}
	}
}

