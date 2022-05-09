package connect.go.usecases;

import connect.go.Repositories.ComplaintSavedRepository;
import connect.go.exceptions.ComplaintSavedAlreadyExistsException;
import connect.go.exceptions.FavoriteAddressAlreadyExistsException;
import connect.go.exceptions.FavoriteAddressNotFoundException;
import connect.go.models.Complaint;
import connect.go.models.ComplaintSaved;
import connect.go.models.ComplaintSavedId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComplaintSavedService {
    private final ComplaintSavedRepository complaintSavedRepository;

    public void register(ComplaintSavedId complaintSavedId) {
        ComplaintSaved complaintSaved = new ComplaintSaved();
        complaintSaved.setId(complaintSavedId);
        if (existsById(complaintSavedId)){
            throw new ComplaintSavedAlreadyExistsException();
        }else {
            complaintSavedRepository.save(complaintSaved);
        }
    }

    public void deleteById(ComplaintSavedId complaintSavedId) {
        if (existsById(complaintSavedId)){
            complaintSavedRepository.deleteById(complaintSavedId);
        } else {
            throw new FavoriteAddressNotFoundException();
        }
    }

    public boolean existsById(ComplaintSavedId complaintSavedId) {
        return complaintSavedRepository.existsByUserIdAndComplaintId(complaintSavedId.getUserId(), complaintSavedId.getComplaintId());
    }

    public Optional<Complaint> getComplaintSavedByUserId(Integer userId) {
        return complaintSavedRepository.findAllComplaintsSavedByUserId(userId);
    }
}
