import dao.DogDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import po.Dog;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lenovo
 * @create 2020-10-01-9:02
 */
public class test {
    @org.junit.Test
    public void test() throws IOException {
        //1.加载配置文件
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.生产sqlSession数据库会话对象  true 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //4.获取映射接口
        DogDao dd = sqlSession.getMapper(DogDao.class);
       /* List<Dog> dogs = dd.selectAll();
        for (Dog dog : dogs) {
            System.out.println(dog);
        }*/
        Dog dog = dd.selectById(3);
        System.out.println(dog);
    }
}
