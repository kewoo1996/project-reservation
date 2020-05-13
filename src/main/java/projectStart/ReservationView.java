package projectStart;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ReservationView_table")
public class ReservationView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String seatCount;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getSeatCount() {
            return seatCount;
        }

        public void setSeatCount(String seatCount) {
            this.seatCount = seatCount;
        }

}
