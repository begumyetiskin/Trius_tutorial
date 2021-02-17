package trius.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import trius.springframework.domain.Order;

public interface OrderRepository extends CrudRepository<Order, String> {
}
