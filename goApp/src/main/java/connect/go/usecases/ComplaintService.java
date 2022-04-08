package connect.go.usecases;

import connect.go.Repositories.ComplaintRepository;
import connect.go.models.Complaint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {
    private final ComplaintRepository complaintRepository;

    public Complaint getComplaintById(Integer complaintId) {
        return complaintRepository.getById(complaintId);
    }

    public List<Complaint> getComplaintByCity(String city) {
        return complaintRepository.getComplaintByCity(city);
    }

    public List<Complaint> getComplaintByState(String state) {
        return complaintRepository.getComplaintByState(state);
    }

    public List<Complaint> getComplaintByDistrict(String district) {
        return complaintRepository.getComplaintByDistrict(district);
    }

    public List<Complaint> getComplaintByCep(String cep) {
        return complaintRepository.getComplaintByCep(cep);
    }

    public Complaint register(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getComplaintByLicense(String license) {
        return complaintRepository.getComplaintByLicense(license);
    }

    public List<Complaint> getComplaintByLicenseAndName(String license, String name) {
        return complaintRepository.getComplaintByLicenseAndName(license, name);
    }

    public void setStatus(Integer complaintId, String status) {
        complaintRepository.setStatus(complaintId, status);
    }
}
