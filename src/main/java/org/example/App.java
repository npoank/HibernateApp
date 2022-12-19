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
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).
                addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Movie movie = new Movie("Film1", 1994);
//            Actor actor1 = new Actor("Actor1", 36);
//            Actor actor2 = new Actor("Actor2", 40);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);

//            System.out.println("///////////////////////////////////////////////////////////");
//
//            Movie movie1 = session.get(Movie.class, 1);
//            System.out.println(movie1.getActors());
//
//            System.out.println("///////////////////////////////////////////////////////////");
//
//            Movie movie2 = new Movie("Film2", 2000);
//            Actor actor3 = session.get(Actor.class, 2);
//
//            movie2.setActors(new ArrayList<>(Collections.singletonList(actor3)));
//            actor3.getMovies().add(movie2);
//
//            session.save(movie2);

            System.out.println("///////////////////////////////////////////////////////////");

            Actor actor4 = session.get(Actor.class, 2);
            System.out.println(actor4.getMovies());

            Movie movie4 = actor4.getMovies().get(0);

            actor4.getMovies().remove(0);
            movie4.getActors().remove(actor4);

            session.getTransaction().commit();

        }

    }
}
