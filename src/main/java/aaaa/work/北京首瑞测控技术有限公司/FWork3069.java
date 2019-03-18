package aaaa.work.北京首瑞测控技术有限公司;

import aaaa.template.Template_p2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;


/**
 * 北京首瑞测控技术有限公司
 */

public class FWork3069 {

	public static void main(String[] args) {
//为1时进行插入
		int state = 1;


		/**产品地址*/
		Function<Integer, String> Fsearchurl = (i) -> {
			if (i <= 2) {
				return  "http://www.62267318.cn/nav/10.html#c_product_list-15382293211525631-" + i;
			}
			else {
				System.exit(0);
				return "";
			}
		};
		/**公司名称*/
		String company = "北京首瑞测控技术有限公司";

		/**获取所有的产品标签方法*/
		Function<Document, Elements> FMain = (e) ->e.getElementsByAttributeValue("class","e_box e_ProductBox-001 p_Product");

		/**获取单个产品标签的图片url方法*/
		Function<Element, String> FimgUrl = (e) ->  {
			String  json =  e.getElementsByAttributeValue("class","e_box e_box-000 p_images")
				.attr("imgData");
			JSONObject jsonObject = JSON.parseObject(json);
			JSONArray jsonArray = jsonObject.getJSONArray("navs");
			JSONObject jsonObject1 = jsonArray.getJSONObject(0);
			return "http://www.62267318.cn/" + jsonObject1.getString("srcBigPic");


		};



		/**获取商品名称的方法*/
		Function<Element, String> FgoodName = (e) ->e.getElementsByAttributeValue("class","font js_singleLine")
				.text();

		/**获取商品的URL详细页方法    http://www.glory-way.com/*/
		Function<Element, String> FgoodUrl = (e) -> {
			Elements elements = e.getElementsByAttributeValue("class","e_box e_box-000 p_images");

			return  "http://www.62267318.cn" + elements.attr("data-url");
		};

		Template_p2.pcTemplate(Fsearchurl, FMain, FimgUrl, FgoodName, FgoodUrl, company, state);
	}

}
