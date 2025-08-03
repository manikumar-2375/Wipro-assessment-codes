package mypojos;
/*
 * | Annotation                                             | Description                                           |
| ------------------------------------------------------ | ----------------------------------------------------- |
| `@Entity`                                              | Marks the class as an entity to map to a table        |
| `@Table(name = "table_name")`                          | Specifies table name (optional if same as class name) |
| `@Id`                                                  | Marks the primary key                                 |
| `@GeneratedValue(...)`                                 | Auto-generates ID (e.g., AUTO, IDENTITY, SEQUENCE)    |
| `@Column(name = "...")`                                | Maps a field to a specific column                     |
| `@Transient`                                           | Excludes field from persistence                       |
| `@Lob`                                                 | Large Object (CLOB/BLOB)                              |
| `@Temporal(...)`                                       | For date/time fields                                  |
| `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany` | For relationships                                     |

 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//ENTITY CLASS OR POJO CLASS OR BEAN CLASS

@Entity
@Table(name="wipro_hibernate_students")//THIS MYSQL TABLE WILL BE CREATED AUTOMATICALLY BY HIBERNATE ARCHITECTURE
public class Student_123 {

    	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

    	@Column(name = "stud_name",length=15)
	    private String name;

    	@Column
	    private String email;//mysql table column name is email

    	// Getters and Setters
        public int getId() { return id; }

        public void setId(int id) { this.id = id; }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }

        public void setEmail(String email) { this.email = email; }

}
