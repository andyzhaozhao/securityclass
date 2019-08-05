//package cn.com.taiji.security.securityday2.extend;
//
//import cn.com.taiji.security.securityday2.domain.UserDomain;
//import cn.com.taiji.security.securityday2.repository.UserDomainRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//
//@Service
//public class DataInit {
//    @Autowired
//    private UserDomainRepository userInfoRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    public void dataInit() {
//        UserDomain admin = new UserDomain();
//        admin.setUsername("admin");
//        admin.setPassword(passwordEncoder.encode("1"));
//        admin.setRoles(UserDomain.Role.ROLE_ADMIN);
//        userInfoRepository.save(admin);
//
//        UserDomain user = new UserDomain();
//        user.setUsername("user");
//        user.setPassword(passwordEncoder.encode("1"));
//        user.setRoles(UserDomain.Role.ROLE_USER);
//        userInfoRepository.save(user);
//    }
//}
