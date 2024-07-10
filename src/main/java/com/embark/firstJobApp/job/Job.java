package com.embark.firstJobApp.job;

import com.embark.firstJobApp.company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private int minSalary;
    private int maxSalary;
    private String location;

    @ManyToOne
    private Company company;
    public Job() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job(long id, String title, int minSalary, String description, String location, int maxSalary) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.description = description;
        this.location = location;
        this.maxSalary = maxSalary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
