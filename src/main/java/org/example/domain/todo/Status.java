package org.example.domain.todo;

/**
 * Todoの状況の値オブジェクト
 */
public enum Status {
  DONE("完了"),
  ON_PROGRESS("作業中");

  private String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}