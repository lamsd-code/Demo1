package vn.iotstar.bai11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.bai11.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
