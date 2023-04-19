package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CategoryMapper;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	/**
	 * カテゴリー取得
	 *
	 * @return カテゴリー
	 */
	@Override
	public List<String> getCategories() {

		return categoryMapper.getCategories();
	}

}
