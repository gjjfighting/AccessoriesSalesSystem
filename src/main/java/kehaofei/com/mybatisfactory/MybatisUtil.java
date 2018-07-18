package kehaofei.com.mybatisfactory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author XCCD
 *
 */
public class MybatisUtil {
	
	public static SqlSessionFactory sqlSessionFactory;
	public MybatisUtil(){
		String resource = "mybatis-spring.xml";//"Configuration.xml";//
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		
	}
		
	public static void main(String[] args) {
		new MybatisUtil(); 
		
		SqlSession session=sqlSessionFactory.openSession();
		session.selectList("PersonMapper.queryAll");
		session.commit();
		session.close();
		System.out.println(sqlSessionFactory);
	}
}
