package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.HouseholdAccountBook;

@Mapper
public interface RecordAnalysisMapper {

	// 家計簿リスト取得
	public List<HouseholdAccountBook> getRecords(Boolean bool, int categoryId, String startDating, String endDating);

	// 家計簿登録
	public void createRecord(HouseholdAccountBook householdAccountBook);

	// 家計簿削除
	public void deleteRecord(HouseholdAccountBook householdAccountBook);

	// 家計簿取得
	public HouseholdAccountBook getRecord(String Id);

	// 当月の家計簿取得
	public List<HouseholdAccountBook> getCurrentRecords();
}
