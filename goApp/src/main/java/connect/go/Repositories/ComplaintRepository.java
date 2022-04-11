package connect.go.Repositories;

import connect.go.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    @Query("select c from Complaint c join c.address a where a.city = ?1")
    List<Complaint> getComplaintByCity(String city);

    @Query("select c from Complaint c join c.address a where a.district = ?1")
    List<Complaint> getComplaintByDistrict(String district);

    @Query("select c from Complaint c join c.address a where a.state = ?1")
    List<Complaint> getComplaintByState(String state);

    @Query("select c from Complaint c join c.address a where a.cep = ?1")
    List<Complaint> getComplaintByCep(String cep);

    @Query("select c from Complaint c join c.driver d where d.license = ?1")
    List<Complaint> getComplaintByLicense(String license);

    @Query("select c from Complaint c join c.driver d where d.license = ?1 and d.name = ?2")
    List<Complaint> getComplaintByLicenseAndName(String license, String name);

    @Query("update Complaint c set c.status=?2 where c.id=?1")
    void setStatus(Integer complaintId, String status);
}
