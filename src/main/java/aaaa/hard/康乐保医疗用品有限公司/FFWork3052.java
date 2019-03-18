package aaaa.hard.康乐保医疗用品有限公司;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 康乐保（中国）医疗用品有限公司
 */

public class FFWork3052 {

	public static void main(String[] args) {


		String html = getGoodsHtml("https://www.coloplast.cn/products/");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("div.xl-tri-subsection ").get(0).getElementsByAttributeValue("class","wrapper-link");

		//为1时进行插入
		int state = 2;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl = "https://www.coloplast.cn" + elements.get(i).attr("href");


			System.out.println(searchurl);
			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) -> {if (j == 1) {
				return searchurl;
			}else {
				return null;
			}

			};

			/**公司名称*/
			String company = "康乐保（中国）医疗用品有限公司";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) ->e.getElementsByAttributeValue("class","s-cell product-list-item");

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> "https://www.coloplast.cn" +
					e.select("div.image-container img")
					.attr("src");

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.select("div.image-container img")
							.attr("alt");

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) -> e.getElementsByAttributeValue("class","s-cell product-list-item")
					.get(0)
					.select("a").attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
		}
	}
}

