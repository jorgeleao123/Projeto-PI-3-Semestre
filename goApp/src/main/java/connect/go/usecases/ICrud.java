package connect.go.usecases;

import connect.go.configurations.DatabaseConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ICrud {

    JdbcTemplate ASSISTENTE = new JdbcTemplate(new DatabaseConfiguration().getDataSource());

    Object create(Object o);

    Object getById(int id);

    List<Object> get();

    Object updateById(int id, Object o);

    void deleteById(int id);
}
