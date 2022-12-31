@Repository
public class UserRepository {

  private final JdbcTemplate jdbcTemplate;

  public UserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<User> findAll() {
    return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> {
      long id = rs.getLong("id");
      String name = rs.getString("name");
      return new User(id, name);
    });
  }
}
