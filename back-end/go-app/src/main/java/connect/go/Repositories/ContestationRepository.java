package connect.go.Repositories;


import connect.go.models.Contestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ContestationRepository extends JpaRepository<Contestation, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Contestation c set c.status=?2 where c.id=?1")
    void setStatus(Integer contestationId, String status);

    Optional<Contestation> getContestationsByStatus(String status);

    Optional<Contestation> getContestationsByComplaintId(Integer complaintId);
    @Query("select c from Contestation c where c.user.id = ?1 order by c.dateTimeContestation desc")
    Optional<List<Contestation>> getContestationsByUserId(Integer userId);
}
