package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HouseholdAccountBook;

public interface Recordservice {

	/**
	 * 家計簿取得
	 * 
	 * @return 家計簿リスト
	 */
	public List<HouseholdAccountBook> getRecords(Boolean bool, int categoryId, String startDating, String endDating);

	/**
	 * 家計簿登録
	 * 
	 * @param 家計簿情報
	 */
	public void createRecord(HouseholdAccountBook householdAccountBook);

	/**
	 * 家計簿削除
	 * 
	 * @param 家計簿ID
	 */
	public void deleteRecord(HouseholdAccountBook householdAccountBook);

	/**
	 * 家計簿取得
	 * 
	 * @param Id
	 */
	public HouseholdAccountBook getRecord(String Id);

}
