package ecsite.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecsite.ex.model.dao.ProductDao;
import ecsite.ex.model.entity.ProductEntity;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public List<ProductEntity> selectAll(Long adminId) {
		if(adminId== null) {
			return null;
		}else {
			return productDao.findAll();
		}
	}
	public boolean createProduct(String productName, String productCategory, String productImage, String productDescription) {		
		ProductEntity productList = productDao.findByProductName(productName);
		if(productList == null) {
			productDao.save(new ProductEntity(productName,productCategory,productImage,productDescription));
			return true;
		}else {
			return false;
		}
	}
	
	public ProductEntity getProductPost(Long productId) {
		if(productId == null) {
			return null;
		}else {
			return productDao.findByProductId(productId);
		}
	}
	
	public boolean editProduct(Long productId,String productName, String productCategory, String productImage, String productDescription) {		
		
		if(productId == null) {
			return false;
		}else {
			productDao.save(new ProductEntity(productId,productName,productName,productImage,productDescription));
			return true;
		}
	}
	
	public boolean deleteProduct(Long productId) {
		if(productId == null) {
			return false;
		}else {
			productDao.deleteByProductId(productId);
			return true;
		}
	}
}
