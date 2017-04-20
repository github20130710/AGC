package cn.sw.generate.service;

import cn.sw.generate.bean.Metadata;
import cn.sw.generate.bean.Model;
import cn.sw.generate.bean.Operation;
import cn.sw.util.FileUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by sophia.wang on 17/4/17.
 */
@Service("generateService")
public class VelocityService {

//    private @Value("#{settings['generator.template.path']}") String templatePath;
//    private @Value("#{settings['generator.output.path']}") String outputPathPrefix;
    private static String templatePath = "template";
    private static String outputPathPrefix = "/Users/sophia.wang/workspace_idea/AutoGenerate/output/";
    private static String dataPath = "/Users/sophia.wang/workspace_idea/AutoGenerate/src/resources/json/";

    public void generateAll() throws Exception {

    }

    public static void generate(String name) throws Exception {
        List<Metadata> array = getDataStructFromJson(dataPath, name);

        List<Operation> operations = new ArrayList<Operation>();   // 弹出框数组(创建删除以外)
        Operation op1 = new Operation("disable", "禁用");
        Operation op2 = new Operation("mountToVM", "挂载", "true");
        operations.add(op1);
        operations.add(op2);

        Model model = new Model(name);
        model.setRoutePath("resources." + name);
        model.setRouteDisplayName("虚拟磁盘");
        model.setAuthor("sophia.wang");
        model.setCreateDate(new Date());
        model.setList(array);
        model.setOperations(operations);

        VelocityContext context=new VelocityContext();  // 创建数据模型
        context.put("entityNameUpperCase", model.getEntityNameUpperCase());
        context.put("entityNameLowerCase", model.getEntityNameLowerCase());
        context.put("routePath", model.getRoutePath());
        context.put("routeDisplayName", model.getRouteDisplayName());
        context.put("author", model.getAuthor());
        context.put("createDate", model.getCreateDate());
        context.put("fields", model.getList());
        context.put("operations", model.getOperations());

        /* 生成Request */
        FileUtil.merge("list.vm", templatePath, context, name + ".html", outputPathPrefix + name + "/");
        FileUtil.merge("js.vm", templatePath, context, name + ".js", outputPathPrefix + name + "/");
        FileUtil.merge("detail.vm", templatePath, context, name + "_detail.html", outputPathPrefix + name + "/");
        FileUtil.merge("createModal.vm", templatePath, context, name + "_create.html", outputPathPrefix + name + "/");
        FileUtil.merge("other.vm", templatePath, context, name + "_other.js", outputPathPrefix + name + "/");
    }

    /**
     * 通过json文件获取数据结构
     * @param filePath
     * @param name 模块的名字
     */
    public static List<Metadata> getDataStructFromJson(String filePath, String name) throws FileNotFoundException {
        // 读取json文件中的字段（key）对应值（value）并存储
        String JsonContext = FileUtil.ReadFile(filePath + name + ".json");
        JSONArray jsonArray = JSONArray.fromObject(JsonContext);

        List<Metadata> fieldList = new ArrayList<Metadata>();
        Iterator<Object> iterator = jsonArray.iterator();
        while(iterator.hasNext()){
            JSONObject object = (JSONObject)iterator.next();
            Metadata metadata = (Metadata) JSONObject.toBean(object, Metadata.class);
            fieldList.add(metadata);
        }
        return fieldList;
    }

    public static void main(String[] args) {
        try {
            generate("volume");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
