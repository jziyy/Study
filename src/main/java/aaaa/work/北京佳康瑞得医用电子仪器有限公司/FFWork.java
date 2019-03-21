package aaaa.work.北京佳康瑞得医用电子仪器有限公司;

import aaaa.template.Template_P;
import aaaa.template.Template_p2;
import aaaa.template.Template_p2_2312;
import aaaa.util.HttpClient_Get_Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.function.Function;



/**
 * 北京佳康瑞得医用电子仪器有限公司
 */

public class FFWork {

	public static void main(String[] args) {


		String html = Template_P.getGoodsHtml("http://www.jiakangdiag.com/cp.htm");
		Document doc = Jsoup.parse(html);

		Elements elements11 = doc.getElementsByAttributeValue("valign","top").select("tbody");
		elements11.removeIf(element -> element.select("tbody").size()!=1);
		Elements elements =elements11.select("td a");

		//为1时进行插入
		int state = 1;
		for (int i = 0; i < elements.size(); i++) {





			String searchurl = "http://www.jiakangdiag.com/" + elements.get(i).attr("href");


			System.out.println(searchurl);
			/**产品地址*/

			Function<Integer, String> Fsearchurl = (j) ->  {
				if (j == 1){
					return searchurl;
				}
				else {
					return null;
				}
			};

			/**公司名称*/
			String company = "北京佳康瑞得医用电子仪器有限公司";



			/**获取所有的产品标签方法*/
			Function<Document, Elements> FMain = (e) ->e.select("table table table")
					.get(1)
					.select("a");

			/**获取单个产品标签的图片url方法*/
			Function<Element, String> FimgUrl = (e) -> {
				String html1 = null;
				try {
					html1 = HttpClient_Get_Url.getHtmlByHttpclientgb2312( "http://www.jiakangdiag.com/" +
							e.attr("href"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Document document = Jsoup.parse(html1);
				if (document.getElementsByAttributeValue("align","center").select("p img").size()==1){
				return "http://www.jiakangdiag.com/" + document.getElementsByAttributeValue("align","center")
						.select("p img").get(0).attr("src");
				}
				return "http://www.jiakangdiag.com/" + document.getElementsByAttributeValue("align","center")
						.select("p img").get(1).attr("src");
			};

			/**获取商品名称的方法*/
			Function<Element, String> FgoodName = (e) ->
					e.text();

			/**获取商品的URL详细页方法    http://www.glory-way.com/*/
			Function<Element, String> FgoodUrl = (e) -> "http://www.jiakangdiag.com/" +
					e.attr("href");

			Template_p2_2312.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);

			System.out.println("======" + i);
			}

	}
}

