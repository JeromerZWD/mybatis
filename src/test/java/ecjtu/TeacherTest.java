package ecjtu;

import com.dao.TeacherMapper;
import com.entity.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TeacherTest {
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
    public void findById(){
        SqlSession sqlSession=factory.openSession();
        TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.findById(1);
        System.out.println(teacher);
    }
    @Test
    public void findByAll(){
        SqlSession sqlSession=factory.openSession();
        TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.findAllStudent(1);
        System.out.println(teacher);
    }

}
