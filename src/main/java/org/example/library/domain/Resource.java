package org.example.library.domain;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public abstract class Resource implements Serializable {
    private String id;
}
