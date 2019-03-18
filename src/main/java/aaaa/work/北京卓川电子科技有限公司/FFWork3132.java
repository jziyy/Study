package aaaa.work.北京卓川电子科技有限公司;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京卓川电子科技有限公司
 */

public class FFWork3132 {

	public static void main(String[] args) {


		String html = getGoodsHtml("http://yibaichuan.com/main-showProduct-id-697.html");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("div.my_left_cat_list div.h2_cat");
		System.out.println(elements.size());
		//为1时进行插入
		int state = 1;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl = "http://yibaichuan.com" + elements.get(i).select("h3 a").attr("href");


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
			String company = "北京卓川电子科技有限公司";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) -> e.select("div.product_list");

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> "http://yibaichuan.com" +
					e.select("table tbody tr td a img").attr("src");

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->e.select("table tbody tr td a img").attr("alt");

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) ->"http://yibaichuan.com" +
					e.select("table tbody tr td a").attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
		}
	}
}

