package sample.domain;

import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Set;

/**
 * Created by marek on 28.11.16.
 */
public class CustomEmployeeDetails extends org.springframework.security.core.userdetails.User{

    private Employee employee;

    /*TODO: Unimplemented. Co ma byc wysylane do GrantedAuthority?*/
    public CustomEmployeeDetails(Employee employee){
        super(employee.getEmail(), employee.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(employee.getRoles())));
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getId() {
        return employee.getId();
    }

    public Set<Role> getRoles() {
        return employee.getRoles();
    }

}
