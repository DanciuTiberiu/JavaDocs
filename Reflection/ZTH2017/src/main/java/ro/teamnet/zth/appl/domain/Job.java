package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Tiberiu.Danciu on 7/12/2017.
 */
@Table(name = "Jobs")
public class Job {
    @Id(name = "job_id")
    private Job id;
    @Column(name = "job_title")
    private String job_title;
    @Column(name = "min_salary")
    private Long min_salary;
    @Column(name = "max_salary")
    private Long max_salary;

    public Job getId() {
        return id;
    }

    public void setId(Job id) {
        this.id = id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Long min_salary) {
        this.min_salary = min_salary;
    }

    public Long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Long max_salary) {
        this.max_salary = max_salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", job_title='" + job_title + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (!id.equals(job.id)) return false;
        if (!job_title.equals(job.job_title)) return false;
        if (!min_salary.equals(job.min_salary)) return false;
        return max_salary.equals(job.max_salary);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + job_title.hashCode();
        result = 31 * result + min_salary.hashCode();
        result = 31 * result + max_salary.hashCode();
        return result;
    }
}
