package org.example;

import org.example.presentation.FacadeController;

public class Main {

  public static void main(String[] args) {
    var facadeController = new FacadeController();
    facadeController.exec();
    System.out.println("waiting...");
  }
}