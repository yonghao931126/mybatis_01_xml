package com.heojie.test;


import com.haojie.dao.IUserDao;
import com.haojie.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {

        //读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlmapconfig.xml");
        //创建sqlsessionfactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生成sqlsession对象
        SqlSession session = factory.openSession();
        //使用session创建到接口对象
        IUserDao mapper = session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();

    }
}
