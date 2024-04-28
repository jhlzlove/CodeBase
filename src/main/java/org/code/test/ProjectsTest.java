package org.code.test;

import org.code.domain.Ac;
import org.code.domain.DateProject;
import org.code.domain.Project;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jhlz
 * @version x.x.x
 */
public class ProjectsTest {
    public static void main(String[] args) {
        List<Ac> list1 = Arrays.asList(
                new Ac("AC001", 20),
                new Ac("AC002", 15)
        );
        Project project1 = new Project("PN-001", list1);
        List<Ac> list2 = Arrays.asList(
                new Ac("AC001", 20),
                new Ac("AC002", 15)
        );
        Project project2 = new Project("PN-003", list2);
        List<Ac> list3 = Collections.singletonList(
                new Ac("AC001", 30)
        );
        Project project3 = new Project("PN-004", list3);

        List<Project> projectList = Arrays.asList(project1, project2, project3);
        System.out.println(projectList);
        // 输入
        DateProject dateProject = new DateProject(new Date("2024/1/1"), projectList);
        // 转换输出

        List<Project> pList = new ArrayList<>();

        for (Project project : projectList) {
            // id
            String projectId = project.getProjectId();
            // 子元素
            List<Ac> acs = project.getAcList();
            List<Ac> temp = new ArrayList<>();
            int sum = 0;
            String tName = null;
            for (Ac it : acs) {
                Ac ac = new Ac(projectId, it.getValue());
                sum += it.getValue();
                temp.add(ac);
                tName = it.getName();
            }
            Project p = new Project();
            p.setProjectId(tName);
            p.setValue(sum);
            p.setAcList(temp);
            pList.add(p);

        }
        Map<String, List<Project>> collect = pList.stream().collect(Collectors.groupingBy(Project::getProjectId));
        List<Project> result = new ArrayList<>();
        collect.forEach((key, value) -> {
            int sum = 0;
            List<Ac> temp = new ArrayList<>();
            for (Project project : value) {
                Integer v = project.getValue();
                sum += v;
                temp.addAll(project.getAcList());
            }
            Project project = new Project(key, temp, sum);
            result.add(project);
        });
        System.out.println(result);
        DateProject res = new DateProject(new Date("2024/1/1"), result);
        System.out.println(res);

    }
}
