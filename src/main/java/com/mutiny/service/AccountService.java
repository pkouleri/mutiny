package com.mutiny.service;

import com.mutiny.dao.CategoryRepository;
import com.mutiny.dao.PostRepository;
import com.mutiny.dao.UserCategoryRepository;
import com.mutiny.dto.AbstractPostDto;
import com.mutiny.model.Category;
import com.mutiny.model.Post;
import com.mutiny.model.UserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mutiny.dao.AccountRepository;
import com.mutiny.dto.AccountDto;
import com.mutiny.model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * User management methods (CRUD, etc)
 */
@Component
public class AccountService extends AbstractService {

	public static void main() {

	}

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserCategoryRepository userCategoryRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PostService postService;


	public AccountDto getAccount(Integer id) {
		Account account = accountRepository.findOne(id);
		return new AccountDto().fromEntity(account);
	}

	public AccountDto createAccount(AccountDto accountDto) {
		Account account = accountRepository.save(accountDto.toEntity(accountDto));
		return new AccountDto().fromEntity(account);
	}
	
	public AccountDto findByPrincipal(String principal){
		Account account = accountRepository.findByPrincipal(principal);
		if(account!=null)
			return new AccountDto().fromEntity(account);
		else return null;
	}

	public List<AbstractPostDto> getAccountPosts(Integer userId) {
		Account userAccount = accountRepository.findOne(userId);
		if (userAccount == null) {
			return null;
		}
		List<UserCategory> userCategories = userCategoryRepository.findByAccount(userAccount);
		if (userCategories == null) {
			return postService.getPosts(new ArrayList<String>());
		} else {
			return postService.getUserPosts(userAccount, userCategories);
		}
	}

}
