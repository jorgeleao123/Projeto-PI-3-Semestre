package connect.go.usecases;

import connect.go.Repositories.ComplaintRepository;
import connect.go.models.Complaint;
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

    public Optional<List<Complaint>> getComplaintByCep(String cep) {
        return complaintRepository.getComplaintByCep(cep);
    }

    public Complaint register(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public Optional<List<Complaint>> getComplaintByLicense(String license) {
        return complaintRepository.getComplaintByLicense(license);
    }

    public Optional<List<Complaint>> getComplaintByLicenseAndName(String license, String name) {
        return complaintRepository.getComplaintByLicenseAndName(license, name);
    }

    public void setStatus(Integer complaintId, String status) {
        complaintRepository.setStatus(complaintId, status);
    }

}
