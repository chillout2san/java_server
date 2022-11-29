package org.example.domain.todo;

/**
 * Todoの状況の値オブジェクト
 */
public enum Status {
  DONE("完了"),
  ON_PROGRESS("作業中");

  private String status;

  Status(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }
}