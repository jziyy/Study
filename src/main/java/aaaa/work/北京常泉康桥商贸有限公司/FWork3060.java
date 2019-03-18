package aaaa.work.北京常泉康桥商贸有限公司;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京常泉康桥商贸有限公司
 */

public class FWork3060 {

	public static void main(String[] args) {
//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer, String> Fsearchurl = (i) -> {
			if (i <= 2) {
				return  "http://www.bridgemedical.cn/cp_list.asp?an=&page=" + i;
			}
			else {
				System.exit(0);
				return "";
			}
		};
		/**公司名称*/
		String company = "北京常泉康桥商贸有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> {
			Elements elements = e.getElementsByAttributeValue("class","fl");

			elements.removeIf((element)-> element.select("table").size() == 0);
			Elements elements1 = elements.get(0).getElementsByAttributeValue("valign","top");
			elements1.removeIf(element -> element.select("table").size() == 0);
			elements1.removeIf(element -> element.select("img").size() > 1);
			return elements1;
		};
		/**获取单个产品标签的图片url方法*/
		Function<Element, String> FimgUrl = (e) -> "http://www.bridgemedical.cn/" +
				e.select("img").attr("src");


		/**获取商品名称的方法*/
		Function<Element, String> FgoodName = (e) ->{
			Elements elements = e.select("table tbody tr");
			elements.removeIf(element -> !element.text().contains("产品名称"));
			return elements.get(0).select("td a").text();
		};

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element, String> FgoodUrl = (e) -> {
			Elements elements = e.select("table tbody tr");
			elements.removeIf(element -> !element.text().contains("产品名称"));
			return  "http://www.bridgemedical.cn/" + elements.get(0).select("td a").attr("href");};

		Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);
	}

}
