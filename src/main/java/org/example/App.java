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

            Person person = session.get(Person.class, 2);
            Item newItem = new Item("Test item", person);

            person.getItems().add(newItem);

            session.save(newItem);

            System.out.println("///////////////////////////");

            Person testPerson = new Person("TestPerson", 30);
            Item testItem = new Item("Item for TestPerson", testPerson);

            testPerson.setItems(new ArrayList<>(Collections.singletonList(testItem)));

            session.save(testPerson);
            session.save(testItem);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
