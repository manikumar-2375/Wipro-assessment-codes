package com.itemcrud.dao;

import com.itemcrud.model.Account;
import com.itemcrud.model.Transaction;
import com.itemcrud.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AccountDAO {

    public void createAccountWithTransaction(String holderName, String desc, double amount) {
        org.hibernate.Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Account acc = new Account(holderName);
            Transaction transaction = new Transaction(desc, amount);
            acc.addTransaction(transaction);

            session.save(acc);
            tx.commit();
            System.out.println("Account with transaction added.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Account> getAllAccounts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Account", Account.class).list();
        }
    }

    public Account getAccountById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Account.class, id);
        }
    }

    public void deleteAccount(int id) {
        org.hibernate.Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Account acc = session.get(Account.class, id);
            if (acc != null) {
                session.delete(acc);
                System.out.println("Account deleted.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
