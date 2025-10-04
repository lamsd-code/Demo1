package vn.iotstar.bai11.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.bai11.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByEmail(String email);
}
