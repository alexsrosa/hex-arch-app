package pt.example.hexarchapp.adapters.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.example.hexarchapp.adapters.output.persistence.data.PersonData;

@Repository
public interface PersonJPARepository extends JpaRepository<PersonData, Long> {

}
