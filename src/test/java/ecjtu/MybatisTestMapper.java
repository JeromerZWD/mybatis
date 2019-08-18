package ecjtu;

import com.dao.UserMapper;
import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MybatisTestMapper {
    private SqlSessionFactory factory;
    @Before
    public void init(){
        String resource="config.xml";
        try {
            factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void saveUser(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("qqq");
        user.setPassword("123");
        userMapper.saveUser(user);
        sqlSession.commit();
        System.out.println(user.getId());
        sqlSession.close();
    }
    @Test
    public void delete(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(118);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void update(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setId(10);
        user.setUsername("zwd");
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findById(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findById(9));
        sqlSession.close();
    }
    @Test
    public void findAll(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findAll());
        sqlSession.close();
    }
    @Test
    public void logincheck(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("zwd");
        List<User> list=userMapper.logincheck(user);
        System.out.println(list);
    }
    @Test
    public void testMapResult(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findUserByIdResultMap(8);
        System.out.println(user);
    }
    @Test
    public void findByIds(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> list=userMapper.findByIds2(Arrays.asList(1,2,3,4));
        System.out.println(list);
    }
    @Test
    public void addUsers(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User>users=new ArrayList<>();
        users.add(new User(11,"ddd","1222"));
        users.add(new User(12,"rrr","1244"));
        users.add(new User(13,"ee","3444"));
        int result=userMapper.addUsers(users);
        System.out.println(result);
    }
    @Test
    public void cache(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findById(1);
        System.out.println(user);
        sqlSession.close();
        SqlSession sqlSession2=factory.openSession();
        UserMapper userMapper2=sqlSession2.getMapper(UserMapper.class);
        User user1=userMapper2.findById(1);
        System.out.println(user1);
        sqlSession2.close();
    }
    @Test
    public void TestChoose(){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> list=userMapper.selectName("tly");
        System.out.println(list);

    }
}
