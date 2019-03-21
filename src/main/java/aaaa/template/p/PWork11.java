package aaaa.template.p;

import aaaa.template.Template_P;
import aaaa.template.Template_p2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京英诺特生物技术有限公司
 */

public class PWork11 {


	public static void main(String[] args) {

		String html = Template_P.getGoodsHtml("http://www.innovita.com.cn/index.php?m=content&c=index&a=show&catid=45&id=6");
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("div.er_l_li ul li a");

		//为1时进行插入
		int state = 2;
		for (int i = 0; i < elements.size(); i++) {


			try {
				mainFuction(
						2, //1插入，2不插入
						"北京英诺特生物技术有限公司",//公司名称
						elements.get(i).attr("href"),//网站网址
						1,//页数
						"body",//标签的element集合
						"",//图片地址包含完整时为“”，不完整填 域名
						"div.er_gy_title@@img@@@src",//获取图片标签
						"class. on@@@a@@@text",//获取商品名称
						elements.get(i).attr("href"),//产品url完整时为“”，不完整填 域名
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
			Elements el=new Elements();

			String [] strs = imgplace.split(placeholder);
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

					el = el.select(temp.trim());
					System.out.println(temp.trim());
				}
			}

			String img = el.get(0).attr(strs [strs.length-1]);
			return imgurl + img;
		};



		/**获取商品名称的方法*/
		Function<Element, String> FgoodName = (e) ->{
			Elements el=new Elements();

			String [] strs = goodname.split(placeholder);
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
			String name ="";
			if(strs [strs.length-1].trim().equals("text")){
				name = el.get(0).text();
			}else{
				name=el.get(0).attr(strs [strs.length-1]);
			}
			return name;
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
