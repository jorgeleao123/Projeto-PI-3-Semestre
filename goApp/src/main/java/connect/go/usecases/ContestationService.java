package connect.go.usecases;

import connect.go.Repositories.ContestationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContestationService {
    private final ContestationRepository contestationRepository;
}
