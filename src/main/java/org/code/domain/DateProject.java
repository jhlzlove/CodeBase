package org.code.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
@Data
@ToString
public class DateProject {
    Date date;
    List<Project> projectList;

    public DateProject() {
    }

    public DateProject(Date date, List<Project> projectList) {
        this.date = date;
        this.projectList = projectList;
    }
}
