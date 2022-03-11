package connect.go.configurations;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConfiguration {
    private BasicDataSource dataSource;

    public DatabaseConfiguration() {
        dataSource = new BasicDataSource();
// Configuração MySQL
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moodup"); // Link e porta do MySQL
        dataSource.setUsername("moodup");
        dataSource.setPassword("Senha123!");
    }

    // Implementar código da configuração do banco de dados


    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
