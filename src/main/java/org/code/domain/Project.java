package org.code.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
@Data
@ToString
public class Project {
    String projectId;
    List<Ac> acList;
    Integer value;

    public Project() {
    }

    public Project(String projectId, List<Ac> acList) {
        this.projectId = projectId;
        this.acList = acList;
        this.value = acList.stream().map(Ac::getValue).reduce(0, Integer::sum);
    }

    public Project(String projectId, List<Ac> acList, Integer value) {
        this.projectId = projectId;
        this.acList = acList;
        this.value = value;
    }

}
