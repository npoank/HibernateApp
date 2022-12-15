package org.example;

import org.example.model.Item;
import org.example.model.Person;
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
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 3);
            List<Item> personItems = person.getItems();

            for(Item item : personItems){
                session.remove(item);
            }

            person.getItems().clear();

            System.out.println("//////////////////////////////////////////////");

            Person person1 = session.get(Person.class, 2);
            session.remove(person1);

            person1.getItems().forEach(i -> i.setOwner(null));

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
