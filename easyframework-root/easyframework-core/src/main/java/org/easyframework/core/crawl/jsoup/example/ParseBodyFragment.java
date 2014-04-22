/**   
* @Title: ParseBodyFragment.java 
* @Package org.easyframework.core.crawl.jsoup.example 
* @Description: TODO(描述) 
* @author leixl   
* @date 2014年4月22日 下午2:09:26  
*/ 


package org.easyframework.core.crawl.jsoup.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/** 
 * @ClassName: ParseBodyFragment 
 * @Description: TODO(描述) 
 * @author leixl 
 * @date 2014年4月22日 下午2:09:26 
 *  
 */

public class ParseBodyFragment {

	public static void main(String[] args){
		String html = "<div><p>Lorem ipsum.</p>";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body();
		System.out.println(body);
	}
}
