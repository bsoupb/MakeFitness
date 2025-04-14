package korit.com.make_fitness.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private int reservationId;
    private int classId;
    private int membershipId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
