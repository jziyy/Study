package aaaa.template;

import aaaa.util.JdbcUtil;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

/**
 *多页模板
 */
public class Template_P {


	public static void pcTemplate(Function<Integer,String> Fsearchurl, String docMainCss, String oneCss,
							Function<Element,String> FimgUrl,Function<Element,String> FgoodName,
							Function<Element,String> FgoodUrl,String company) {
		
		try {

			//商品详细信息
			String goodsHtml =null;
			//图片地址
			String imgUrl  =null;
			//商品名称
			String goodName =null;
			//商品id
			String goodId =null;
			//商品url
			String goodUrl =null;
			int i = 1;
			while (true) {
				//
				String searchurl = Fsearchurl.apply(i);//  "+i+"/
				System.out.println(i);
				String html = getGoodsHtml(searchurl);
				Document doc = Jsoup.parse(html);
				Elements elements = doc.select(docMainCss);
				if (StringUtils.isEmpty(elements.text().trim())){
					break;
				}

				Elements elements1 = elements.select(oneCss);
				for (Element e:elements1) {
					 imgUrl = FimgUrl.apply(e);
					 goodName = FgoodName.apply(e);
					 goodUrl =  FgoodUrl.apply(e);
					 goodsHtml = getGoodsHtml(goodUrl);
					 goodId = UUID.randomUUID().toString().replaceAll("-", "");
					 HashMap<Object,Object> map = new HashMap<>();
					 map.put("goodId", goodId);
					 map.put("goodName", goodName);
					 map.put("goodUrl", goodUrl);
					 map.put("imgUrl", imgUrl);
				 	 map.put("goodsHtml", goodsHtml);
					 map.put("ptname", company);
					 System.out.println(map);
 					// String insert = insert(map);
 					// System.out.println(insert);

				}
				i++;

			}
			
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	 
public static String getGoodsHtml(String searchurl ) {
		
		String html="";
		try {
			URL baseurl = new URL(searchurl);
			org.jsoup.Connection conn = HttpConnection.connect(baseurl);
			conn.timeout(100000);
			conn.header("Accept", "*/*");
			conn.header("Accept-Encoding", "gzip, deflate, br");
			conn.header("Accept-Language", "zh-CN,zh;q=0.9");
		//	conn.header("Connection", "keep-alive");
		//	conn.header("Cookie","uid=CjozJlwh+ipPAUu7A53jAg==; __clickidc=72987942545730603; __c_visitor=72987942545730603; __gmv=1852423072121.1545730603271; cartnum=0_0-1_0; _smt_uid=5c21fa2f.5be24071; compare=; isnew=470994452170.1545730609432; asid=3f60b567306a332738bda357c12c39ca; proid120517atg=%5B%229140023487-1130020153%22%2C%229133898879-1122910627%22%5D; _jzqco=%7C%7C%7C%7C%7C1.1604067315.1545733313353.1545744387049.1545744783171.1545744387049.1545744783171.0.0.0.16.16; __xsptplus194=194.5.1545790604.1545790604.1%233%7Citem.gome.com.cn%7C%7C%7C%7C%23%23B-hNJh8UJCLA3CzQkN2xNrxPUX8DVJgg%23; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22167e4b939ba98e-018a508c12bae7-3f674706-1049088-167e4b939bc929%22%2C%22%24device_id%22%3A%22167e4b939ba98e-018a508c12bae7-3f674706-1049088-167e4b939bc929%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Fbaidu.php%22%2C%22%24latest_referrer_host%22%3A%22www.baidu.com%22%2C%22%24latest_search_keyword%22%3A%22%E5%9B%BD%E7%BE%8E%22%2C%22_latest_cmpid%22%3A%22sem_baidu_cpc_yx_pc1_%E5%93%81%E7%89%8C%E8%AF%8D-%E5%9B%BD%E7%BE%8E-%E5%85%A8%E5%9B%BD_%E5%9B%BD%E7%BE%8E-%E6%A0%B8%E5%BF%83_%E5%9B%BD%E7%BE%8E%22%7D%7D; atgregion=11010200%7C%E5%8C%97%E4%BA%AC%E5%8C%97%E4%BA%AC%E5%B8%82%E6%9C%9D%E9%98%B3%E5%8C%BA%E6%9C%9D%E5%A4%96%E8%A1%97%E9%81%93%7C11010000%7C11000000%7C110102002; __gma=ffb8de7.1852423072121.1545730603271.1545811198991.1545987605874.9; _idusin=78407799115; __gmc=ffb8de7; s_cc=true; s_ev13=%5B%5B'sem_baidu_cpc_yx_pc1_%25u54C1%25u724C%25u8BCD-%25u56FD%25u7F8E-%25u5168%25u56FD_%25u56FD%25u7F8E-%25u6838%25u5FC3_%25u56FD%25u7F8E'%2C'1545987608440'%5D%5D; route=a4740778113c5452684f57d9d18e1433; gradeId=-1; DSESSIONID=7d5579f8444f4f33bea7bf914f03d775; gpv_pn=no%20value; gpv_p22=no%20value; s_sq=gome-prd%3D%2526pid%253Dhttps%25253A%25252F%25252Fsearch.gome.com.cn%25252Fsearch%25253Fquestion%25253D%252525E5%25252586%252525B0%252525E7%252525AE%252525B1%252526searchType%25253Dgoods%252526search_mode%25253Dnormal%2526oid%253Dfunctiononclick(event)%25257BdoSearch()%25253B%25257D%2526oidt%253D2%2526ot%253DBUTTON; __gmz=ffb8de7|sem_baidu_cpc_yx_pc1_%E5%93%81%E7%89%8C%E8%AF%8D%2D%E5%9B%BD%E7%BE%8E%2D%E5%85%A8%E5%9B%BD_%E5%9B%BD%E7%BE%8E%2D%E6%A0%B8%E5%BF%83_%E5%9B%BD%E7%BE%8E|-|sem|-|1hH3KKjEAGkF|-|1852423072121.1545730603271|dc-1|1545987605874; __gmb=ffb8de7.11.1852423072121|9.1545987605874; __xsptplus194=194.6.1546048493.1546048493.1%233%7Citem.gome.com.cn%7C%7C%7C%7C%23%23B-hNJh8UJCLA3CzQkN2xNrxPUX8DVJgg%23; plasttime=1546049652; s_ppv=-; s_getNewRepeat=1546049652464-Repeat; _index_ad=0");
			conn.header("Referer", searchurl);
			conn.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
			conn.ignoreContentType(true);
			conn.execute();
			 Thread.sleep(1000);
			 html = conn.get().html();
			if(html.contains("û���ҵ���")&&html.contains("��ص���Ʒ")){
				html="false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return html;
		}
		
    	
    	
    }



public static String insert(Map map) {
	String flag = "";
	String updatesql = "insert into BJ_YLQX_GOODS " +
		    "(GOOD_ID,GOOD_NAME,GOOD_URL,IMG_URL,PT_NAME,INSERTDATE,GOOD_HTML)" +
		    " values" +
		    "(?,?,?,?,?,sysdate,?)";
	PreparedStatement ps = null;
	java.sql.Connection conOrcale = null;
	try {
		conOrcale = JdbcUtil.getConnection();
		ps = conOrcale.prepareStatement(updatesql);
		ps.setString(1, map.get("goodId") == null ? null : map.get(
				"goodId").toString());//SHOP_ID
		ps.setString(2, map.get("goodName") == null ? null : map.get(
				"goodName").toString());//SHOP_NAME
		ps.setString(3, map.get("goodUrl") == null ? null : map.get(
				"goodUrl").toString());//ENT_NAME
		ps.setString(4, map.get("imgUrl") == null ? null : map.get(
				"imgUrl").toString());//ZC_NUM
		ps.setString(5, map.get("ptname") == null ? null : map.get(
				"ptname").toString());//FD_PERSON
		ps.setString(6, map.get("goodsHtml") == null ? null : map.get(
				"goodsHtml").toString());//FD_PERSON
		
		System.err.println(ps.executeUpdate());
		flag = "����ɹ�";
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		flag = "����ʧ��";
	} finally {
		// �ر����ݿ�
		try {
			conOrcale.close();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return flag;
}
	

}
