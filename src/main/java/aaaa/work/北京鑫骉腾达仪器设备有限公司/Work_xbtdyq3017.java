package aaaa.work.北京鑫骉腾达仪器设备有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京鑫骉腾达仪器设备有限公司
 */

public class Work_xbtdyq3017 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) ->"http://www.xbtdyq.com/Products-p"+ i +"/";

		/**公司名称*/
		String company = "北京鑫骉腾达仪器设备有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("id","ind_pro_img");

		/**获取单个产品标签的图片url方法*/
		Function<Element,String> FimgUrl = (e) ->e.getElementsByAttributeValue("class","proimg").select("img")
				.attr("src");


		/**获取商品名称的方法*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("class","proimg")
				.attr("title");

		/**获取商品的URL详细页方法     http://www.xbtdyq.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.xbtdyq.com" + e.getElementsByAttributeValue("class","proimg")
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
