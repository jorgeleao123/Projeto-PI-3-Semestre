package connect.go.controllers;

import connect.go.exceptions.UserAlreadyExistsException;
import connect.go.models.*;
import connect.go.usecases.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reports")
public class CsvController {

    private final AppArquivoCsv csv = new AppArquivoCsv();
    private final ComplaintService complaintService;

    private List<Complaint> lista;

    private ListaObj<Complaint> listaObjComplaint;

    @GetMapping("/{city}")
    public ResponseEntity getRelatorioByCity(@PathVariable String city) {
        lista = complaintService.getComplaintByCity(city).orElse(Collections.emptyList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            listaObjComplaint = new ListaObj<>(lista.size());
            for (Complaint complaint : lista) {
                listaObjComplaint.adiciona(complaint);
            }
            csv.gravaArquivoCsv(listaObjComplaint, "posts");
            return ResponseEntity.status(200)
                    .header("content-type", "text/csv")
                    .header("content-disposition", "filename=\"posts.csv\"")
                    .body(csv.leExibeArquivoCsv("posts"));
        }
    }

    @GetMapping("/orderBy/{city}")
    public ResponseEntity getRelatorioComplaintOrderByCity(@PathVariable String city) {
        lista = complaintService.getComplaintByCity(city).orElse(Collections.emptyList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            listaObjComplaint = new ListaObj<>(lista.size());
            lista.forEach(complaint -> listaObjComplaint.adiciona(complaint));
            listaObjComplaint.ordenarPorIdDoUsuario();
            csv.gravaArquivoCsv(listaObjComplaint, "posts");
            return ResponseEntity.status(200)
                    .header("content-type", "text/csv")
                    .header("content-disposition",  "filename=\"posts.csv\"")
                    .body(csv.leExibeArquivoCsv("posts"));
        }
    }


    @GetMapping("/baixarTest")
    public ResponseEntity getRelatorio() {

        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"posts.csv\"")
                .body(csv.leExibeArquivoCsv("posts"));
    }


    @GetMapping("/gravarTest")
    public ResponseEntity<ListaObj<Complaint>>gravarTest() {
        ListaObj<Complaint> complaintListaObj = new ListaObj<>(10);

        Driver driver = new Driver(5, "Antonio", "total", "calvo-cabeludo");
        Address address = new Address(1, "04914-040", "SP", "São Paulo", "Esse ai");

        User user1 = new User(1, "Pedrão", "pedrao@alfa.com", "alfa", "total", "Alfa");
        Complaint complaint1 = new Complaint(8, "decrição", "titulo", "nenhum", "Verificado", "1234", LocalDateTime.now(), "tipo", driver, user1, address);

        User user2 = new User(3, "Pedrão", "pedrao@alfa.com", "alfa", "total", "Alfa");
        Complaint complaint2 = new Complaint(2, "decrição", "titulo", "nenhum", "Verificado", "1234", LocalDateTime.now(), "tipo", driver, user2, address);

        User user3 = new User(2, "Pedrão", "pedrao@alfa.com", "alfa", "total", "Alfa");

        Complaint complaint3 = new Complaint(1, "decr   ição", "titulo", "nenhum", "Verificado", "1234", LocalDateTime.now(), "tipo", driver, user3, address);
        complaintListaObj.adiciona(complaint1);
        complaintListaObj.adiciona(complaint2);
        complaintListaObj.adiciona(complaint3);
        complaintListaObj.adiciona(complaint3);
        complaintListaObj.adiciona(complaint1);
        complaintListaObj.adiciona(complaint1);
        complaintListaObj.adiciona(complaint2);
        complaintListaObj.adiciona(complaint3);
        complaintListaObj.adiciona(complaint3);
        complaintListaObj.adiciona(complaint1);

        csv.gravaArquivoCsv(complaintListaObj, "posts");
        return ResponseEntity.status(200).body(complaintListaObj);
    }
}
