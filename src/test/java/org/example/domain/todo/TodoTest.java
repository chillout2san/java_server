package org.example.domain.todo;

import static org.junit.jupiter.api.Assertions.*;

import org.example.domain.DomainConstructionException;
import org.junit.jupiter.api.Test;

public class TodoTest {

  // 新しくTodoモデルを作成するテスト
  @Test
  public void createTodoTestNormal() {
    try {
      var argTitle = "dummy_title";
      var argContent = "dummy_content";
      var actual = new Todo(argTitle, argContent);
      assertEquals(argTitle, actual.getTitle());
      assertEquals(argContent, actual.getContent());
    } catch (DomainConstructionException e) {
    }
  }

  // 新しくTodoモデルを作成し、例外を発生させるテスト
  @Test
  public void createTodoTestError() {
    var expected = new DomainConstructionException("タイトルが空文字です");
    var actual = assertThrows(DomainConstructionException.class, () -> {
      var todo = new Todo("", "");
    });
    assertEquals(expected.getMessage(), actual.getMessage());
  }
}
