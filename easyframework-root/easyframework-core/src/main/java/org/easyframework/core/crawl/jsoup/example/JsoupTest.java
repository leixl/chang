/**   
* @Title: JsoupTest.java 
* @Package org.easyframework.core.crawl.jsoup.example 
* @Description: TODO(描述) 
* @author leixl   
* @date 2014年4月22日 下午1:49:23  
*/ 


package org.easyframework.core.crawl.jsoup.example;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/** 
 * @ClassName: JsoupTest 
 * @Description: TODO(描述) 
 * @author leixl 
 * @date 2014年4月22日 下午1:49:23 
 *  
 */

public class JsoupTest {

	public static void main(String[] args){
		Document doc;
		try {
			doc = Jsoup.connect("http://item.taobao.com/item.htm?spm=a1z10.1.w5003-5248687655.2.Jda0US&id=37543958237&scene=taobao_shop").get();
			Elements newsHeadlines = doc.select("#detail");
			System.out.println(newsHeadlines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
