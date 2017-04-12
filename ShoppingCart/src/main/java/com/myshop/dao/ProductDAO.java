package com.myshop.dao;

import com.myshop.entity.Product;
import com.myshop.model.PaginationResult;
import com.myshop.model.ProductInfo;

/**
 * @author Oleksandr Serogin
 */

public interface ProductDAO {

    public Product findProduct(String code);

    public ProductInfo findProductInfo(String code) ;

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage  );

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

    public void save(ProductInfo productInfo);

}
