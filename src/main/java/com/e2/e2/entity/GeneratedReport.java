package com.e2.e2.entity;

public class GeneratedReport {
    private int reportId;
    private String generatedBy;
    private String reportName;
    private String filePath;
    private String fileFormat;
    private java.time.LocalDateTime generatedAt;
    private java.time.LocalDateTime createdAt;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public java.time.LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(java.time.LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}