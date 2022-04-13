package connect.go.Repositories;


import connect.go.models.Contestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContestationRepository extends JpaRepository<Contestation, Integer> {

    @Query("update Contestation c set c.status=?2 where c.id=?1")
    void setStatus(Integer contestationId, String status);

    Optional<Contestation> getContestationsByStatus(String status);

    Optional<Contestation> getContestationsByComplaintId(Integer complaintId);
}
