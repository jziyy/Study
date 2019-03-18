package aaaa.work.北京泰格科信生物科技有限公司;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京泰格科信生物科技有限公司
 */

public class FFWork3199 {

	public static void main(String[] args) {


		String html = getGoodsHtml("http://www.tigsun.com/cn/hxfgsj.html");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("div.nav_search a");

		//为1时进行插入
		int state = 1;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl = ("http://www.tigsun.com" + elements.get(i).attr("href"));
			System.out.println(searchurl);

			Elements elements1 = Jsoup.parse(getGoodsHtml(searchurl))
					.getElementsByAttributeValue("class","cplb_zy");
			elements1.forEach(element -> {
				String searchurl1 = "http://www.tigsun.com" + element.select("a").attr("href");

				Elements elements2 = Jsoup.parse(getGoodsHtml(searchurl1))
						.getElementsByAttributeValue("class","cplb_nav").select("a");
				elements2.forEach(element1 -> {

					String searchurl3 = "http://www.tigsun.com" + element1.attr("href");



					/**产品地址*/

					Function<Integer, String> Fsearchurl = (j) ->  {
						if (j==1){
							return searchurl3;
						}
						else {
							return null;
						}
					};

					/**公司名称*/
					String company = "北京泰格科信生物科技有限公司";

					/**获取所有的产品标签方法*/
					Function<Document, Elements> FMain = (e) -> {
						Elements elements4 =e.getElementsByAttributeValue("class","cplb_con")
							.get(0).getElementsByAttributeValue("class","cplb_pic");

						return elements4;
					};

					/**获取单个产品标签的图片url方法*/
					Function<Element, String> FimgUrl = (e) ->"http://www.tigsun.com" +
							e.select("img")
									.attr("src");

					/**获取商品名称的方法*/
					Function<Element, String> FgoodName = (e) ->
							e.select("i").text();

					/**获取商品的URL详细页方法    http://www.glory-way.com/*/
					Function<Element, String> FgoodUrl = (e) -> "http://www.tigsun.com" +
							e.select("a")
									.attr("href");

					Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);




				});





			});


		}
	}
}

