package org.example.library.db;

import lombok.Getter;
import org.example.library.domain.Resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ResourceRepo implements Serializable {
    private List<Resource> resources = new ArrayList<>();
}
