import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        RoleDAO roleDAO = new RoleDAOimpl();

        Role dev = new Role();
        dev.setRoleType(RoleType.DEVELOPER);
        Role analyst = new Role();
        analyst.setRoleType(RoleType.ANALYST);
        Role manager = new Role();
        manager.setRoleType(RoleType.MANAGER);
        Role qa = new Role();
        qa.setRoleType(RoleType.QA);
        Role designer = new Role();
        designer.setRoleType(RoleType.DESIGNER);
        Role df = new Role();
        df.setRoleType(RoleType.DEFAULT);

//        roleDAO.createRole(dev);
//        roleDAO.createRole(analyst);
//        roleDAO.createRole(manager);
//        roleDAO.createRole(qa);
//        roleDAO.createRole(designer);
//        roleDAO.createRole(df);

        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRoleById(1));
        roles.add(roleDAO.getRoleById(2));
        roles.add(roleDAO.getRoleById(3));
        roles.add(roleDAO.getRoleById(4));
        roles.add(roleDAO.getRoleById(5));

        User user = new User();
        user.setUserName("Ivan");
        user.setLogin("login");
        user.setPassword("password");
        user.setCreationDate(LocalDateTime.now());
        user.setDateOfCange(LocalDateTime.now());
        user.setRoleSet(roles);

        User addedUser = userDAO.createUser(user);
//        roles.add(roleDAO.getRoleById(6));
//        addedUser.setRoleSet(roles);
//        userDAO.updateUser(addedUser);
//        userDAO.deleteUser(addedUser);
    }
}
