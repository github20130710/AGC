package cn.sw.generate.bean;

import cn.sw.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sophia.wang on 17/4/18.
 */
public class Model {
    private String entityNameLowerCase; //实体类的小写
    private String entityNameUpperCase; //实体类的驼峰命名
    private String routePath;   //模块访问路径(app之后的, 例如app.dashboard,这里会写成dashboard)
    private String routeDisplayName;   //模块显示名称
    private List<Metadata> list = new ArrayList<Metadata>();  //模块数据结构
    private List<Operation> operations = new ArrayList<Operation>();   // 弹出框数组(创建删除以外)
    private String author;      //作者
    private Date createDate;    //文件创建时间

    public Model(String name) {
        this.setEntityNameLowerCase(name.toLowerCase());
        this.setEntityNameUpperCase(StringUtil.toCamelCasing(name));
    }

    public String getEntityNameLowerCase() {
        return entityNameLowerCase;
    }

    private void setEntityNameLowerCase(String entityNameLowerCase) {
        this.entityNameLowerCase = entityNameLowerCase;
    }

    public String getEntityNameUpperCase() {
        return entityNameUpperCase;
    }

    private void setEntityNameUpperCase(String entityNameUpperCase) {
        this.entityNameUpperCase = entityNameUpperCase;
    }

    public String getRoutePath() {
        return routePath;
    }

    public void setRoutePath(String routePath) {
        this.routePath = routePath;
    }

    public String getRouteDisplayName() {
        return routeDisplayName;
    }

    public void setRouteDisplayName(String routeDisplayName) {
        this.routeDisplayName = routeDisplayName;
    }

    public List<Metadata> getList() {
        return list;
    }

    public void setList(List<Metadata> list) {
        this.list = list;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

}
