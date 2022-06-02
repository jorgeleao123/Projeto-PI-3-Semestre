package connect.go.usecases;

import connect.go.Repositories.ComplaintRepository;
import connect.go.models.Complaint;
import connect.go.models.dto.ComplaintByTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComplaintService {
    private final ComplaintRepository complaintRepository;

    public Complaint getComplaintById(Integer complaintId) {
        return complaintRepository.getById(complaintId);
    }

    public Optional<List<Complaint>> getComplaintByCity(String city) {
        return complaintRepository.getComplaintByCity(city);
    }


    public Optional<List<Complaint>> getComplaintByState(String state) {
        return complaintRepository.getComplaintByState(state);
    }

    public Optional<List<Complaint>> getComplaintByDistrict(String district) {
        return complaintRepository.getComplaintByDistrict(district);
    }

    public Complaint register(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public Optional<List<Complaint>> getComplaintByLicense(String license) {
        return complaintRepository.getComplaintByLicensePlate(license);
    }

    public Optional<List<Complaint>> getComplaintByLicenseAndName(String license, String name) {
        return complaintRepository.getComplaintByLicensePlateAndName(license, name);
    }

    public void setStatus(Integer complaintId, String status) {
        Complaint complaint = complaintRepository.getById(complaintId);
        complaint.setStatus(status);
        complaintRepository.save(complaint);
    }

    public Integer countByUserId(Integer userId) {
        return complaintRepository.countByUserId(userId);
    }

    public Optional<List<Complaint>> getComplaintByUserId(Integer userId) {
        return complaintRepository.getComplaintByUserId(userId);
    }

    public long count() {
        return complaintRepository.count();
    }

    public ComplaintByTypeResponse countByTypeAndGenre() {
        ComplaintByTypeResponse response = new ComplaintByTypeResponse(
                complaintRepository.countByTypeAndUser_Genre("Assédio", "M"),
                complaintRepository.countByTypeAndUser_Genre("Assédio", "F"),
                complaintRepository.countByTypeAndUser_Genre("Assédio Moral", "M"),
                complaintRepository.countByTypeAndUser_Genre("Assédio Moral", "F"),
                complaintRepository.countByTypeAndUser_Genre("Racismo", "M"),
                complaintRepository.countByTypeAndUser_Genre("Racismo", "F"),
                complaintRepository.countByTypeAndUser_Genre("Agressão Física", "M"),
                complaintRepository.countByTypeAndUser_Genre("Agressão Física", "F"),
                complaintRepository.countByTypeAndUser_Genre("Agressão Verbal", "M"),
                complaintRepository.countByTypeAndUser_Genre("Agressão Verbal", "F"),
                complaintRepository.countByTypeAndUser_Genre("Homofobia", "M"),
                complaintRepository.countByTypeAndUser_Genre("Homofobia", "F"),
                complaintRepository.countByTypeAndUser_Genre("Preconceito", "M"),
                complaintRepository.countByTypeAndUser_Genre("Preconceito", "F"),
                complaintRepository.countByTypeAndUser_Genre("Furto", "M"),
                complaintRepository.countByTypeAndUser_Genre("Furto", "F"));
        return response;
    }
}
