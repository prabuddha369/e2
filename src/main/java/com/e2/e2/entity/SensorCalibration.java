package com.e2.e2.entity;

public class SensorCalibration {
    private int calibrationId;
    private int sensorId;
    private java.time.LocalDateTime calibrationDate;
    private String calibrationBy;
    private float referenceValue;
    private float readingOffset;
    private float accuracyPercent;
    private java.time.LocalDateTime createdAt;

    // Getters and setters
    public int getCalibrationId() {
        return calibrationId;
    }

    public void setCalibrationId(int calibrationId) {
        this.calibrationId = calibrationId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public java.time.LocalDateTime getCalibrationDate() {
        return calibrationDate;
    }

    public void setCalibrationDate(java.time.LocalDateTime calibrationDate) {
        this.calibrationDate = calibrationDate;
    }

    public String getCalibrationBy() {
        return calibrationBy;
    }

    public void setCalibrationBy(String calibrationBy) {
        this.calibrationBy = calibrationBy;
    }

    public float getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(float referenceValue) {
        this.referenceValue = referenceValue;
    }

    public float getReadingOffset() {
        return readingOffset;
    }

    public void setReadingOffset(float readingOffset) {
        this.readingOffset = readingOffset;
    }

    public float getAccuracyPercent() {
        return accuracyPercent;
    }

    public void setAccuracyPercent(float accuracyPercent) {
        this.accuracyPercent = accuracyPercent;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}