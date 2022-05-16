package connect.go.controllers;

import connect.go.models.Complaint;
import connect.go.models.ComplaintSavedId;
import connect.go.models.dto.ComplaintSavedRegistration;
import connect.go.usecases.ComplaintSavedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/complaints-saved")
public class ComplaintSavedController {

    private final ComplaintSavedService complaintSavedService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Complaint>> getComplaintsSaved(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(complaintSavedService.getComplaintSavedByUserId(userId).stream().collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> registerComplaintSaved(@RequestBody ComplaintSavedRegistration complaintSavedRegistration) {
        ComplaintSavedId id = new ComplaintSavedId(complaintSavedRegistration.getUserId(),
                complaintSavedRegistration.getComplaintId());
        complaintSavedService.register(id);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{userId}/{complaintId}")
    public ResponseEntity<Void> deleteComplaintsSaved(@PathVariable Integer userId, @PathVariable Integer complaintId) {
        ComplaintSavedId id = new ComplaintSavedId(userId, complaintId);
        complaintSavedService.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
