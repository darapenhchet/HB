package kh.com.kshrd.repositories.impl;

/*@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public User findUserByEmail(String email) {
		try{
			User user = new User();
			user.setId(9988L);
			user.setUsername("user@gmail.com");
			user.setName("Vuthea");
			user.setPassword(new BCryptPasswordEncoder().encode("password"));
			user.setEmail("admin@gmail.com");
			user.setPhone("086961919");
			user.setStatus(true);
			user.setRoles(getAllRolesByUserId(user.getId()));
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private Set<Role> getAllRolesByUserId(Long id){
		Set<Role> roles = new HashSet<Role>();
		try{
			Role role = new Role();
			role.setId(1);
			role.setName("ROLE_ADMIN");
			roles.add(role);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return roles;
	}
	
}*/