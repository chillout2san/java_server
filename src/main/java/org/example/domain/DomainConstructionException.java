package org.example.domain;

/**
 * ドメインモデルのインスタンス化した際の例外
 */
public class DomainConstructionException extends Exception {
  public DomainConstructionException(String message) {
    super(message);
  }
}
