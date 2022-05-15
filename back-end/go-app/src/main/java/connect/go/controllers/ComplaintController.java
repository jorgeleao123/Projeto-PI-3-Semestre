package connect.go.controllers;

import connect.go.exceptions.UserNotFoundException;
import connect.go.models.*;
import connect.go.models.dto.ComplaintRegistration;
import connect.go.usecases.AddressService;
import connect.go.usecases.ComplaintService;
import connect.go.usecases.DriverService;
import connect.go.usecases.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Complaint>> getComplaintByCity(@RequestHeader String city) {
        return ResponseEntity.of(complaintService.getComplaintByCity(city));
    }

    @GetMapping("/district")
    public ResponseEntity<List<Complaint>> getComplaintByDistrict(@RequestHeader String district) {
        return ResponseEntity.of(complaintService.getComplaintByDistrict(district));
    }

    @GetMapping("/state")
    public ResponseEntity<List<Complaint>> getComplaintByState(@RequestHeader String state) {
        return ResponseEntity.of(complaintService.getComplaintByState(state));
    }

    @GetMapping("/id/{complaintId}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Integer complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);
        return ResponseEntity.status(200).body(complaint);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getComplaintByUserId(@PathVariable Integer userId) {
        return ResponseEntity.of(complaintService.getComplaintByUserId(userId));
    }

    @GetMapping("/license/{license}")
    public ResponseEntity<List<Complaint>> getComplaintByLicense(@PathVariable String license) {
        return ResponseEntity.of(complaintService.getComplaintByLicense(license));
    }

    @GetMapping("/{license}/{name}")
    public ResponseEntity<List<Complaint>> getComplaintByLicense(@PathVariable String license,
                                                                 @PathVariable String name) {
        return ResponseEntity.of(complaintService.getComplaintByLicenseAndName(license, name));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Complaint> createComplaint(@PathVariable Integer userId, @RequestBody ComplaintRegistration complaintRegistration) {
        Address address = addressService.register(new Address(complaintRegistration.getState(), complaintRegistration.getCity(), complaintRegistration.getDistrict()));
        User user = userService.getById(userId);
        Driver driver = driverService.register(new Driver(complaintRegistration.getDriverName(), complaintRegistration.getLicensePlate()));
        Complaint complaint = new Complaint();
        complaint.setBo(complaintRegistration.getBo());
        complaint.setDescription(complaintRegistration.getDescription());
        complaint.setArchive(complaintRegistration.getArchive());
        complaint.setType(complaintRegistration.getType());
        complaint.setDateTimeComplaint(complaintRegistration.getDateTimeComplaint());
        complaint.setAddress(address);
        complaint.setUser(user);
        complaint.setDriver(driver);
        complaint.setDateTimePost(LocalDateTime.now());
        complaint.setStatus("valido");
        complaintService.register(complaint);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{userId}/{complaintId}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable Integer userId, @PathVariable Integer complaintId,
                                                     @RequestBody ComplaintRegistration complaintRegistration) {
        Address address = addressService.register(new Address(complaintRegistration.getState(), complaintRegistration.getCity(), complaintRegistration.getDistrict()));
        Driver driver = driverService.register(new Driver(complaintRegistration.getDriverName(), complaintRegistration.getLicensePlate()));
        Complaint complaint = complaintService.getComplaintById(complaintId);
        if (complaint.getUser().getId().equals(userId)) {
            complaint.setBo(complaintRegistration.getBo());
            complaint.setDescription(complaintRegistration.getDescription());
            complaint.setArchive(complaintRegistration.getArchive());
            complaint.setType(complaintRegistration.getType());
            complaint.setDateTimeComplaint(complaintRegistration.getDateTimeComplaint());
            complaint.setDateTimePost(LocalDateTime.now());
            complaint.setStatus("valido");
            complaint.setAddress(address);
            complaint.setDriver(driver);
            complaint = complaintService.register(complaint);
            return ResponseEntity.status(200).body(complaint);
        } else {
            throw new UserNotFoundException();
        }
    }


}
