package org.example.library.service;

import org.example.library.domain.Resource;
import org.example.library.domain.ResourcesGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceService implements ResourceServiceInterface {
    @Override
    public void writeResources() {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\48721\\IdeaProjects\\Library\\src\\main\\resources\\resources.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            ResourcesGenerator.generateResources();
            for (Resource resource : ResourcesGenerator.RESOURCE_REPO.getResources()) {
                oos.writeObject(resource);
                oos.flush();
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println(ioe.getMessage());
        }
    }

    @Override
    public void writeNewResources(List<Resource> resources) {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\48721\\IdeaProjects\\Library\\src\\main\\resources\\resources.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Resource resource : resources) {
                oos.writeObject(resource);
                oos.flush();
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println(ioe.getMessage());
        }
    }

    @Override
    public List<Resource> readResources() {
        List<Resource> resources = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\48721\\IdeaProjects\\Library\\src\\main\\resources\\resources.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Resource resource = (Resource) ois.readObject();
                    resources.add(resource);
                } catch (EOFException eofe) {
                    break;
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    System.err.println(cnfe.getMessage());
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println(ioe.getMessage());
        }
        return resources;
    }
}
