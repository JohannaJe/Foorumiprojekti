package foorumi.foorumi.Auto;

import foorumi.foorumi.Viestit.Viestit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutoRepo extends CrudRepository <Auto, Integer> {

 //   @Query ("UPDATE Auto set kommentti")



}
