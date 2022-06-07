package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComplaintByTypeResponse {

    private long assedioHomem;
    private long assedioMulher;
    private long assedioMoralHomem;
    private long assedioMoralMulher;
    private long racismoHomem;
    private long racismoMulher;
    private long agressaoFisicaHomem;
    private long agressaoFisicaMulher;
    private long agressaoVerbalHomem;
    private long agressaoVerbalMulher;
    private long homofobiaHomem;
    private long homofobiaMulher;
    private long preconceitoHomem;
    private long preconceitoMulher;
    private long furtoHomem;
    private long furtoMulher;
}
