package org.example.util;

import ulid4j.Ulid;

public class Id {

  /**
   * ULIDを生成する
   *
   * @return ULID
   */
  public static String create() {
    var generator = new Ulid();
    return generator.create();
  }

  /**
   * 有効なULIDかどうかチェックする
   *
   * @param ulid ULID
   * @return
   */
  public static boolean validate(String ulid) {
    return Ulid.isValid(ulid);
  }
}
