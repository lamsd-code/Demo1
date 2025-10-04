package vn.iotstar.bai11.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vn.iotstar.bai11.model.Customer;

@RestController
public class CustomerController {

    private final List<Customer> customers = List.of(
            Customer.builder()
                    .id(1L)
                    .name("Nguyễn Hữu Trung")
                    .phoneNumber("0123456789")
                    .email("trung@example.com")
                    .build(),
            Customer.builder()
                    .id(2L)
                    .name("Nguyễn Văn Hậu")
                    .phoneNumber("0987654321")
                    .email("hau@example.com")
                    .build());

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Xin chào Spring Security!");
    }

    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
