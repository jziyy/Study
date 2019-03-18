package aaaa.work.北京华夏通商科技发展有限公司;

import aaaa.template.Template_p2;
import aaaa.util.GetUrlStr;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京华夏通商科技发展有限公司
 */

public class FFWork3232 {

	public static void main(String[] args) {

		String html = getGoodsHtml("http://www.c-ts.com.cn/Products.asp?BigClass=%B1%A3%CE%C2%CF%E4");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("div.product a");

		//为1时进行插入
		int state = 1;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl = ("http://www.c-ts.com.cn/" + GetUrlStr.changeChinaToURL(elements.get(i).attr("href")));


			System.out.println(searchurl);
			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) ->  {
				if (j==1){
				return searchurl;
				}else {
					return null;
				}
			};

			/**公司名称*/
			String company = "北京华夏通商科技发展有限公司";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) -> {
				Elements elements1 =e.select("td");
				elements1.removeIf(e1 -> e1.select("td").size()!=8);
					return elements1;
			};

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> "http://www.c-ts.com.cn/" +GetUrlStr.changeChinaToURL(
					e.select("a img")
					.attr("src"));

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.select("span a").text();

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) -> "http://www.c-ts.com.cn/" + GetUrlStr.changeChinaToURL(
					e.select("a").get(0)
							.attr("href"));

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
		}
	}
}

