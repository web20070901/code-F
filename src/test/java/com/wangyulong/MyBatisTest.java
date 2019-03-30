package com.wangyulong;

import com.wangyulong.dto.GearDTO;
import com.wangyulong.dto.StudentDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试信息，测试上传是否成功
 * master
 */
public class MyBatisTest {

    @Test
    public void testCase1(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlsession = sessionFactory.openSession();
            StudentDTO studentDTO = sqlsession.selectOne("com.wangyulong.dto.StudentMapper.queryStudentById");
            System.out.println(studentDTO);
            List<StudentDTO> studentDTOs = sqlsession.selectList("com.wangyulong.dto.StudentMapper.queryStudentAll");
            studentDTOs.forEach((s)->System.out.println(s));
            sqlsession.close();
            resourceAsStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase2(){
        try(InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");) {
            SqlSessionFactory sessionFac = new SqlSessionFactoryBuilder().build(in);
            SqlSession sessionSql = sessionFac.openSession();
            GearDTO gear =  sessionSql.selectOne("com.wangyulong.GearMapper.queryGearById",1);
            System.out.println(gear);
            List<GearDTO> gears = sessionSql.selectList("com.wangyulong.GearMapper.queryGearAll");
            gears.forEach((s)->System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
