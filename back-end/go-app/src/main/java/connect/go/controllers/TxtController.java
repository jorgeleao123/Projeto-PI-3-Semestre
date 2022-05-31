package connect.go.controllers;

import connect.go.usecases.TxtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imports")
@RequiredArgsConstructor
public class TxtController {

    private final TxtService txtService;

    @PostMapping("/userRegistration")
    public ResponseEntity<Void> importUserRegistration(@RequestParam MultipartFile file) {
        txtService.leArquivoTxtUserRegistration(file);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/userRegistration/cadastrar")
    public ResponseEntity<Void> cadastrarFilaUserRegistration() {
        txtService.cadastraUsuariosFila();
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/userRegistration/gravar-resposta")
    public ResponseEntity<Void> gravarPilhaUserResponse() {
        String nome = "user.txt";
        txtService.gravaArquivoTxt(nome);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/userRegistration/list")
    public ResponseEntity<Object> exportUserResponse() {
//        txtService.cadastraUsuariosFila();
        String nome = "user.txt";
//        txtService.gravaArquivoTxt(nome);
        return ResponseEntity.status(200)
                .header("content-type", "text/plain")
                .header("content-disposition", "attachment; filename=\"user.txt\"")
                .body(txtService.leExportaTxt(nome));
    }

}
