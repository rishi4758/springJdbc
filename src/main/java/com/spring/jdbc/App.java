package com.spring.jdbc;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.spring.jdbc.dao.JdbcConfig;
import com.spring.jdbc.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
       StudentDao dao= context.getBean("Dao",StudentDao.class);
       
       Student student=new Student();
       student.setId(426);
       student.setName("rakull");
       student.setCity("nerwa");
      int r= dao.insert(student);
      System.out.println(r+"item inserted");
       List<Student> students=dao.getAllStudent();
       for(Student s:students) {
    	   System.out.println(s+" "); 
       }
      
//      Student student=new Student();
//      student.setId(123);
//      student.setName("neupane");
//      student.setCity("chopal");
//      int r=dao.update(student);
//      Student r=dao.getStudent(23);
//      System.out.println("del ............"+r);
      
      
//       String query="insert into student (id,name,city) values(?,?,?)";
//      int result= template.update(query,23,"rishav","shimla");
//        System.out.println("number of row......."+result);
    }
}
