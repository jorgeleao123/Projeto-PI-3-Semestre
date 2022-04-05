package connect.go.controllers;

import connect.go.models.Complaint;
import connect.go.usecases.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    @GetMapping
    public ResponseEntity<Object> getComplaintByCity(@RequestHeader String city) {
        List<Complaint> list = complaintService.getComplaintByCity(city);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping
    public ResponseEntity<Object> getComplaintByCep(@RequestHeader String cep) {
        List<Complaint> list = complaintService.getComplaintByCep(cep);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping
    public ResponseEntity<Object> getComplaintByDistrict(@RequestHeader String district) {
        List<Complaint> list = complaintService.getComplaintByDistrict(district);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping
    public ResponseEntity<Object> getComplaintByState(@RequestHeader String state) {
        List<Complaint> list = complaintService.getComplaintByState(state);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping
    public ResponseEntity<Object> getComplaintById(@PathVariable Integer complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);
        return ResponseEntity.status(200).body(complaint);
    }

    @PostMapping
    public ResponseEntity<Object> createComplaint(@PathVariable Integer complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);
        return ResponseEntity.status(200).body(complaint);
    }
}
