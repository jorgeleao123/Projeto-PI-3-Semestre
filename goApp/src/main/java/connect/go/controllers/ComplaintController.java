package connect.go.controllers;

import connect.go.models.*;
import connect.go.usecases.AddressService;
import connect.go.usecases.ComplaintService;
import connect.go.usecases.DriverService;
import connect.go.usecases.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    private final AddressService addressService;

    private final UserService userService;

    private final DriverService driverService;

    private final AppArquivoCsv csv = new AppArquivoCsv();

    @GetMapping("/city")
    public ResponseEntity<List<Complaint>> getComplaintByCity(@RequestHeader String city) {
        return ResponseEntity.of(complaintService.getComplaintByCity(city));
    }

    @GetMapping("/cep")
    public ResponseEntity<List<Complaint>> getComplaintByCep(@RequestHeader String cep) {
        return ResponseEntity.of(complaintService.getComplaintByCep(cep));
    }

    @GetMapping("/district")
    public ResponseEntity<List<Complaint>> getComplaintByDistrict(@RequestHeader String district) {
        return ResponseEntity.of(complaintService.getComplaintByDistrict(district));
    }

    @GetMapping("/state")
    public ResponseEntity<List<Complaint>> getComplaintByState(@RequestHeader String state) {
        return ResponseEntity.of(complaintService.getComplaintByState(state));
    }

    @GetMapping("id/{complaintId}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Integer complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);
        return ResponseEntity.status(200).body(complaint);
    }

    @GetMapping("license/{license}")
    public ResponseEntity<List<Complaint>> getComplaintByLicense(@PathVariable String license) {
        return ResponseEntity.of(complaintService.getComplaintByLicense(license));
    }

    @GetMapping("/{license}/{name}")
    public ResponseEntity<List<Complaint>> getComplaintByLicense(@PathVariable String license,
                                                                 @PathVariable String name) {
        return ResponseEntity.of(complaintService.getComplaintByLicenseAndName(license, name));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Complaint> createComplaint(@PathVariable Integer userId, @RequestBody Complaint complaint) {
        Address address = addressService.register(complaint.getAddress());
        User user = userService.getById(userId);
        Driver driver = driverService.register(complaint.getDriver());

        complaint.setAddress(address);
        complaint.setUser(user);
        complaint.setDriver(driver);
        complaint.setDateTimeComplaint(LocalDateTime.now());
        complaint.setStatus("valido");
        complaintService.register(complaint);
        csv.gravaArquivoCsv(complaint, "posts");
        return ResponseEntity.status(200).body(complaint);
    }
        @GetMapping("/relatorios")
    public ResponseEntity getRelatorio() {

        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"posts.csv\"")
                .body(csv.leExibeArquivoCsv("posts"));
    }
}
