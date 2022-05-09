package connect.go.Repositories;

import connect.go.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    @Query("select c from Complaint c join c.address a where a.city = ?1 order by c.dateTimeComplaint desc")
    Optional<List<Complaint>> getComplaintByCity(String city);

    @Query("select c from Complaint c join c.address a where a.district = ?1 order by c.dateTimeComplaint desc")
    Optional<List<Complaint>> getComplaintByDistrict(String district);

    @Query("select c from Complaint c join c.address a where a.state = ?1 order by c.dateTimeComplaint desc")
    Optional<List<Complaint>> getComplaintByState(String state);


    @Query("select c from Complaint c join c.driver d where d.licensePlate = ?1 order by c.dateTimeComplaint desc")
    Optional<List<Complaint>> getComplaintByLicensePlate(String license);

    @Query("select c from Complaint c join c.driver d where d.licensePlate = ?1 and d.name = ?2 order by c.dateTimeComplaint desc")
    Optional<List<Complaint>> getComplaintByLicensePlateAndName(String license, String name);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Complaint c set c.status=?2 where c.id=?1")
    void setStatus(Integer complaintId, String status);
}
