package ecjtu;

import com.dao.ClassesMapper;
import com.entity.Classes;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ClassesTest {
    private SqlSessionFactory factory;
    @Before
    public void init(){
        String file="config.xml";
        try {
            factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void fingById(){
        SqlSession sqlSession=factory.openSession();
        ClassesMapper classesMapper=sqlSession.getMapper(ClassesMapper.class);
        Classes classes=classesMapper.findById(1);
        System.out.println(classes);
    }
    @Test
    public void findAllStudent(){
        SqlSession sqlSession=factory.openSession();
        ClassesMapper classesMapper=sqlSession.getMapper(ClassesMapper.class);
        Classes classes=classesMapper.findAllStudent(1);
        System.out.println(classes);
    }
}
