package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HouseholdAccountBook;
import com.example.demo.repository.RecordAnalysisMapper;

@Service
public class RecordServiceImp implements Recordservice {

	@Autowired
	RecordAnalysisMapper recordAnalysisMapper;

	/**
	 * 家計簿取得
	 * 
	 * @param カテゴリーID
	 * @param 開始日
	 * @param 終了日
	 * @return 家計簿リスト
	 */
	@Override
	public List<HouseholdAccountBook> getRecords(int categoryId, String startDating, String endDating) {

		return recordAnalysisMapper.getRecords(categoryId, startDating, endDating);
	}

	/**
	 * 家計簿登録
	 * 
	 * @param 家計簿情報
	 */
	@Override
	public void createRecord(HouseholdAccountBook householdAccountBook) {

		recordAnalysisMapper.createRecord(householdAccountBook);
	}

	/**
	 * 家計簿削除
	 * 
	 * @param 家計簿ID
	 */
	@Override
	public void deleteRecord(HouseholdAccountBook householdAccountBook) {

		recordAnalysisMapper.deleteRecord(householdAccountBook);

	}

	/**
	 * 家計簿取得
	 * 
	 * @param Id
	 */
	@Override
	public HouseholdAccountBook getRecord(String Id) {

		return recordAnalysisMapper.getRecord(Id);
	}

	/**
	 * 家計簿取得
	 * 
	 * @return 家計簿リスト
	 */
	@Override
	public List<HouseholdAccountBook> getCurrentRecords(String beginningMoth, String endMonth) {

		return recordAnalysisMapper.getCurrentRecords(beginningMoth, endMonth);
	}

}
