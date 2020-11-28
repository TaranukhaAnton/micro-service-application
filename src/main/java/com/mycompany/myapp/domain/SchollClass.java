package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A SchollClass.
 */
@Entity
@Table(name = "scholl_class")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SchollClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "scholl_class_grade_levels",
               joinColumns = @JoinColumn(name = "scholl_class_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "grade_levels_id", referencedColumnName = "id"))
    private Set<GradeLevel> gradeLevels = new HashSet<>();

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

    public SchollClass name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GradeLevel> getGradeLevels() {
        return gradeLevels;
    }

    public SchollClass gradeLevels(Set<GradeLevel> gradeLevels) {
        this.gradeLevels = gradeLevels;
        return this;
    }

    public SchollClass addGradeLevels(GradeLevel gradeLevel) {
        this.gradeLevels.add(gradeLevel);
        gradeLevel.getSchoolClasses().add(this);
        return this;
    }

    public SchollClass removeGradeLevels(GradeLevel gradeLevel) {
        this.gradeLevels.remove(gradeLevel);
        gradeLevel.getSchoolClasses().remove(this);
        return this;
    }

    public void setGradeLevels(Set<GradeLevel> gradeLevels) {
        this.gradeLevels = gradeLevels;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SchollClass)) {
            return false;
        }
        return id != null && id.equals(((SchollClass) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SchollClass{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
