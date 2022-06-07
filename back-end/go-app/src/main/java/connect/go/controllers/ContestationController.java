package connect.go.controllers;

import connect.go.exceptions.UserNotFoundException;
import connect.go.models.Complaint;
import connect.go.models.Contestation;
import connect.go.models.User;
import connect.go.models.dto.ContestationRegistration;
import connect.go.models.dto.UserResponse;
import connect.go.usecases.ComplaintService;
import connect.go.usecases.ContestationService;
import connect.go.usecases.NotificationService;
import connect.go.usecases.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contestations")
public class ContestationController {

    private final ContestationService contestationService;
    private final ComplaintService complaintService;
    private final UserService userService;
    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Contestation>> getContestations() {
        List<Contestation> contestations = contestationService.findAll();
        if (contestations.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(contestations);
    }

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
        notificationService.register(contestation.getComplaint().getUser().getId(),
                "Sua denúncia foi contestada",
                "Contestaram a sua denúncia, estamos analisando o caso");
        notificationService.register(contestation.getUser().getId(),
                "Sua contestação foi criada",
                "Você já pode visualizá-la em minhas contestações");
        return ResponseEntity.status(201).build();
    }


    @PatchMapping("/aprove/{contestationId}")
    public ResponseEntity<Void> approveContestation(@PathVariable Integer contestationId) {
        contestationService.setStatus(contestationId, "aprovado");
        complaintService.setStatus(contestationId, "contestado");
        Contestation contestation = contestationService.getContestationById(contestationId);
        notificationService.register(contestation.getComplaint().getUser().getId(),
                "Sua denúncia foi removida",
                "Analisamos sua denúncia mediante a contestação feita pelo motorista e optamos por excluí-la");
        notificationService.register(contestation.getUser().getId(),
                "Sua contestação foi aprovada",
                "Analisamos sua contestação e mediante aos fatos apresentados, excluimos a denúncia");
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/reprove/{contestationId}")
    public ResponseEntity<Void> reproveContestation(@PathVariable Integer contestationId) {
        contestationService.setStatus(contestationId, "reprovado");
        complaintService.setStatus(contestationId, "valido");
        Contestation contestation = contestationService.getContestationById(contestationId);
        notificationService.register(contestation.getComplaint().getUser().getId(),
                "Sua denúncia foi validada",
                "Analisamos sua denúncia mediante a contestação feita pelo motorista");
        notificationService.register(contestation.getUser().getId(),
                "Sua contestação foi reprovada",
                "Analisamos sua contestação e mediante aos fatos apresentados, manteremos a denúncia");
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/archive/{userId}/{contestationId}")
    public ResponseEntity<Contestation> addArchiveContestation(@PathVariable Integer userId,
                                                               @PathVariable Integer contestationId,
                                                               @RequestBody MultipartFile file)

            throws IOException {
        Contestation contestation = contestationService.getContestationById(contestationId);
        if (contestation.getUser().getId().equals(userId)) {
            byte[] bytes = file.getBytes();
            contestation.setArchive(bytes);
            contestation = contestationService.register(contestation);
            return ResponseEntity.status(201).body(contestation);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping(value = "/archive/{contestationId}", produces = "image/png")
    public ResponseEntity getArchive(@PathVariable Integer contestationId) {
        Contestation contestation = contestationService.getContestationById(contestationId);

        return ResponseEntity.status(200)
                .body(contestation.getArchive());
    }
}
