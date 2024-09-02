package org.example.library.service;

import org.example.library.domain.Resource;

import java.util.List;

public interface ResourceServiceInterface {
    void writeResources();
    void writeNewResources(List<Resource> resources);
    List<Resource> readResources();
}
