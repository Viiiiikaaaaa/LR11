package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DBDemo {
    private static SessionFactory factory;

    public static void prepareData() {
        factory = new Configuration()
                .configure("C:\\Users\\vikah\\IdeaProjects\\demo (6)\\demo\\src\\main\\resources\\configs\\hibernate.cfg.xml")
                .buildSessionFactory();

        Session session;

        try {
            String sqlString = Files.lines(Paths.get("C:\\Users\\vikah\\IdeaProjects\\demo (6)\\demo\\init.sql"))
                    .collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sqlString).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        prepareData();
        readFromDB();
        updateInDb();
        deleteFromDb();
        addInDb();
        factory.close();
    }

    private static void addInDb() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Film film = new Film("Форрест Гамп", "Мир уже никогда не будет прежним, после того как вы увидите его глазами Форреста Гампа");
            session.save(film);
            session.getTransaction().commit();
        }
    }

    private static void deleteFromDb() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Film film = session.get(Film.class, 1);
            session.getTransaction().commit();
            session.delete(film);
        }
    }

    private static void updateInDb() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Film film = session.get(Film.class, 3);
            film.setSlogan("Увидевший его побежит домой");

            session.getTransaction().commit();
            System.out.println(film.getSlogan());
        }
    }

    private static void readFromDB() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Film film = session.get(Film.class, 1);
            System.out.println();
            System.out.println("Фильм 1: " + film.toString() + "\n");
            System.out.println("Доп. информация о фильме 1: " + film.getInfo() + "\n");
            System.out.println("Жанр фильма 1: " + film.getGener() + "\n");
            System.out.println("Группы преподавателя №1: " + film.getGroups() + "/n");
            session.getTransaction().commit();


        }

    }
}