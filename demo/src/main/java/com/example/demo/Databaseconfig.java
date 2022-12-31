@Configuration
public class DatabaseConfig {

  @Bean
  @Primary
  public DataSource dataSource() {
    // Use Testcontainers to create an in-memory database for testing
    MySQLContainer mysqlContainer = new MySQLContainer<>();
    mysqlContainer.start();

    // Create a DataSource using the Testcontainers database
    return DataSourceBuilder
        .create()
        .url(mysqlContainer.getJdbcUrl())
        .username(mysqlContainer.getUsername())
        .password(mysqlContainer.getPassword())
        .build();
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
