package aaaa.work;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.UUID;

import static aaaa.template.Template_P.getGoodsHtml;
import static aaaa.template.Template_P.insert;

/**
 * 爱康恒泰（北京）科技发展有限公司
 */

public class Work_ican120999_2945 {

	public static void main(String[] args) {
		try {
			//网页信息
			String goodsHtml =null;
			//图片url
			String imgUrl  =null;
			//商品名称
			String goodName =null;
			//商品id
			String goodId =null;
			//商品url
			String goodUrl =null;
			int i = 1;
			String searchurl = "http://www.ican120999.com/showcontent2.asp?id=806";
			System.out.println(i);
			String html = getGoodsHtml(searchurl);
			Document doc = Jsoup.parse(html);
			imgUrl=  "http://www.ican120999.com/" + doc.select("p img").attr("src");

			goodId = UUID.randomUUID().toString().replaceAll("-", "");
			HashMap<Object,Object> map = new HashMap<>();
			map.put("goodId", goodId);
			map.put("goodName", goodName);
			map.put("goodUrl", goodUrl);
			map.put("imgUrl", imgUrl);
			map.put("goodsHtml", goodsHtml);
			map.put("ptname", "爱康恒泰（北京）科技发展有限公司");
			System.out.println(map);
			String insert = insert(map);
			System.out.println(insert);



		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
