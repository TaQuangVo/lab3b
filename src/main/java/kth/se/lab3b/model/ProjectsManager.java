package kth.se.lab3b.model;

import kth.se.lab3b.model.Project;
import kth.se.lab3b.model.exceptions.TitileNotUniqueException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private List<Project> projects;

    public ProjectsManager(){
        projects = new ArrayList<>();
        nextProjectId = 0;
    }

    public void setProject(List<Project> incomingProjects){
        projects.addAll(incomingProjects);

        nextProjectId = getHighestId() + 1;
    }

    public boolean isTitleUnique(String title){
        for(Project project : projects)
            if(project.getTitle().equals(title))
                return false;
        return true;
    }

    public Project addProject(String title, String description) throws TitileNotUniqueException {
        if(!isTitleUnique(title))
            throw new TitileNotUniqueException("Project title not unique");

        Project newProject = new Project(title,description, nextProjectId++);
        projects.add(newProject);

        return newProject;
    }

    public Project removeProject(Project projectToRemove){
        for(Project project : projects)
            if(project == projectToRemove){
                projects.remove(projectToRemove);
                return projectToRemove;
            }
        return null;
    }

    public Project getProjectById(int id){
        for(Project project : projects)
            if(project.getId() == id){
                return project;
            }
        return null;
    }

    public List<Project> findProjects(String title){
        List<Project> matches = new ArrayList<>();
        for(Project project : projects)
            if(project.getTitle().contains(title))
                matches.add(project);

        return matches;
    }

    public int getHighestId(){
        int highestId = 0;
        for(Project project : projects)
            if(project.getId() > highestId)
                highestId = project.getId();
        return highestId;
    }
}
