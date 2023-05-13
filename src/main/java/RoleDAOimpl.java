import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class RoleDAOimpl implements RoleDAO{
    @Override
    public List<Role> getAllRoles() {
        EntityManager entityManager = createEntityManager();
        Query query = entityManager.createQuery("select r from Role r");
        return query.getResultList();
    }

    @Override
    public Role getRoleById(int id) {
        EntityManager entityManager = createEntityManager();
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role createRole(Role role) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(role);
        transaction.commit();
        entityManager.close();
        return role;
    }

    @Override
    public void updateRole(Role role) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(role);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteRole(Role role) {
        EntityManager entityManager = createEntityManager();
        entityManager.find(Role.class, role.getRoleId());
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(role);
        transaction.commit();
        entityManager.close();
    }

    private static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();
    }
}
