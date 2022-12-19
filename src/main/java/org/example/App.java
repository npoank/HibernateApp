package org.example;

import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // lazy loading by default
            //Person person = session.get(Person.class, 1);
            //System.out.println("Get a person");
            // Get related with person entity
            //System.out.println(person.getItems());

            System.out.println("///////////////////////////////////////");

            // eager loading by default
            Item item = session.get(Item.class, 1);
            System.out.println("Get an item");
            System.out.println(item.getOwner());

            session.getTransaction().commit();

        }

    }
}
