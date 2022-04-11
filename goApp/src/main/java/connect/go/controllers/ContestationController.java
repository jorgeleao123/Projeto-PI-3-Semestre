package connect.go.controllers;

import connect.go.models.Complaint;
import connect.go.models.Contestation;
import connect.go.usecases.ComplaintService;
import connect.go.usecases.ContestationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contestations")
public class ContestationController {

    private final ContestationService contestationService;
    private final ComplaintService complaintService;

    @GetMapping("/complaintId/{complaintId}")
    public ResponseEntity<Object> getContestationsByComplaintId(@PathVariable Integer complaintId) {
        List<Contestation> contestations =contestationService.getContestationsByComplaintId(complaintId);
        return ResponseEntity.status(200).body(contestations);
    }

    @GetMapping("/license/{license}")
    public ResponseEntity<Object> getContestationsByLicense(@PathVariable String license) {
        List<Contestation> contestations =contestationService.getContestationsByLicense(license);
        return ResponseEntity.status(200).body(contestations);
    }

    @PostMapping("/{complaintId}")
    public ResponseEntity<Object> registerContestation(@PathVariable Integer complaintId,
                                                                @RequestBody Contestation contestation) {
        Contestation newContestation =contestationService.register(contestation);
        contestationService.setStatus(newContestation.getId(), "em analise");
        complaintService.setStatus(complaintId, "em análise");
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/aprove/{contestationId}")
    public ResponseEntity<Object> approveContestation(@PathVariable Integer contestationId) {
        contestationService.setStatus(contestationId, "aprovado");
        complaintService.setStatus(contestationId, "contestado");
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/reprove/{contestationId}")
    public ResponseEntity<Object> reproveContestation(@PathVariable Integer contestationId) {
        contestationService.setStatus(contestationId, "reprovado");
        complaintService.setStatus(contestationId, "valido");
        return ResponseEntity.status(200).build();
    }
}
