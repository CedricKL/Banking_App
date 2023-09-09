package com.formation.banking.repositories;

import com.formation.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //With the SDP

    List<User> findAllByFirstname(String firstname);  // select * from user where firstname = 'cédric'

    List<User> findAllByFirstnameContaining(String firstname); // select * from user where firstname like '%ced%'

    List<User> findAllByAccount_Iban(String iban); // select (user fields) from user u inner join account a on u.id = a.user_id where a.iban = 'FR76 9854 6666 7845 10'

    User findByAddressCityContainsIgnoreCase(String city); // select (user fields) from user u inner join address a on u.id = a.user_id where a.city like '%new%' (in this case, we ignore the case - Capital letter or not- )

    // With JPQL

    @Query("from User where firstname = :firstname")
    List<User>  searchByFirstname(String firstname);

    @Query("from User u inner join Address a on u.id = a.user.id where a.city = '%:c%'")  //ever use alias with join
    User searchByAddressCity(@Param("c") String city);

    //With native SQL

    @Query(value = "select * from user_app where firstname like '%firstname%'", nativeQuery = true)
    List<User> ListOfUserByFirstname(String firstname);
}
