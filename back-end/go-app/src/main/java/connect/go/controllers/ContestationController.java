package connect.go.controllers;

import connect.go.models.Contestation;
import connect.go.models.dto.ContestationRegistration;
import connect.go.usecases.ComplaintService;
import connect.go.usecases.ContestationService;
import connect.go.usecases.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contestations")
public class ContestationController {

    private final ContestationService contestationService;
    private final ComplaintService complaintService;
    private final UserService userService;

    @GetMapping("/complaintId/{complaintId}")
    public ResponseEntity<Contestation> getContestationsByComplaintId(@PathVariable Integer complaintId) {
        return ResponseEntity.of(contestationService.getContestationsByComplaintId(complaintId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Contestation>> getContestationsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.of(contestationService.getContestationsByUserId(userId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Contestation> getContestationsByStatus(@PathVariable String status) {
        return ResponseEntity.of(contestationService.getContestationsByStatus(status));
    }

    @PostMapping
    public ResponseEntity<Void> registerContestation(@RequestBody ContestationRegistration contestationRegistration) {
        Contestation contestation = new Contestation();
        contestation.setArchive(contestationRegistration.getArchive());
        contestation.setDescription(contestationRegistration.getDescription());
        contestation.setComplaint(complaintService.getComplaintById(contestationRegistration.getComplaintId()));
        contestation.setUser(userService.getById(contestationRegistration.getUserId()));
        contestation.setStatus("em analise");
        contestation.setDateTimeContestation(LocalDateTime.now());
        contestationService.register(contestation);
        complaintService.setStatus(contestationRegistration.getComplaintId(), "em análise");
        //TODO criar notificação de denúncia em análise
        return ResponseEntity.status(201).build();
    }


    @PatchMapping("/aprove/{contestationId}")
    public ResponseEntity<Void> approveContestation(@PathVariable Integer contestationId) {
        contestationService.setStatus(contestationId, "aprovado");
        complaintService.setStatus(contestationId, "contestado");
        //TODO criar notificação de denúncia contestada
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/reprove/{contestationId}")
    public ResponseEntity<Void> reproveContestation(@PathVariable Integer contestationId) {
        contestationService.setStatus(contestationId, "reprovado");
        complaintService.setStatus(contestationId, "valido");
        //TODO criar notificação de denúncia validada
        return ResponseEntity.status(200).build();
    }
}
