package cn.com.taiji.security.securityday3.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue
    private long uid;

    private String username;//用户名.
    private String password;//密码.

    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "UserRole",
            joinColumns = {@JoinColumn(name = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "rid")})
    private List<Role> roles;

//    @Enumerated(EnumType.STRING)
//    private Role roles;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
