package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HouseholdAccountBook;
import com.example.demo.service.CategoryService;
import com.example.demo.service.Recordservice;

@CrossOrigin
@RestController
public class RecordAnalysisController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	Recordservice recordservice;

	/**
	 * カテゴリー取得
	 * 
	 * @return カテゴリーリスト
	 */
	@GetMapping("/category")
	public List<String> getCategoryList() {
		System.out.println(categoryService.getCategories());
		return categoryService.getCategories();
	}

	/**
	 * 家計簿取得
	 * 
	 * @param sortフラグ(trueの時昇順、falseの時降順)
	 * @return 家計簿リスト
	 * 
	 */
	@GetMapping("/records")
	public List<HouseholdAccountBook> getRecordSortList(@RequestParam("categoryId") int categoryId,
			@RequestParam("startDating") String startDating, @RequestParam("endDating") String endDating,
			@RequestParam("sort") Boolean bool) {
		System.out.println(categoryId);
		System.out.println(startDating);
		System.out.println(endDating);
		System.out.println(bool);
		return recordservice.getRecords(bool, categoryId, startDating, endDating);
	}

	/**
	 * 家計簿登録
	 * 
	 * @param 家計簿情報
	 */
	@PostMapping("/record")
	public void createHouseholdAccountBook(@RequestBody HouseholdAccountBook householdAccountBook) {

		recordservice.createRecord(householdAccountBook);
	}

	/**
	 * 家計簿削除
	 * 
	 * @param 家計簿ID
	 */
	@PostMapping("/deleteRecord")
	public void deleteHouseholdAccountBook(@RequestBody HouseholdAccountBook householdAccountBook) {

		recordservice.deleteRecord(householdAccountBook);
		System.out.println(householdAccountBook);
	}

	/**
	 * 家計簿取得(編集用)
	 * 
	 * @return 家計簿
	 */
	@GetMapping("/record")
	public HouseholdAccountBook getHouseholdAccountBook(@RequestParam("Id") String Id) {

		return recordservice.getRecord(Id);
	}

}
