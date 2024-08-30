package org.example.library.service;

import org.example.library.db.UserRepo;
import org.example.library.domain.UserGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserService {

    public void writeUsers() {
        try (FileOutputStream fos = new FileOutputStream("users.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            UserGenerator.USER_REPO.getUsers().stream()
                    .forEach(u -> {
                        try {
                            oos.writeObject(u);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
