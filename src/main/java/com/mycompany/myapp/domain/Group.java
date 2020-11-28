package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Group.
 */
@Entity
@Table(name = "jhi_group")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "min_member_count")
    private Integer minMemberCount;

    @Column(name = "max_member_count")
    private Integer maxMemberCount;

    @ManyToOne
    @JsonIgnoreProperties(value = "groups", allowSetters = true)
    private GradeLevel gradeLevel;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "jhi_group_subjects",
               joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "subjects_id", referencedColumnName = "id"))
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "jhi_group_students",
               joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "students_id", referencedColumnName = "id"))
    private Set<Student> students = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Group name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinMemberCount() {
        return minMemberCount;
    }

    public Group minMemberCount(Integer minMemberCount) {
        this.minMemberCount = minMemberCount;
        return this;
    }

    public void setMinMemberCount(Integer minMemberCount) {
        this.minMemberCount = minMemberCount;
    }

    public Integer getMaxMemberCount() {
        return maxMemberCount;
    }

    public Group maxMemberCount(Integer maxMemberCount) {
        this.maxMemberCount = maxMemberCount;
        return this;
    }

    public void setMaxMemberCount(Integer maxMemberCount) {
        this.maxMemberCount = maxMemberCount;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public Group gradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
        return this;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public Group subjects(Set<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

    public Group addSubjects(Subject subject) {
        this.subjects.add(subject);
        subject.getGroups().add(this);
        return this;
    }

    public Group removeSubjects(Subject subject) {
        this.subjects.remove(subject);
        subject.getGroups().remove(this);
        return this;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Group students(Set<Student> students) {
        this.students = students;
        return this;
    }

    public Group addStudents(Student student) {
        this.students.add(student);
        student.getGroups().add(this);
        return this;
    }

    public Group removeStudents(Student student) {
        this.students.remove(student);
        student.getGroups().remove(this);
        return this;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Group)) {
            return false;
        }
        return id != null && id.equals(((Group) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Group{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", minMemberCount=" + getMinMemberCount() +
            ", maxMemberCount=" + getMaxMemberCount() +
            "}";
    }
}
