package com.atguigu.mall.sale.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.sale.beans.DetailMallSku;
import com.atguigu.mall.sale.beans.MallSkuAttrValue;
import com.atguigu.mall.sale.beans.ObjectMallSku;
import com.atguigu.mall.sale.mapper.SearchMapper;
import com.atguigu.mall.sale.service.SearchService;
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchMapper searchMapper;
	
	@Override
	public List<ObjectMallSku> queryProductInfoByClass_2_id(int class_2_id) {
		List<ObjectMallSku> productInfo = searchMapper.queryProductInfoByClass_2_id(class_2_id);
		return productInfo;
	}

	@Override
	public List<ObjectMallSku> queryProductByCondition(String order,int class_2_id, List<MallSkuAttrValue> listSku) {
		Map<String,Object> map = new HashMap<String,Object>();
		StringBuffer sql = new StringBuffer("");
		
		if(listSku!=null && listSku.size()>0){
			sql.append(" and sku.id in ");
			sql.append(" (select sku_0.sku_id from ");
			for (int i = 0; i < listSku.size(); i++) {
				sql.append(" (select sku_id from t_mall_sku_attr_value where shxm_id = " + listSku.get(i).getShxmId()
						+ " and shxzh_id = " + listSku.get(i).getShxzhId() + ") sku_" + i + " ");

				if (i < (listSku.size() - 1)) {
					sql.append(" , ");
				}
			}
			if (listSku.size() > 1) {
				sql.append(" where ");
				for (int i = 0; i < (listSku.size() - 1); i++) {
					sql.append(" sku_" + i + ".sku_id = sku_" + (i + 1) + ".sku_id ");
					if (listSku.size() > 2 && i < (listSku.size() - 2)) {
						sql.append(" and ");
					}
				}
			}

			sql.append(" ) ");
		}
		
		map.put("class_2_id", class_2_id);
		map.put("sql", sql);
		if(StringUtils.isNotBlank(order)){
			map.put("order", order);
		}
		List<ObjectMallSku> list_sku = searchMapper.queryProductByCondition(map);
		return list_sku;
	}

	@Override
	public List<ObjectMallSku> queryProductDetails(int spuId) {
		List<ObjectMallSku> objectMallSku = searchMapper.queryProductDetails(spuId);
		return objectMallSku;
	}

	@Override
	public DetailMallSku querySkuDetailsBySkuId(int skuId) {
		DetailMallSku skuDetails = searchMapper.querySkuDetailsBySkuId(skuId);
		return skuDetails;
	}

	

}
