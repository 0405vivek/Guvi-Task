package in.dp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.dp.main.dao.empdao;
import in.dp.main.entity.Emp;

@SpringBootApplication
public class SpringBootTask2Application implements CommandLineRunner {

	@Autowired
	private empdao empdao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTask2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	Emp emp=new Emp(101, "Jenny", 25, 10000);
//		Emp emp = new Emp(102, "Jacky", 30, 20000);

//		Emp emp= new Emp(103, "Joe", 20, 40000);
//
//		Emp emp = new Emp(104, "Jhon", 40, 80000);
//		
//		
//		Emp emp = new Emp(105, "Shameer", 25, 90000);

		boolean status = empdao.insertEmp(emp);

		if (status) {
			System.out.println("Employee Insert Successfully");

		} else {
			System.out.println("Employee Not Insert Successfully");

		}
	}

}
