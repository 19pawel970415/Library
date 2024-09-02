package org.example.library.service;import org.example.library.domain.User;import org.example.library.domain.UserGenerator;import java.io.*;import java.util.ArrayList;import java.util.List;public class UserService implements UserServiceInterface {    @Override    public void writeUsers() {        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\48721\\IdeaProjects\\Library\\src\\main\\resources\\users.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {            UserGenerator.generateUsers();            for (User user : UserGenerator.USER_REPO.getUsers()) {                oos.writeObject(user);                oos.flush();            }        } catch (FileNotFoundException fnfe) {            fnfe.printStackTrace();            System.err.println(fnfe.getMessage());        } catch (IOException ioe) {            ioe.printStackTrace();            System.err.println(ioe.getMessage());        }    }    @Override    public void writeNewUsers(List<User> users) {        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\48721\\IdeaProjects\\Library\\src\\main\\resources\\users.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {            for (User user : users) {                oos.writeObject(user);            }        } catch (FileNotFoundException fnfe) {            fnfe.printStackTrace();            System.err.println(fnfe.getMessage());        } catch (IOException ioe) {            ioe.printStackTrace();            System.err.println(ioe.getMessage());        }    }    @Override    public List<User> readUsers() {        List<User> users = new ArrayList<>();        try (FileInputStream fis = new FileInputStream("C:\\Users\\48721\\IdeaProjects\\Library\\src\\main\\resources\\users.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {            while (true) {                try {                    User user = (User) ois.readObject();                    users.add(user);                } catch (EOFException eofe) {                    break;                } catch (ClassNotFoundException cnfe) {                    cnfe.printStackTrace();                    System.err.println(cnfe.getMessage());                }            }        } catch (IOException ioe) {            ioe.printStackTrace();            System.err.println(ioe.getMessage());        }        return users;    }}