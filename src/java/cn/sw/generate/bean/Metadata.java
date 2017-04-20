package cn.sw.generate.bean;

/**
 * Created by sophia.wang on 17/4/18.
 */
public class Metadata {
    private String name;    //字段名称
    private String type;    //字段类型
    private String value;   //字段值
    private String desc;    //字段描述
    private String table;  //是否显示在table列表中
    private String query;  //是否显示在query列表中

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}