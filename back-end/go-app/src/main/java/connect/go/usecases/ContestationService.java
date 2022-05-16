package connect.go.usecases;

import connect.go.Repositories.ContestationRepository;
import connect.go.models.Contestation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Contestation> getContestationsByStatus(String status) {
        return contestationRepository.getContestationsByStatus(status);
    }

    public Optional<Contestation> getContestationsByComplaintId(Integer complaintId) {
        return contestationRepository.getContestationsByComplaintId(complaintId);
    }

    public Optional<List<Contestation>> getContestationsByUserId(Integer userId) {
        return contestationRepository.getContestationsByUserId(userId);
    }
}
