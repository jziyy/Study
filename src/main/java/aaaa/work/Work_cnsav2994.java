package aaaa.work;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 宠物医师网1

 */

public class Work_cnsav2994 {

	public static void main(String[] args) {
		//为1时进行插入
		int state = 1;


		/**url处理方法*/
		Function<Integer,String> Fsearchurl = (i) -> {
			if (i==1){
				return "http://cnsav.com/html/pingpai/doctor_jq/index.html";
			}else {
				return "http://cnsav.com/html/pingpai/doctor_jq/"+ i +".html";
			}
		};

		/**网站名称*/
		String company = "宠物医师网";

		/**获取所有标签*/
		Function<Document, Elements> FMain = (e) -> e.getElementsByAttributeValue("class","listart");

		/**获取图片url*/
		Function<Element,String> FimgUrl = (e) ->{
			String img;
			for (int i = 0; i < e.select("img").size(); i++) {
				if (e.select("img").get(i).attr("src").contains("uploadfile")){
					return e.select("img").get(i).attr("src");
				}
			}
			return null;

		};


		/**获取商品名称*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("target","_blank")
				.select("span").text();

		/**获取商品地址    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://cnsav.com/" + e.getElementsByAttributeValue("target","_blank").get(1)
				.attr("href");

		Template_p2.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company,state);
	}


}
