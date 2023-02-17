package com.revature.swagshop.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.swagshop.models.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

  List<Receipt> getReceiptsByUser(Integer u);

}
