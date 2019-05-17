package util;

import java.util.HashMap;
import java.util.Map;

/**
 * url工具类
 *
 * @date 2019-05-18 00:24
 */
public class UrlUtil {

    /**
     * 通过url解析出参数
     *
     * @param url
     * @return
     */
    public static Map<String, String> parseParametersFromUrl(String url) {
        String[] params = url.substring(url.indexOf("?") + 1).split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params) {
            String[] kv = param.split("=");
            map.put(kv[0], kv[1]);
        }
        return map;
    }

}
