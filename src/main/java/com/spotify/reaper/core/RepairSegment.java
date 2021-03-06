package com.spotify.reaper.core;

import org.joda.time.DateTime;

import java.math.BigInteger;

public class RepairSegment {
  private Long id;
  private final ColumnFamily columnFamily;
  private final long runID;
  private final int priority; // int? long?
  private final BigInteger startToken;
  private final BigInteger endToken;
  private final State state;
  private final DateTime startTime;
  private final DateTime endTime;

  public enum State {
    NOT_STARTED,
    RUNNING,
    DONE
  }

  public RepairSegment(RepairSegmentBuilder builder) {
    this.id = builder.id;
    this.columnFamily = builder.columnFamily;
    this.runID = builder.runID;
    this.priority = builder.priority;
    this.startToken = builder.startToken;
    this.endToken = builder.endToken;
    this.state = builder.state;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
  }


  public static class RepairSegmentBuilder {
    private long id;
    private ColumnFamily columnFamily;
    private long runID;
    private int priority;
    private BigInteger startToken;
    private BigInteger endToken;
    private RepairSegment.State state;
    private DateTime startTime;
    private DateTime endTime;

    public RepairSegmentBuilder id(long id) {
      this.id = id;
      return this;
    }

    public RepairSegmentBuilder columnFamily(ColumnFamily columnFamily) {
      this.columnFamily = columnFamily;
      return this;
    }

    public RepairSegmentBuilder runID(long runID) {
      this.runID = runID;
      return this;
    }

    public RepairSegmentBuilder priority(int priority) {
      this.priority = priority;
      return this;
    }

    public RepairSegmentBuilder startToken(BigInteger startToken) {
      this.startToken = startToken;
      return this;
    }

    public RepairSegmentBuilder endToken(BigInteger endToken) {
      this.endToken = endToken;
      return this;
    }

    public RepairSegmentBuilder state(RepairSegment.State state) {
      this.state = state;
      return this;
    }

    public RepairSegmentBuilder startTime(DateTime startTime) {
      this.startTime = startTime;
      return this;
    }

    public RepairSegmentBuilder endTime(DateTime endTime) {
      this.endTime = endTime;
      return this;
    }


    public RepairSegment createRepairSegment() {
      return new RepairSegment(this);
    }
  }
}
