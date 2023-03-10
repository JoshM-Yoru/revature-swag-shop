package com.revature.swagshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column(name = "item_id")
  private Integer itemId;

  @Column(name = "item_name")
  private String name;

  private Double price;

  private Integer amount;

  private String description;

  private String imageUrl;
}
