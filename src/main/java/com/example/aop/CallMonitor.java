package com.example.aop;


public interface CallMonitor {

  boolean isEnabled();

  void setEnabled(boolean enabled);

  int getCounter();

  void registerCall(int count);

}
