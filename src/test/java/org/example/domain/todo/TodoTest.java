package org.example.domain.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.example.domain.DomainConstructionException;
import org.example.util.Id;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class TodoTest {

  private class TodoNewConstructorTestCase {

    private String name;
    private String id;
    private String title;
    private String content;
    private String expectedException;

    private TodoNewConstructorTestCase(String name, String id, String title, String content,
        String expectedException) {
      this.name = name;
      this.id = id;
      this.title = title;
      this.content = content;
      this.expectedException = expectedException;
    }
  }

  /**
   * 新しいTodoを作成するコンストラクタのテスト
   *
   * @return
   * @see <a href="https://qiita.com/nodataka/items/06ac753036d671371554">参照した記事</a>
   */
  @TestFactory
  public Stream<DynamicNode> TodoNewConstructorTest() {
    return Stream.of(
        new TodoNewConstructorTestCase("正常系のテスト", Id.create(), "dummy_title", "dummy_content",
            ""),
        new TodoNewConstructorTestCase("異常系のテスト:idの形が不正の時、例外をスローするか", "invalid_id",
            "dummy_title", "dummy_content", "有効なIdではありません"),
        new TodoNewConstructorTestCase("異常系のテスト:titleが空文字の時、例外をスローするか", Id.create(), "",
            "dummy_content", "タイトルが空文字です")
    ).map(testCase -> DynamicTest.dynamicTest(testCase.name, () -> {
      try {
        var todo = new Todo(testCase.id, testCase.title, testCase.content);
        assertEquals(testCase.id, todo.getId());
        assertEquals(testCase.title, todo.getTitle());
        assertEquals(testCase.content, todo.getContent());
        assertEquals(Status.ON_PROGRESS.getValue(), todo.getStatus());
      } catch (DomainConstructionException e) {
        assertEquals(testCase.expectedException, e.getMessage());
      } catch(Exception e) {
        fail();
      }
    }));
  }
}
