package pt.example.hexarchapp.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.example.hexarchapp.adapters.output.persistence.data.TransactionData;

@Repository
public interface TransactionJPARepository extends JpaRepository<TransactionData, Long> {

}
