import dao.DogDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.Dog;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author lenovo
 * @create 2020-10-01-9:33
 */
public class Test01 {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private DogDao dd;

    @Before
    public void before() throws IOException {
      //1.加载配置文件
        is= Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory工厂
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.生产sqlSession数据库会话对象  true 自动提交
         sqlSession = sqlSessionFactory.openSession(true);
        //4.获取映射接口
         dd = sqlSession.getMapper(DogDao.class);
    }
    @Test
    public void testSelectAll(){
        List<Dog> dogs = dd.selectAll();
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
    @Test
    public void testSelectById(){
        Dog dog = dd.selectById(3);
        System.out.println(dog);
    }
    @Test
    public void testInsert(){
       Dog dog=new Dog();
       dog.setName("阿黄");
       dog.setLove(13);
       dog.setType("雪橇犬");
        int insert = dd.insert(dog);
        System.out.println(insert);
    }
    @Test
    public void testUpdate(){
        Dog dog=new Dog();
        dog.setId(3);
        dog.setName("阿黑");
        dog.setLove(33);
        dog.setType("柯基");
        int insert = dd.update(dog);
        System.out.println(insert);
    }
    @Test
    public void testDelete(){
        int delete = dd.delete(224);
        System.out.println(delete);
    }
    @After
    public void after(){

    }
}
