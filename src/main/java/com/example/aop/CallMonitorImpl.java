package com.example.aop;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource("bookdemo:type=CallMonitor")
public class CallMonitorImpl implements CallMonitor {

  private boolean enabled = true;

  private int count = 0;

  @Override
  @ManagedAttribute
  public boolean isEnabled() {

    return this.enabled;
  }

  @Override
  @ManagedOperation
  public void setEnabled(boolean enabled) {

    this.enabled = enabled;

  }

  @Override
  @ManagedAttribute
  public int getCounter() {

    return this.count;
  }

  @Override
  public void registerCall(int count) {

    this.count += count;

  }

}
