package com.example.market.repository;

import com.example.market.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByLastnameIgnoreCase(String lastname);
    @Query( "select new com.example.market.models.User(u.id, u.firstname, u.lastname) " +
            "from User u join Purchase pur on u = pur.user join Product pr on pr = pur.product " +
            "where lower(pr.title) like lower(:title) group by u having count(pur) > :value")
    List<User> findUsersByCountOfProducts(String title, Long value);

}
