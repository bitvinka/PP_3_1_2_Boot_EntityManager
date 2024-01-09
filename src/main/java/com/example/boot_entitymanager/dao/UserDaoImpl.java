package com.example.boot_entitymanager.dao;

import com.example.boot_entitymanager.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
   @PersistenceContext
   private EntityManager em;


   @Override
   public void addUser(User user) {
      em.persist(user);
   }

   @Override

   public List<User> getUsers() {
      return em.createQuery("from users", User.class).getResultList();
   }

   @Override
   public Optional<User> getUserById(Long id) {
      return Optional.ofNullable(em.find(User.class, id));

   }

   @Override
   public void removeUser(Long id) {
      User user = em.find(User.class, id);
      em.remove(user);
   }

   @Override
   public void updateUser(User user) {
      em.merge(user);
   }

   @Override
   public Optional<User> findByEmail(String email) {
      return em.createQuery("select u from users u where u.email =:userEmail", User.class)
      .setParameter("userEmail", email)
              .getResultList()
              .stream()
              .findFirst();
   }
}
