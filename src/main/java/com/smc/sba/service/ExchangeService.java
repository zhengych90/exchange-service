package com.smc.sba.service;

import com.smc.sba.entity.StockExchangeEntity;
import com.smc.sba.repository.ExchangeRepository;
import com.smc.sba.utils.CommonResult;
import com.smc.sba.utils.ResponseCode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ExchangeService
 * @Description TODO
 * @Author YuChaoZheng
 * @Date 12/4/2019 15:40 AM
 * @Version 1.0
 **/
@Service
public class ExchangeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExchangeRepository exchangeRepository;

	/**
	 * Description: query all exchange.
	 *
	 * @param:
	 * @return: com.smc.sba.utils.CommonResult
	 * @auther: Yuchaozh
	 * @date: 2019/12/04 10:39
	 */
	public CommonResult save(StockExchangeEntity stockExchange) {
		try {
			exchangeRepository.save(stockExchange);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!");
		} catch (Exception e) {
			logger.error("Fail to create exchange data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	/**
	 * Description: update StockExchange detail
	 *
	 * @param:
	 * @return: com.smc.sba.utils.CommonResult
	 * @auther: Yuchaozh
	 * @date: 2019/12/04 10:39
	 */
	public CommonResult updateStockExchange(StockExchangeEntity stcokExchange) {
		try {
			StockExchangeEntity oldExchange = exchangeRepository.findById(stcokExchange.getExchangeid())
					.get();
			oldExchange.setAddress(stcokExchange.getAddress());
			oldExchange.setBrief(stcokExchange.getBrief());
			oldExchange.setRemarks(stcokExchange.getRemarks());
			oldExchange.setStockExchange(stcokExchange.getStockExchange());
			exchangeRepository.save(oldExchange);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!");
		} catch (Exception e) {
			logger.error("Fail to update exchange data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

}
