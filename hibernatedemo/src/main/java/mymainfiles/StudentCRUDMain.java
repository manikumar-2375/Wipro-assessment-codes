package mymainfiles;

import java.util.List;
import java.util.Scanner;

import mydaofiles.StudentDAO;
import mypojos.Student_123;

/*
 * mysql> select * from wipro_hibernate_students;
+----+---------------+-----------+
| id | email         | stud_name |
+----+---------------+-----------+
|  1 | dev@gmail.com | Devi      |
+----+---------------+-----------+
1 row in set (0.00 sec)

mysql> desc wipro_hibernate_students;
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| id        | int(11)      | NO   | PRI | NULL    | auto_increment |
| email     | varchar(255) | YES  |     | NULL    |                |
| stud_name | varchar(15)  | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)
 */
public class StudentCRUDMain {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add  2. View  3. Update  4. Delete  5. View All ");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    Student_123 s1 = new Student_123();
                    // System.out.print("Enter ID: ");//NO NEED! BCOS IT IS AUTOINCREMENT FIELD
                    //s1.setId(sc.nextInt());
                    System.out.print("Enter Name: ");
                    s1.setName(sc.next());
                    System.out.print("Enter Email: ");
                    s1.setEmail(sc.next());
                    dao.addStudent(s1);     //INSERT OBJECT INTO MYSQL TABLE      
                    break;
                case 2:
                    System.out.print("Enter ID to view: ");
                    Student_123 s2 = dao.getStudent(sc.nextInt());
                    if (s2 != null) {
                        System.out.println("Name: " + s2.getName() + ", Email: " + s2.getEmail());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    Student_123 s3 = new Student_123();
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    s3.setName(sc.next());
                    System.out.print("Enter New Email: ");
                    s3.setEmail(sc.next());
                    s3.setId(upId);
                    boolean updated = dao.updateStudent(s3);
                    if (updated) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student with ID " + upId + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    boolean deleted = dao.deleteStudent(delId);
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student with ID " + delId + " not found.");
                    }
                    break;
                case 5:
                    List<Student_123> list = dao.getAllStudents();
                    for (Student_123 s : list) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
                    }
                    break;
                case 6:
                    sc.close();
                    System.exit(0);

                    
            }
        }

	}

}
/*
Jul 29, 2025 5:38:59 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {4.0.4.Final}
Jul 29, 2025 5:38:59 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate Core {4.3.5.Final}
Jul 29, 2025 5:38:59 PM org.hibernate.cfg.Environment <clinit>
INFO: HHH000206: hibernate.properties not found
Jul 29, 2025 5:38:59 PM org.hibernate.cfg.Environment buildBytecodeProvider
INFO: HHH000021: Bytecode provider name : javassist
Jul 29, 2025 5:38:59 PM org.hibernate.cfg.Configuration configure
INFO: HHH000043: Configuring from resource: wiprohibernate.cfg.xml
Jul 29, 2025 5:38:59 PM org.hibernate.cfg.Configuration getConfigurationInputStream
INFO: HHH000040: Configuration resource: wiprohibernate.cfg.xml
Jul 29, 2025 5:38:59 PM org.hibernate.cfg.Configuration doConfigure
INFO: HHH000041: Configured SessionFactory: null
Jul 29, 2025 5:38:59 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH000402: Using Hibernate built-in connection pool (not for production use!)
Jul 29, 2025 5:38:59 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH000401: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/wipro2025]
Jul 29, 2025 5:38:59 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH000046: Connection properties: {user=root, password=****, autocommit=true}
Jul 29, 2025 5:38:59 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH000006: Autocommit mode: true
Jul 29, 2025 5:38:59 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Jul 29, 2025 5:38:59 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
Jul 29, 2025 5:38:59 PM org.hibernate.engine.jdbc.internal.LobCreatorBuilder useContextualLobCreation
INFO: HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
Jul 29, 2025 5:39:00 PM org.hibernate.engine.transaction.internal.TransactionFactoryInitiator initiateService
INFO: HHH000399: Using default transaction strategy (direct JDBC transactions)
Jul 29, 2025 5:39:00 PM org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory <init>
INFO: HHH000397: Using ASTQueryTranslatorFactory
Jul 29, 2025 5:39:02 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000228: Running hbm2ddl schema update
Jul 29, 2025 5:39:02 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000102: Fetching database metadata
Jul 29, 2025 5:39:02 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000396: Updating schema
Jul 29, 2025 5:39:02 PM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hibernate_students
Jul 29, 2025 5:39:02 PM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hibernate_students
Jul 29, 2025 5:39:02 PM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hibernate_students
Jul 29, 2025 5:39:02 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000232: Schema update complete

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 1
Enter Name: Devi
Enter Email: dev@gmail.com
Hibernate: insert into wipro_hibernate_students (email, stud_name) values (?, ?)

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 1
Enter Name: Abi
Enter Email: abi@gmail.com
Hibernate: insert into wipro_hibernate_students (email, stud_name) values (?, ?)

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 2
Enter ID to view: 2
Hibernate: select student_12x0_.id as id1_0_0_, student_12x0_.email as email2_0_0_, student_12x0_.stud_name as stud_nam3_0_0_ from wipro_hibernate_students student_12x0_ where student_12x0_.id=?
Name: Abi, Email: abi@gmail.com

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 5
Hibernate: select student_12x0_.id as id1_0_, student_12x0_.email as email2_0_, student_12x0_.stud_name as stud_nam3_0_ from wipro_hibernate_students student_12x0_
1 | Devi | dev@gmail.com
2 | Abi | abi@gmail.com

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 3
Enter ID to update: 34444
Enter New Name: xxx
Enter New Email: yyy
Hibernate: select student_12x0_.id as id1_0_0_, student_12x0_.email as email2_0_0_, student_12x0_.stud_name as stud_nam3_0_0_ from wipro_hibernate_students student_12x0_ where student_12x0_.id=?
Student with ID 34444 not found.

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 3
Enter ID to update: 2
Enter New Name: abinaya
Enter New Email: abinaya@gmail.com
Hibernate: select student_12x0_.id as id1_0_0_, student_12x0_.email as email2_0_0_, student_12x0_.stud_name as stud_nam3_0_0_ from wipro_hibernate_students student_12x0_ where student_12x0_.id=?
Hibernate: update wipro_hibernate_students set email=?, stud_name=? where id=?
Student updated successfully.

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 5
Hibernate: select student_12x0_.id as id1_0_, student_12x0_.email as email2_0_, student_12x0_.stud_name as stud_nam3_0_ from wipro_hibernate_students student_12x0_
1 | Devi | dev@gmail.com
2 | abinaya | abinaya@gmail.com

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 4
Enter ID to delete: 7777
Hibernate: select student_12x0_.id as id1_0_0_, student_12x0_.email as email2_0_0_, student_12x0_.stud_name as stud_nam3_0_0_ from wipro_hibernate_students student_12x0_ where student_12x0_.id=?
Student with ID 7777 not found.

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 4
Enter ID to delete: 2
Hibernate: select student_12x0_.id as id1_0_0_, student_12x0_.email as email2_0_0_, student_12x0_.stud_name as stud_nam3_0_0_ from wipro_hibernate_students student_12x0_ where student_12x0_.id=?
Hibernate: delete from wipro_hibernate_students where id=?
Student deleted successfully.

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 5
Hibernate: select student_12x0_.id as id1_0_, student_12x0_.email as email2_0_, student_12x0_.stud_name as stud_nam3_0_ from wipro_hibernate_students student_12x0_
1 | Devi | dev@gmail.com

1. Add  2. View  3. Update  4. Delete  5. View All 
Enter choice: 

*/