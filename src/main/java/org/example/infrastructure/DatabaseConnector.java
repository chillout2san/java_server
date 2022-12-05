package org.example.infrastructure;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseConnector {

  public SqlSessionFactory sqlSessionFactory;

  public DatabaseConnector() throws IOException {
    var resource = "org/example/infrastructure/mybatis-config.xml";
    var inputStream = Resources.getResourceAsStream(resource);
    this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }
}
