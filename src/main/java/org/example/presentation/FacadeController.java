package org.example.presentation;

import org.example.presentation.todo.TodoController;
import spark.Spark;

public class FacadeController implements Controller {
  TodoController todoController = new TodoController();

  public void exec() {
    Spark.path("/api/v1", () -> {
      this.todoController.exec();
    });
  }
}
