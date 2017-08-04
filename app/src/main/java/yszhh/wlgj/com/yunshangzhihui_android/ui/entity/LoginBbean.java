package yszhh.wlgj.com.yunshangzhihui_android.ui.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class LoginBbean {

    /**
     * isLogin : true
     * message : 登录成功
     * user : {"id":"1","isNewRecord":false,"remarks":"最高管理员","createDate":"2013-05-27 08:00:00","updateDate":"2017-05-19 15:47:14","area":"咸阳市","loginName":"thinkgem","no":"0001","name":"系统管理员","email":"thinkgem@163.com","phone":"18291967866","mobile":"8675","userType":"","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2017-07-14 16:02:55","loginFlag":"1","photo":"/platform/userfiles/1/images/photo/2017/03/Tulips.jpg","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2017-07-14 16:02:55","management":"2","roleList":[{"id":"1","isNewRecord":false,"remarks":"","name":"系统管理员","enname":"dept","roleType":"assignment","dataScope":"1","sysData":"1","useable":"1","menuIds":"","officeIds":""},{"id":"c6870254c8bb48c58aacd98372449573","isNewRecord":false,"remarks":"","name":"评论角色","enname":"pl","roleType":"assignment","dataScope":"8","sysData":"1","useable":"1","menuIds":"","officeIds":""}],"roleNames":"系统管理员,评论角色","roleIdList":["1","c6870254c8bb48c58aacd98372449573"],"admin":true}
     */

    private boolean isLogin;
    private String message;
    private String cookies2;

    public String getCookies2() {
        return cookies2;
    }

    public void setCookies2(String cookies2) {
        this.cookies2 = cookies2;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    private String cookies;
    private UserEntity user;

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public String getMessage() {
        return message;
    }

    public UserEntity getUser() {
        return user;
    }

    public static class UserEntity {
        /**
         * id : 1
         * isNewRecord : false
         * remarks : 最高管理员
         * createDate : 2013-05-27 08:00:00
         * updateDate : 2017-05-19 15:47:14
         * area : 咸阳市
         * loginName : thinkgem
         * no : 0001
         * name : 系统管理员
         * email : thinkgem@163.com
         * phone : 18291967866
         * mobile : 8675
         * userType :
         * loginIp : 0:0:0:0:0:0:0:1
         * loginDate : 2017-07-14 16:02:55
         * loginFlag : 1
         * photo : /platform/userfiles/1/images/photo/2017/03/Tulips.jpg
         * oldLoginIp : 0:0:0:0:0:0:0:1
         * oldLoginDate : 2017-07-14 16:02:55
         * management : 2
         * roleList : [{"id":"1","isNewRecord":false,"remarks":"","name":"系统管理员","enname":"dept","roleType":"assignment","dataScope":"1","sysData":"1","useable":"1","menuIds":"","officeIds":""},{"id":"c6870254c8bb48c58aacd98372449573","isNewRecord":false,"remarks":"","name":"评论角色","enname":"pl","roleType":"assignment","dataScope":"8","sysData":"1","useable":"1","menuIds":"","officeIds":""}]
         * roleNames : 系统管理员,评论角色
         * roleIdList : ["1","c6870254c8bb48c58aacd98372449573"]
         * admin : true
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private String area;
        private String loginName;
        private String no;
        private String name;
        private String email;
        private String phone;
        private String mobile;
        private String userType;
        private String loginIp;
        private String loginDate;
        private String loginFlag;
        private String photo;
        private String oldLoginIp;
        private String oldLoginDate;
        private String management;
        private String roleNames;
        private boolean admin;
        private List<RoleListEntity> roleList;
        private List<String> roleIdList;

        public void setId(String id) {
            this.id = id;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public void setOldLoginIp(String oldLoginIp) {
            this.oldLoginIp = oldLoginIp;
        }

        public void setOldLoginDate(String oldLoginDate) {
            this.oldLoginDate = oldLoginDate;
        }

        public void setManagement(String management) {
            this.management = management;
        }

        public void setRoleNames(String roleNames) {
            this.roleNames = roleNames;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public void setRoleList(List<RoleListEntity> roleList) {
            this.roleList = roleList;
        }

        public void setRoleIdList(List<String> roleIdList) {
            this.roleIdList = roleIdList;
        }

        public String getId() {
            return id;
        }

        public boolean getIsNewRecord() {
            return isNewRecord;
        }

        public String getRemarks() {
            return remarks;
        }

        public String getCreateDate() {
            return createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public String getArea() {
            return area;
        }

        public String getLoginName() {
            return loginName;
        }

        public String getNo() {
            return no;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getMobile() {
            return mobile;
        }

        public String getUserType() {
            return userType;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public String getPhoto() {
            return photo;
        }

        public String getOldLoginIp() {
            return oldLoginIp;
        }

        public String getOldLoginDate() {
            return oldLoginDate;
        }

        public String getManagement() {
            return management;
        }

        public String getRoleNames() {
            return roleNames;
        }

        public boolean getAdmin() {
            return admin;
        }

        public List<RoleListEntity> getRoleList() {
            return roleList;
        }

        public List<String> getRoleIdList() {
            return roleIdList;
        }

        public static class RoleListEntity {
            /**
             * id : 1
             * isNewRecord : false
             * remarks :
             * name : 系统管理员
             * enname : dept
             * roleType : assignment
             * dataScope : 1
             * sysData : 1
             * useable : 1
             * menuIds :
             * officeIds :
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String name;
            private String enname;
            private String roleType;
            private String dataScope;
            private String sysData;
            private String useable;
            private String menuIds;
            private String officeIds;

            public void setId(String id) {
                this.id = id;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public void setRoleType(String roleType) {
                this.roleType = roleType;
            }

            public void setDataScope(String dataScope) {
                this.dataScope = dataScope;
            }

            public void setSysData(String sysData) {
                this.sysData = sysData;
            }

            public void setUseable(String useable) {
                this.useable = useable;
            }

            public void setMenuIds(String menuIds) {
                this.menuIds = menuIds;
            }

            public void setOfficeIds(String officeIds) {
                this.officeIds = officeIds;
            }

            public String getId() {
                return id;
            }

            public boolean getIsNewRecord() {
                return isNewRecord;
            }

            public String getRemarks() {
                return remarks;
            }

            public String getName() {
                return name;
            }

            public String getEnname() {
                return enname;
            }

            public String getRoleType() {
                return roleType;
            }

            public String getDataScope() {
                return dataScope;
            }

            public String getSysData() {
                return sysData;
            }

            public String getUseable() {
                return useable;
            }

            public String getMenuIds() {
                return menuIds;
            }

            public String getOfficeIds() {
                return officeIds;
            }
        }
    }
}
