package com.mutiny.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_CATEGORY", schema = "MUTINY")
public class UserCategory {

    private Integer id;

    private Account account;

    private Category category;

    public UserCategory() {
    }

    public UserCategory(Account account, Category category) {
        this.account = account;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    public Account getAccount() { return account; }

    public void setAccount(Account account) { this.account = account; }
}
