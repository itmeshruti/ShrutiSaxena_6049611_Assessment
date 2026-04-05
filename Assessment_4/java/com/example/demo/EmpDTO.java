package com.example.demo;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class EmpDTO {

    private Integer empId;

    @NotBlank
    @Size(min = 3, max = 25)
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Only alphabets allowed")
    private String empName;

    @Min(1000)
    @Max(500000)
    private Double empSal;

    @FutureOrPresent
    private LocalDate empDoj;

    @Pattern(regexp = "^(hr|pr|production)$", message = "Only hr or pr allowed")
    private String deptName;


    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public Double getEmpSal() { return empSal; }
    public void setEmpSal(Double empSal) { this.empSal = empSal; }

    public LocalDate getEmpDoj() { return empDoj; }
    public void setEmpDoj(LocalDate empDoj) { this.empDoj = empDoj; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
}