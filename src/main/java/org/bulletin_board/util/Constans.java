package org.bulletin_board.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Constans {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("misha");
}
