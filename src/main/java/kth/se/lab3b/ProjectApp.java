package kth.se.lab3b;

import kth.se.lab3b.model.Project;
import kth.se.lab3b.model.ProjectsManager;
import kth.se.lab3b.model.exceptions.TitileNotUniqueException;
import kth.se.lab3b.ui.MainUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ProjectApp {

    private static final String FILE_NAME = "projects.ser";

    public void run() throws TitileNotUniqueException { // we do not catch all exceptions

        File projectsFile = new File(FILE_NAME);
        ProjectsManager projectsManager = new ProjectsManager();
        boolean couldReadFile = false;

        MainUI ui = new MainUI(projectsManager);
        ui.mainLoop();
    }

    public static void main(String[] args) throws TitileNotUniqueException {

        ProjectApp app = new ProjectApp();
        app.run();
    }
}
