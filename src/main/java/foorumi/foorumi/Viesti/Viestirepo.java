package foorumi.foorumi.Viesti;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Viestirepo extends CrudRepository<Viesti, Integer> {

    //List<Viesti> findByNameStartingWith(String hakusana);

    @Query(value = "select u from viesti u where u.teksti like concat('%',:teksti,'%')", nativeQuery = true)
    List<Viesti>haeKirjaimella(@Param("teksti")String teksti);

}
