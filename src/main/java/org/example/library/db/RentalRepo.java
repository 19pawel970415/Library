package org.example.library.db;

import lombok.Getter;
import org.example.library.domain.Rental;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RentalRepo {
    private List<Rental> rentals = new ArrayList<>();

}
