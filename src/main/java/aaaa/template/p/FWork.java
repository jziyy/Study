package aaaa.template.p;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京西雅金桥生物科技
 */

public class FWork {

	public static void main(String[] args) {


		DecimalFormat decimalFormat =new DecimalFormat("00");
		System.out.println(decimalFormat.format(1));

		//为1时进行插入
		int state = 2;
		for (int i = 0; i < 21; i++) {

			int a = i;
			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) ->  "http://www.bjgbbio.com/productitem/" + j + "/0000"+ decimalFormat.format(a) +"/.html";

			/**公司名称*/
			String company = "北京西雅金桥生物科技";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) -> {
				Elements elements = e.select("tbody tr");
				elements.removeIf(element -> element.select("td a").size()==0);
				return elements;
			};

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> {
				String html = getGoodsHtml("http://www.bjgbbio.com/" +
						e.select("td a").get(0).attr("href"));
				Document doc = Jsoup.parse(html);
				return "http://www.bjgbbio.com/" + doc.getElementsByAttributeValue("class","proitem-img").select("img")
						.attr("src");
			};

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.select("td a").get(1).text();;

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) -> "http://www.bjgbbio.com/"+
					e.select("td a").get(0).attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);
		}
	}
}

