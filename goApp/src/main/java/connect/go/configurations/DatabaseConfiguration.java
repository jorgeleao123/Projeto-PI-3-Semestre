package connect.go.configurations;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConfiguration {
    private final BasicDataSource dataSource;

    public DatabaseConfiguration() {
        dataSource = new BasicDataSource();
// Configuração SQL-SERVER
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl( "jdbc:sqlserver://go-project.database.windows.net:1433;database=go-database;" +
                "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net");
        dataSource.setUsername("projeto-go");
        dataSource.setPassword("#pedro_gracinha_123");
    }

    // Implementar código da configuração do banco de dados


    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
