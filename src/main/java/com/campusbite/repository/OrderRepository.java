package com.campusbite.repository;
import com.campusbite.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> { List<Order> findAllByOrderByIdDesc(); }
