package com.atguigu.mall.sale.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.sale.beans.MallAddress;
import com.atguigu.mall.sale.mapper.AddressMapper;
import com.atguigu.mall.sale.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressMapper addressMapper;

	@Override
	public MallAddress queryAddressById(int address_id) {
		
		return addressMapper.queryAddressById(address_id);
	}

}
