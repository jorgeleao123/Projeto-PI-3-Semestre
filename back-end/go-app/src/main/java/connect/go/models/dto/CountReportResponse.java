package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountReportResponse {
    private long complaintCount;
    private long contestationCount;
    private long searchCount;
}
