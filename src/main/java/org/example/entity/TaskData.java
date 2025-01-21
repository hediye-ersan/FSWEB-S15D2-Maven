package org.example.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }
    public Set<Task> getTasks(String assignee) {
        if (assignee == null) return Collections.emptySet();

        Set<Task> resultSet = new HashSet<>();

        switch (assignee.toLowerCase()) {
            case "ann":
                resultSet.addAll(annsTasks);
                break;
            case "bob":
                resultSet.addAll(bobsTasks);
                break;
            case "carol":
                resultSet.addAll(carolsTasks);
                break;
            case "all":
                resultSet.addAll(annsTasks);
                resultSet.addAll(bobsTasks);
                resultSet.addAll(carolsTasks);
                resultSet.addAll(unassignedTasks);
                break;
            default:
                return Collections.emptySet();
        }

        return resultSet;
    }

    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        Set<Task> unionSet = new HashSet<>();
        unionSet.addAll(set1);
        unionSet.addAll(set2);

        return unionSet;
    }


    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2){
        Set<Task> set1Copy = new HashSet<>(set1);
        set1Copy.retainAll(set2);
        return set1Copy;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2){
        set1.removeAll(set2);
        return set1;
    }


}
