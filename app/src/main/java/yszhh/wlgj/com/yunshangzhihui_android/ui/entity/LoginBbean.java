package yszhh.wlgj.com.yunshangzhihui_android.ui.entity;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class LoginBbean {
    private boolean isNewRecord;//	true
    private String loginFlag;//	"1"
    private String roleNames;//	""
    private boolean admin;//	false

    public boolean isNewRecord() {
        return isNewRecord;
    }

    public void setNewRecord(boolean newRecord) {
        isNewRecord = newRecord;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
