package connect.go.controllers;

import connect.go.models.AppArquivoCsv;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/relatorios")
public class CsvController {

    private final AppArquivoCsv csv = new AppArquivoCsv();

    @GetMapping("/complaints")
    public ResponseEntity getRelatorio() {

        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"posts.csv\"")
                .body(csv.leExibeArquivoCsv("posts"));
    }

}
