package aaaa.work.北京东西分析仪器有限公司;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京东西分析仪器有限公司
 */

public class FFWork_ewai3014 {

	public static void main(String[] args) {


		String html = getGoodsHtml("http://www.ewai-group.com/index.php?m=content&c=index&a=lists&catid=28");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.getElementsByAttributeValue("class","lt").select("li.er a");

		//为1时进行插入
		int state = 1;
		for (int i = 0; i < elements.size(); i++) {

			String searchurl = elements.get(i).attr("href");

			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) ->  searchurl + "&page=" + j;

			/**公司名称*/
			String company = "北京东西分析仪器有限公司";

			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) -> e.select("ul.xw_ul li");

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> {
				String html1 = getGoodsHtml(e.select("span a").attr("href"));
				Document doc1 = Jsoup.parse(html1);
				//divgg_nr
				if (doc1.select("div.content div div img").size()==0){
					return doc1.select("div.content div img").attr("src");
				}
				return doc1.select("div.content div div img").attr("src");
			};

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.select("span a").text();

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) ->
					e.select("span a").attr("href");

			Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
		}
	}
}

