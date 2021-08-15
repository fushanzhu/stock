package com.stock.cn.servive.imp;

import com.stock.cn.entity.StockEntity;
import com.stock.cn.mapper.StockMapper;
import com.stock.cn.servive.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockServiceImp implements StockService {
    @Autowired
    private StockMapper stockMapper;
    @Override
    public void addStock(StockEntity stockEntity) {
        stockMapper.insert(stockEntity);

    }
}
