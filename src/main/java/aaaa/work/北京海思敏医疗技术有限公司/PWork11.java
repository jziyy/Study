package aaaa.work.北京海思敏医疗技术有限公司;

import aaaa.template.Template_p2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


/**
 * 北京海思敏医疗技术有限公司
 */

public class PWork11 {


	public static void main(String[] args) {

		List<String> list =new ArrayList<>();
		list.add("http://cloud.healthme.com.cn:8001/main/medical_care.html");
		list.add("http://cloud.healthme.com.cn:8001/main/house_electrical.html");
		List<String> list1 =new ArrayList<>();
		list1.add("医疗心电贴片");
		list1.add("家用心电贴片");
		//为1时进行插入
		int state = 1;
		for (int i = 0; i < list.size(); i++) {


			try {
				mainFuction(
						2, //1插入，2不插入
						"北京海思敏医疗技术有限公司",//公司名称
						list.get(i),//网站网址
						1,//页数
						"body",//标签的element集合
						"",//图片地址包含完整时为“”，不完整填 域名
						"",//获取图片标签
						list1.get(i),//获取商品名称
						list.get(i) ,//产品url完整时为“”，不完整填 域名
						""//产品标签
				);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void mainFuction(int state,String company,String searchURL,
								   int pageIndex,String place,
								   String imgurl,String imgplace,
								   String goodname,String goodurl,String goodplace) {
		String placeholder = "@@@";

		/**产品地址*/
		Function<Integer,String> Fsearchurl = (i) -> {
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
			Elements el=null;
			String [] strs = place.split(placeholder);
			for (int j = 0; j < strs.length; j++) {
				String temp = strs[j];

				if(j==0){
					if(temp.contains(" ")){
						try {
							String one=temp.split("\\.")[0];
							String two=temp.split("\\.")[1].trim();
							el=e.getElementsByAttributeValue(temp.split("\\.")[0], temp.split("\\.")[1].trim());

						} catch (Exception e1) {
							System.out.println("少写了.");
							e1.printStackTrace();
						}
					}else{
						el =e.select(temp);
					}
				}


				if(temp.contains(" ")){
					try {
						el=getel(el, temp);
					} catch (Exception e1) {
						System.out.println("少写了.");
						e1.printStackTrace();
					}
				}else{
					el = el.select(temp);
				}
			}
			return el;
		};


		/**获取单个产品标签的图片url方法*/
		Function<Element, String> FimgUrl = (e) -> {
			return "";
		};



		/**获取商品名称的方法*/
		Function<Element, String> FgoodName = (e) ->{
			return goodname;
		};

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element, String> FgoodUrl = (e) -> {
			if (goodplace.equals("")){
				return goodurl;
			}
			Elements el=new Elements();

			String [] strs = goodplace.split(placeholder);
			for (int j = 0; j < strs.length -1; j++) {
				if(j==0){
					el=getElements(strs,e);
					continue;
				}
				String temp = strs[j];
				if(temp.contains(" ")){
					try {
						el=getel(el, temp);
					} catch (Exception e1) {
						System.out.println("少写了.");
						e1.printStackTrace();
					}
				}else{
					el = el.select(temp);
				}
			}
			String good = el.get(0).attr(strs [strs.length-1]);
			return goodurl + good;
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
