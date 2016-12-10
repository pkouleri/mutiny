package com.mutiny.dao;

import com.mutiny.model.Account;
import com.mutiny.model.Post;
import com.mutiny.model.UserCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCategoryRepository extends CrudRepository<UserCategory, Integer> {

    public List<UserCategory> findByAccount(Account account);

}
