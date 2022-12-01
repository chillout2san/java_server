package org.example.presentation.todo;

import org.example.presentation.Controller;
import spark.Spark;

public class TodoController implements Controller {
  public void exec() {
    Spark.path("/todo", () -> {
      Spark.get("/", (res, req) -> "hello world");
    });
  }
}
