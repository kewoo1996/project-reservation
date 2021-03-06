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
    public void whenSeatCounted_then_CREATE_1(@Payload SeatCounted seatCounted) {
        try {
            if (seatCounted.isMe()) {
                // view 객체 생성
                ReservationView reservationView = new ReservationView();
                // view 객체에 이벤트의 Value 를 set 함
                reservationView.setCustomerId(seatCounted.getCustomerId());
                // view 레파지 토리에 save
                reservationViewRepository.save(reservationView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSeatCounted_then_UPDATE_1(@Payload SeatCounted seatCounted) {
        try {
            if (seatCounted.isMe()) {
                // view 객체 조회
                List<ReservationView> reservationViewList = reservationViewRepository.findByCustomerId(seatCounted.getCustomerId());
                
                for(ReservationView reservationView : reservationViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationView.setCustomerId(seatCounted.getCustomerId());
                    // view 레파지 토리에 save
                    reservationViewRepository.save(reservationView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_DELETE_2(@Payload ReservationCanceled reservationCanceled) {
        try {
            if (reservationCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                reservationViewRepository.deleteByCustomerId(reservationCanceled.getCustomerId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
