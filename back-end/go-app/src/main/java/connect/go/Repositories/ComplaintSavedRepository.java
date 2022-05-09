package connect.go.Repositories;

import connect.go.models.Complaint;
import connect.go.models.ComplaintSaved;
import connect.go.models.ComplaintSavedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ComplaintSavedRepository extends JpaRepository<ComplaintSaved, ComplaintSavedId> {
    boolean existsByUserIdAndComplaintId(Integer userId, Integer complaintId);

    @Query("select c from Complaint c join ComplaintSaved cs on c.id = cs.id.complaintId where cs.id.userId = ?1 order by " +
            "c.dateTimeComplaint desc")
    Optional<Complaint> findAllComplaintsSavedByUserId(Integer userId);
}
