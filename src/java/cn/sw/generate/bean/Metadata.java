package cn.sw.generate.bean;

/**
 * Created by sophia.wang on 17/4/18.
 */
public class Metadata {
    private String name;    //字段名称
    private String type;    //字段类型
    private String value;   //字段值
    private String desc;    //字段描述

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
}
