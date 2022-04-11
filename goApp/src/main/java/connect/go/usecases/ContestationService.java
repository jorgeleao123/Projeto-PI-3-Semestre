package connect.go.usecases;

import connect.go.Repositories.ContestationRepository;
import connect.go.models.Contestation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContestationService {
    private final ContestationRepository contestationRepository;

    public void setStatus(Integer contestationId, String status) {
        contestationRepository.setStatus(contestationId, status);
    }

    public Contestation register(Contestation contestation) {
        return contestationRepository.save(contestation);
    }

    public List<Contestation> getContestationsByLicense(String license) {
        return contestationRepository.getContestationsByLicense(license);
    }

    public List<Contestation> getContestationsByComplaintId(Integer complaintId) {
        return contestationRepository.getContestationsByComplaintId(complaintId);
    }
}
