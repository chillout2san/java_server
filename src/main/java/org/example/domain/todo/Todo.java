package org.example.domain.todo;

import org.example.domain.DomainConstructionException;

/**
 * Todoのドメインモデル
 */
public class Todo {

  /**
   * Todoの一意なid
   */
  private String id;
  /**
   * Todoの名前
   */
  private String title;
  /**
   * Todoの内容
   */
  private String content;
  /**
   * Todoの状況
   */
  private Status status;

  /**
   * 新しいTodoを作成する際のコンストラクタ
   *
   * @param title   Todoの名前
   * @param content Todoの内容
   * @throws DomainConstructionException
   */
  public Todo(String title, String content) throws DomainConstructionException {
    if (title.equals("")) {
      throw new DomainConstructionException("タイトルが空文字です");
    }
    // ULID等を生成して代入するよう修正する
    this.id = "dummy_id";
    this.title = title;
    this.content = content;
    this.status = Status.ON_PROGRESS;
  }

  /**
   * 既に存在しているTodoのパースする際のコンストラクタ
   *
   * @param id      Todoの一意なid
   * @param title   Todoの名前
   * @param content Todoの内容
   * @param status  Todoの状況
   */
  public Todo(String id, String title, String content, Status status) {
    // 有効なインスタンスをパースするため、バリデーションはかけない
    this.id = id;
    this.title = title;
    this.content = content;
    this.status = status;
  }

  public String getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getStatus() {
    return this.status.getStatus();
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
