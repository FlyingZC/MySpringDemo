package com.baobaotao.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogonService {
    @Autowired(required = false)
    private LogDao logDao;

    // @Autowired默认按类型匹配的方式，在容器中查找匹配的Bean，当有且仅有一个匹配的Bean时，Spring将其注入到@Autowired标注的变量中。
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public LogDao getLogDao() {
        return logDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

//    @Autowired
//    public void setLogDao(LogDao logDao) {
//        this.logDao = logDao;
//    }
//
//    @Autowired
//    @Qualifier("userDao")
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Autowired
//    public void init(@Qualifier("userDao")UserDao userDao, LogDao logDao) {
//        System.out.println("multi param inject");
//        this.userDao = userDao;
//        this.logDao = logDao;
//    }
}
