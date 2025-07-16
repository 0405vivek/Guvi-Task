package in.dp.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import in.dp.main.entity.Emp;

@Repository
public class empdao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    boolean status = false;

    public boolean insertEmp(Emp emp) {
        try {
        	String INSERT_SQL_QUERY = "INSERT INTO emp(empcode, empname, empage, esalary) VALUES(?,?,?,?)";

            int count = jdbcTemplate.update(
                INSERT_SQL_QUERY,
                emp.getEmpcode(),  
                emp.getEmpname(),
                emp.getEmpage(),
                emp.getEsalary()
            );

            if (count > 0) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception ex) {
            status = false;
            ex.printStackTrace();
        }

        return status;
    }
}
