package mrsj.news.tools;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Jsoup 工具类
 * Created by Silence on 2017/1/25.
 */
@Log4j2
public class JsoupUtils {
    private static final String UA_PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";
    private static final int TIME_OUT = 10 * 1000;

    public static Document getDocWithPC(String url) {
        try {
            return Jsoup.connect(url).userAgent(UA_PC).timeout(TIME_OUT).ignoreContentType(true).get();
        } catch (IOException e) {
            log.error("网址请求失败：" + url);
        }
        return null;
    }
    public static JSONObject getJSON(String url) {
        try {
            Connection.Response res = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(TIME_OUT).ignoreContentType(true).execute();//.get();
            String body = res.body();
            JSONObject json = JSONObject.parseObject(body);
            return json;
        } catch (IOException e) {
            log.error("网址请求失败：" + url);
        }
        return null;
    }

}
