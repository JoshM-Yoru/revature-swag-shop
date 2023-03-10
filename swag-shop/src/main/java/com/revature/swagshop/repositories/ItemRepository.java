package com.revature.swagshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.swagshop.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}

