package cn.sw.generate.bean;

import cn.sw.util.StringUtil;

/**
 * Created by sophia.wang on 17/4/20.
 */
public class Operation {
    private String name;
    private String nameUpper;
    private String displayName;
    private String modal = "false";   //是否是弹窗框

    public Operation() {
    }

    public Operation(String name, String displayName) {
        this.name = name;
        this.nameUpper = StringUtil.toCamelCasing(this.name);
        this.displayName = displayName;
    }

    public Operation(String name, String displayName, String modal) {
        this.name = name;
        this.nameUpper = StringUtil.toCamelCasing(this.name);
        this.displayName = displayName;
        this.modal = modal;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUpper() {
        return nameUpper;
    }

    public void setNameUpper(String nameUpper) {
        this.nameUpper = nameUpper;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }
}
