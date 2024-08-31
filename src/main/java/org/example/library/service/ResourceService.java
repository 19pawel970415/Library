package org.example.library.service;

import org.example.library.domain.Resource;
import org.example.library.domain.ResourcesGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ResourceService implements ResourceServiceInterface {
    @Override
    public void writeResources() {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\48721\\IdeaProjects\\Library\\src\\main\\resources\\resources.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            ResourcesGenerator.generateResources();
            for (Resource resource : ResourcesGenerator.RESOURCE_REPO.getResources()) {
                oos.writeObject(resource);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println(ioe.getMessage());
        }
    }
}
