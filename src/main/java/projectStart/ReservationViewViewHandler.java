package projectStart;

import projectStart.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationViewViewHandler {


    @Autowired
    private ReservationViewRepository reservationViewRepository;



    @StreamListener(KafkaProcessor.INPUT)
    public void whenSeatCounted_then_UPDATE_1(@Payload SeatCounted seatCounted) {
        try {
            if (seatCounted.isMe()) {
                // view 객체 조회
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}