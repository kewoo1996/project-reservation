package projectStart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationViewRepository extends CrudRepository<ReservationView, Long> {
  
  void deleteByCustomerId(Long customerId);

}
