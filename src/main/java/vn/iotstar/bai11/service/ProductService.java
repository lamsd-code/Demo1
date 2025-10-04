package vn.iotstar.bai11.service;

import java.util.List;

import vn.iotstar.bai11.entity.Product;

public interface ProductService {

    List<Product> listAll();

    void save(Product product);

    Product get(long id);

    void delete(long id);
}
