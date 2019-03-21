package aaaa.work.痉挛肌治疗仪;

import aaaa.template.Template_P;
import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


/**
 * 痉挛肌治疗仪
 */

public class PWork11 {


	public static void main(String[] args) {



			try {
				mainFuction(
						1, //1插入，2不插入
						"痉挛肌治疗仪",//公司名称
						"http://www.bjyykd.com/Product.asp",//网站网址
						1,//页数
						"",//标签的element集合
						" ",//图片地址包含完整时为“”，不完整填 域名
						" ",//获取图片标签
						" ",//获取商品名称
						" ",//产品url完整时为“”，不完整填 域名
						" "//产品标签
				);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}



	public static void mainFuction(int state,String company,String searchURL,
								   int pageIndex,String place,
								   String imgurl,String imgplace,
								   String goodname,String goodurl,String goodplace) {
		String placeholder = "@@@";

		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> {
			if (i==1){
			return searchURL.replaceAll("_" + placeholder, "");
			}
			if(i>pageIndex){
				return null;
			}
			if(searchURL.contains(placeholder)){
				return searchURL.replaceAll(placeholder, String.valueOf(i));
			}
			return searchURL;
		};

		//

		//String place = "div.aaa-aa#OOO#tr.aa aa#OOO#class.aaa aaa";
		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> {
			Elements elements = e.getElementsByAttributeValue("id","Inquire").select("table");
			elements.removeIf(element -> element.select("table").size() !=3);
			System.out.println(elements.size());
			return elements;
		};


		/**获取单个产品标签的图片url方法*/
		Function<Element, String> FimgUrl = (e) -> {
			Elements elements = e.select("table table tr").select("td");
			elements.removeIf(element -> element.select("table").size()!=0);
			elements.removeIf(element -> element.select("img").size()==0);

			return  "http://www.bjyykd.com/" + elements.get(2)
					.select("img").attr("src");
		};



		/**获取商品名称的方法*/
		Function<Element, String> FgoodName = (e) ->{
			Elements el = e.select("tr");
			el.removeIf(element -> (!element.text().contains("名称")));
			return el.select("a").get(0).text();
		};

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element, String> FgoodUrl = (e) -> {
			Elements el = e.getElementsByAttributeValue("align","center").select("tr");
			el.removeIf(element -> (!element.html().contains("名称")) || (element.select("tr").size()!=1));
			return "http://www.bjyykd.com/" + el.select("a").get(0).attr("href");
		};

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}



	public static Elements getel(Elements el,String temp){
		Elements el1 = new Elements();
		try {

			el.removeIf((ell) ->
					ell.getElementsByAttributeValue(temp.split("\\.")[0], temp.split("\\.")[1].trim())
							.size() ==0);
			el.forEach((ell)->
					el1.addAll(ell.getElementsByAttributeValue(temp.split("\\.")[0], temp.split("\\.")[1].trim())
					));

		} catch (Exception e1) {
			System.out.println("少写了.");
			e1.printStackTrace();
		}
		return el1;

	}


	public static Elements getElements(String strs[] ,Element e){
		Elements els = new Elements();
		String temp = strs[0];
		if(temp.contains(" ")){
			try {
				String [] kv = temp.split("\\.");
				els = e.getElementsByAttributeValue(kv [0], kv [1]);
			} catch (Exception e1) {
				System.out.println("少写了.");
				e1.printStackTrace();
			}
		}else{
			els = e.select(temp.trim());
			System.out.println(temp.trim());
		}
		return els;
	}


}
