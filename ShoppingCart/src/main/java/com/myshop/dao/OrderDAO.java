package com.myshop.dao;

import com.myshop.model.CartInfo;
import com.myshop.model.OrderDetailInfo;
import com.myshop.model.OrderInfo;
import com.myshop.model.PaginationResult;

import java.util.List;

/**
 * @author Oleksandr Serogin
 */

public interface OrderDAO {

    public void saveOrder(CartInfo cartInfo);

    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

    public OrderInfo getOrderInfo(String orderId);

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}