package com.kline.sds.service.impl;

import java.util.List;

import org.nutz.service.NameEntityService;

import com.kline.sds.entity.Payer;
import com.kline.sds.service.PayerService;

public class PayerServiceImpl extends NameEntityService<Payer> implements
		PayerService {

//	@Override
//	public void insertPayer(Payer payer) {
//		// TODO Auto-generated method stub
//		this.dao().insert(payer);
//	}
//
//	@Override
//	public Payer getPayerById(String payerCode) {
//		// TODO Auto-generated method stub
//		return this.fetch(payerCode);
//	}

	@Override
	public List<Payer> getAllPayers() {
		// TODO Auto-generated method stub
		return this.query(null, null);
	}

//	@Override
//	public void updatePayer(Payer Payer, String oldpayerCode) {
//		// TODO Auto-generated method stub
//
//	}

//	@Override
//	public void deletePayerById(String payerCode) {
//		// TODO Auto-generated method stub
//		this.delete(payerCode);
//	}
//
//	@Override
//	public void updatePayer(Payer payer) {
//		// TODO Auto-generated method stub
//		this.dao().update(payer);
//	}
}
