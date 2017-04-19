package cn.sw.util;

import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by sophia.wang on 17/4/18.
 */
public class StringUtil {

    /**
     * 将字符串按照驼峰命名进行转换
     * @param str
     * @return
     */
    public static String toCamelCasing(String str) {
        if(str=="" && str==null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        String firstLetter = str.substring(0, 1);
        String others = str.substring(1);
        String upperLetter = null;
        if(str.length() > 0){
            upperLetter = firstLetter.toUpperCase();
        } else {
            upperLetter = firstLetter;
        }
        buffer.append(upperLetter).append(others);
        return buffer.toString();
    }
}
