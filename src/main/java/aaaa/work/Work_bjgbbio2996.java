package aaaa.work;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;
import static aaaa.template.Template_P.insert;


/**
 * 北京西雅金桥生物科技1
 */

public class Work_bjgbbio2996 {

	public static void main(String[] args) {


		DecimalFormat decimalFormat =new DecimalFormat("00");
		System.out.println(decimalFormat.format(1));

		//当state =1时为插入方法
		int state = 1;
		for (int i = 0; i < 21; i++) {

			int a = i;
			/**url处理方法*/

			Function<Integer, String> Fsearchurl = (j) ->  "http://www.bjgbbio.com/productitem/" + j + "/0000"+ decimalFormat.format(a) +"/.html";

			/**网站名称*/
			String company = "北京西雅金桥生物科技";

			/**获取所有标签*/
			Function<Document, Elements> FMain = (e) -> {
				Elements elements = e.select("tbody tr");
				elements.removeIf(element -> element.select("td a").size()==0);
				return elements;
			};

			/**获取图片url*/
			Function<Element, String> FimgUrl = (e) -> {
				String html = getGoodsHtml("http://www.bjgbbio.com/" +
						e.select("td a").get(0).attr("href"));
				Document doc = Jsoup.parse(html);
				return "http://www.bjgbbio.com/" + doc.getElementsByAttributeValue("class","proitem-img").select("img")
						.attr("src");
			};

			/**获取商品名称*/
			Function<Element, String> FgoodName = (e) ->
					e.select("td a").get(1).text();;

			/**获取商品地址    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) -> "http://www.bjgbbio.com/"+
					e.select("td a").get(0).attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);
		}
	}
	}

