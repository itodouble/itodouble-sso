package top.itodouble.sso.entity.sso.add;

import top.itodouble.sso.entity.sso.SsoRole;

import java.io.Serializable;

public class SsoRoleAdd extends SsoRole implements Serializable {
    private String systemName;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
