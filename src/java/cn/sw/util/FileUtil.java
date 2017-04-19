package cn.sw.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.velocity.VelocityContext;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by sophia.wang on 17/4/17.
 */
public class FileUtil {

    /**
     * 输出文件
     * @param templateName 要输出文件的模板名称
     * @param templatePath  输出文件的模板路径
     * @param context  要输出的文件的动态数据(替换模板中的通用字段)
     * @param outFileName   输出文件路径名称
     * @param outFilePath  输出文件路径的相对路径
     * @throws Exception
     */
    public static void merge(String templateName, String templatePath, VelocityContext context, String outFileName, String outFilePath) throws Exception {
        try {
            File file = new File(outFilePath, outFileName);
            if (!file.getParentFile().exists()) { // 判断有没有父路径，就是判断文件整个路径是否存在
                file.getParentFile().mkdirs(); // 不存在就全部创建
            }
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            Template template = getTemplate(templateName, templatePath);
            template.process(context, out); // 模版输出
            out.flush();
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过文件名加载模版
     * @param fileName
     */
    public static Template getTemplate(String fileName, String filePath) throws Exception {
        try {
            Configuration cfg = new Configuration(); // 通过Freemarker的Configuration读取相应的fileName
            cfg.setEncoding(Locale.CHINA, "utf-8");
            cfg.setDirectoryForTemplateLoading(new File(PathUtil.getClasspath() + filePath)); // 设定去哪里读取相应的file模板文件
            Template temp = cfg.getTemplate(fileName); // 在模板文件目录中找到名称为name的文件
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取文件
     * @param Path
     * @return
     */
    public static String ReadFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
}
