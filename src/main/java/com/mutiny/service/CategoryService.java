package com.mutiny.service;

import com.mutiny.dao.AccountRepository;
import com.mutiny.dao.UserCategoryRepository;
import com.mutiny.model.Account;
import com.mutiny.model.UserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mutiny.dao.CategoryRepository;
import com.mutiny.dto.CategoryDto;
import com.mutiny.model.Category;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserCategoryRepository userCategoryRepository;

	@Autowired
	AccountRepository accountRepository;

	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = categoryRepository.save(categoryDto.toEntity());
		return new CategoryDto().fromEntity(category);
	}

	public CategoryDto findCategoryByName(String name) {
		Category category = categoryRepository.findByNameIgnoreCase(name);
		return new CategoryDto().fromEntity(category);
	}

	public CategoryDto findCategory(Integer id) {
		Category category = categoryRepository.findOne(id);
		return new CategoryDto().fromEntity(category);
	}

	public List<UserCategory> setUserCategories(List<String> categories, long userId) {
		List<UserCategory> result = new ArrayList<UserCategory>();
		for (String cat : categories) {
			Integer accountId = new Integer(Math.toIntExact(userId));
			Account account = accountRepository.findOne(accountId);
			Category category = categoryRepository.findByNameIgnoreCase(cat);
			if (account!=null && category!=null) {
				UserCategory userCategory = new UserCategory(account, category);
				result.add(userCategory);
			} else {
				return new ArrayList<UserCategory>();
			}
		}
		for (UserCategory category : result) {
			userCategoryRepository.save(category);
		}
		return result;
	}

	public List<String> getUserCategories(long userId){
		List<String> result = new ArrayList<String>();
		Account account = accountRepository.findOne(Math.toIntExact(userId));
		if (account == null) {
			return null;
		} else {
			List<UserCategory> userCategories = userCategoryRepository.findByAccount(account);
			for (UserCategory userCategory : userCategories) {
				result.add(userCategory.getCategory().getName());
			}
			return result;
		}
	}
}
