package aaaa.work;

import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.util.function.Function;

import static aaaa.template.Template_P.getGoodsHtml;


/**
 * 北京万东鼎立医疗设备有限公司
 */

public class Work_dlmedical3007 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 2;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> "http://www.dlmedical.com/index.php/product/index/p/"+ i +".shtml";

		/**公司名称*/
		String company = "北京万东鼎立医疗设备有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("class","news_box clear");

		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->"http://www.dlmedical.com/" + e.getElementsByAttributeValue("class","pic f_l")
				.select("a img").attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("class","cot f_r")
				.select("h1 a").text();

		/**获取商品的URL详细页方法    http://www.dlmedical.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.dlmedical.com/" +  e.getElementsByAttributeValue("class","cot f_r")
				.select("h1 a").attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}

}

