package aaaa.work.北京德森科技有限公司;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京德森科技有限公司
 */

public class FFWork3385 {

	public static void main(String[] args) {


		String html = getGoodsHtml("http://www.bartizan.cn/index.php/List/index/cid/22.html");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("div.navbg a");

		//为1时进行插入
		int state = 1;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl = ("http://www.bartizan.cn" + elements.get(i).attr("href"));


			System.out.println(searchurl);
			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) ->  searchurl;

			/**公司名称*/
			String company = "北京德森科技有限公司";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) -> {
				Elements elements1 =e.getElementsByAttributeValue("class","prolie g-wrap").get(0)
						.getElementsByAttributeValue("class","slide mr0");

				elements1.addAll(e.getElementsByAttributeValue("class","prolie g-wrap")
						.select("div.slide"));
					return elements1;
			};

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> "http://www.bartizan.cn" +
					e.select("img")
					.attr("src");

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.select("span").text();

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) -> "http://www.bartizan.cn" +
					e.select("a").get(0)
							.attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
		}
	}
}

