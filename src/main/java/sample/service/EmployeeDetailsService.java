package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sample.domain.CustomEmployeeDetails;
import sample.domain.Employee;
import sample.domain.Role;
import sample.repository.EmployeeRepository;
import sample.repository.RoleRepository;

import java.util.Set;


/**
 * Created by marek on 28.11.16.
 */
@Service
public class EmployeeDetailsService implements UserDetailsService{
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private Set<Role> roles;

    @Autowired
    public EmployeeDetailsService(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(email);
        if(employee == null){
            throw new UsernameNotFoundException("No employee present with username(email): " + email);
        } else{
            roles = employee.getRoles();
            return new CustomEmployeeDetails(employee);
        }
    }
}
