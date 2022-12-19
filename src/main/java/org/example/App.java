package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;
import org.example.model.Personality;
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
        Configuration configuration = new Configuration().addAnnotatedClass(Personality.class).
                addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Personality personality = new Personality("Test personality", 35);
            Passport passport = new Passport(123456);

            personality.setPassport(passport);

            session.save(personality);

            System.out.println("/////////////////////////////////////////////");

            Personality personality1 = session.get(Personality.class, 1);
            System.out.println(personality1.getPassport().getPassportNumber());

            System.out.println("////////////////////////////////////////////");

            Passport passport1 = session.get(Passport.class, 1);
            System.out.println(passport1.getPersonality().getName());

            System.out.println("////////////////////////////////////////////");

            Personality personality2 = session.get(Personality.class, 1);
            personality2.getPassport().setPassportNumber(654321);

            System.out.println("////////////////////////////////////////////");

            Personality personality3 = session.get(Personality.class, 2);
            session.remove(personality3);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
