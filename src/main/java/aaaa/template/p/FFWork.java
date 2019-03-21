package aaaa.template.p;

import aaaa.template.Template_P;
import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;



/**
 * 北京金恒祥仪器有限公司
 */

public class FFWork {

	public static void main(String[] args) {


		String html = Template_P.getGoodsHtml("http://www.jhxyq.com/");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("table tbody tr td tbody tr td table tbody tr td table tbody tr td a");

		//为1时进行插入
		int state = 2;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl = ("http://www.jhxyq.com/" + elements.get(i).attr("href"))
					.split("index") [0];


			System.out.println(searchurl);
			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) ->  searchurl + "index_" + j + ".html";

			/**公司名称*/
			String company = "北京金恒祥仪器有限公司";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) -> {Elements elements1 =e.getElementsByAttributeValue("class","gyanzg")
					.select("table tbody tr td table tbody tr td table tbody tr td");
					elements1.removeIf(e1 -> !e1.toString().contains("img"));
					return elements1;
			};

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> "http://www.jhxyq.com/" +
					e.select("a img")
					.attr("src");

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.select("a")
							.attr("title");

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) -> "http://www.jhxyq.com/" +
					e.select("a")
							.attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
		}
	}
}

