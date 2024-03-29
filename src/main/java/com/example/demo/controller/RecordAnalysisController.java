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
import com.example.demo.service.CommonService;
import com.example.demo.service.Recordservice;

@CrossOrigin
@RestController
public class RecordAnalysisController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	Recordservice recordservice;

	@Autowired
	CommonService commonService;

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
	 * @param カテゴリーID
	 * @param 開始日
	 * @param 終了日
	 * @return 家計簿リスト
	 * 
	 */
	@GetMapping("/records")
	public List<HouseholdAccountBook> getRecordsList(@RequestParam("categoryId") int categoryId,
			@RequestParam("startDating") String startDating, @RequestParam("endDating") String endDating) {

		return recordservice.getRecords(categoryId, startDating, endDating);
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

	/**
	 * 当月の家計簿取得
	 * 
	 * @return 当月の家計簿リスト
	 * 
	 */
	@GetMapping("/current-records")
	public int[] getCurrentRecords() {

		// 月初・月末取得
		String beginningMoth = commonService.getBeginningMoth();
		String endMonth = commonService.getEndMoth();

		// 該当する家計簿を取得する
		List<HouseholdAccountBook> currentRecords = recordservice.getCurrentRecords(beginningMoth, endMonth);

		int[] totalAmounts = new int[10];

		// 配列にcategoryId順で合算した金額を格納
		for (HouseholdAccountBook householdAccountBook : currentRecords) {
			totalAmounts[householdAccountBook.getCategoryId() - 1] = householdAccountBook.getAmountOfMoney();
		}

		return totalAmounts;
	}

}
