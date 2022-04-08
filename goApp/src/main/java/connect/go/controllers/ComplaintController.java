package connect.go.controllers;

import connect.go.models.Address;
import connect.go.models.Complaint;
import connect.go.models.Driver;
import connect.go.models.User;
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

    @GetMapping("/city")
    public ResponseEntity<Object> getComplaintByCity(@RequestHeader String city) {
        List<Complaint> list = complaintService.getComplaintByCity(city);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/cep")
    public ResponseEntity<Object> getComplaintByCep(@RequestHeader String cep) {
        List<Complaint> list = complaintService.getComplaintByCep(cep);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/district")
    public ResponseEntity<Object> getComplaintByDistrict(@RequestHeader String district) {
        List<Complaint> list = complaintService.getComplaintByDistrict(district);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/state")
    public ResponseEntity<Object> getComplaintByState(@RequestHeader String state) {
        List<Complaint> list = complaintService.getComplaintByState(state);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("id/{complaintId}")
    public ResponseEntity<Object> getComplaintById(@PathVariable Integer complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);
        return ResponseEntity.status(200).body(complaint);
    }

    @GetMapping("license/{license}")
    public ResponseEntity<Object> getComplaintByLicense(@PathVariable String license) {
        List<Complaint> list = complaintService.getComplaintByLicense(license);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/{license}/{name}")
    public ResponseEntity<Object> getComplaintByLicense(@PathVariable String license, @PathVariable String name) {
        List<Complaint> list = complaintService.getComplaintByLicenseAndName(license, name);
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<Object> createComplaint(@RequestBody Complaint complaint) {
        Address address = addressService.register(complaint.getAddress());
        User user = userService.register(complaint.getUser());
        Driver driver = driverService.register(complaint.getDriver());

        complaint.setAddress(address);
        complaint.setUser(user);
        complaint.setDriver(driver);
        complaint.setDateTimeComplaint(LocalDateTime.now());
        complaint.setStatus("valido");
        complaintService.register(complaint);
        return ResponseEntity.status(200).body(complaint);
    }
}
