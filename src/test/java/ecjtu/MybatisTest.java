package ecjtu;

import com.entity.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    SqlSessionFactory factory;
    @Before
    public void init(){
        String res="config.xml";
        InputStream in=null;
        try {
            in= Resources.getResourceAsStream(res);
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void fingById(){
        SqlSession sqlSession=null;
        try{
             sqlSession=factory.openSession();
            User user=sqlSession.selectOne("findById",1);
            System.out.println(user);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void getAll(){
        SqlSession sqlSession=null;
        try{
            sqlSession=factory.openSession();
            List<User> list=sqlSession.selectList("findAll");
            System.out.println(list);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void insertUser(){
        SqlSession sqlSession=null;
        sqlSession=factory.openSession();
        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        int x=sqlSession.insert("saveUser",user);
        System.out.println(x);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(user.getId());
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession=null;
        sqlSession=factory.openSession();
        int x=sqlSession.delete("deleteUser",8);
        System.out.println(x);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession=null;
        sqlSession=factory.openSession();
        User user=new User(8,"cjm","123");
        int x=sqlSession.update("updateUser",user);
        System.out.println(x);
        sqlSession.commit();
        sqlSession.close();
    }
}
