package aaaa.work;

import aaaa.template.Template_one;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 北京健乃喜生物技术有限公司
 */

public class Work_geneseebiotech2951 {

	public static void main(String[] args) {
		/**url处理方法*/
		String Fsearchurl = "http://www.geneseebiotech.cn/2022/index.php?m=content&c=index&a=lists&catid=54";

		/**网站名称*/
		String company = "北京健乃喜生物技术有限公司";

		/**获取所有标签*/
		Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("class","cpul").select("li a");

		/**获取图片url*/
		Function<Element,String> FimgUrl = (e) ->null;

		/**获取商品名称*/
		Function<Element,String> FgoodName  = (e) -> e.text();

		/**获取商品地址    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> e.attr("href");

		Template_one.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company);
	}


}
