package aaaa.work;

import org.jsoup.nodes.Element;

import java.util.function.Function;

import static aaaa.template.Template_P.pcTemplate;

/**
 * 北京杰西慧中科技有限公司
 */

public class Work_jxhzmed2928 {

	public static void main(String[] args) {
		Function<Integer,String> Fsearchurl = (i) -> "http://www.jxhzmed.com/category-3-3-0-" + i + ".shtml";
		String docMainCss = "div.f_w_xm";
		String oneCss = "dl";
		String company = "北京杰西慧中科技有限公司";
		Function<Element,String> FimgUrl = (e) ->"http://www.jxhzmed.com" + e.select("dt img").attr("src");
		Function<Element,String> FgoodName  = (e) -> e.select("dd.f_w_wit").text();;
		Function<Element,String> FgoodUrl  = (e) -> "http://www.jxhzmed.com" + e.select("a.f_w_lx").attr("href");
		pcTemplate(Fsearchurl,docMainCss,oneCss,FimgUrl,FgoodName,FgoodUrl,company);

	}


}
