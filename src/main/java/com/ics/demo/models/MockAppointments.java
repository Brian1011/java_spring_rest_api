package com.ics.demo.models;

public class MockAppointments {
    private Long id;
    private Long studentId;
    private Long teacherId;
    private boolean confirmed;

    public MockAppointments() {
    }

    public MockAppointments(Long studentId, Long teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "MockAppointments{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", confirmed=" + confirmed +
                '}';
    }
}
