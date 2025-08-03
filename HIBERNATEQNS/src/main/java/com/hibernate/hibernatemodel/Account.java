package com.itemcrud.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "holder_name")
    private String holderName;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {}

    public Account(String holderName) {
        this.holderName = holderName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }

    public void addTransaction(Transaction tx) {
        tx.setAccount(this);
        this.transactions.add(tx);
    }

    public void removeTransaction(Transaction tx) {
        tx.setAccount(null);
        this.transactions.remove(tx);
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", holderName=" + holderName + "]";
    }
}
