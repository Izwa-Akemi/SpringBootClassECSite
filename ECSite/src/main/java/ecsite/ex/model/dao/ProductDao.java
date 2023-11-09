package ecsite.ex.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecsite.ex.model.entity.ProductEntity;
import jakarta.transaction.Transactional;
@Transactional
public interface ProductDao extends JpaRepository<ProductEntity, Long> {
	ProductEntity save(ProductEntity productEntity);
	List<ProductEntity>findAll();
	ProductEntity findByProductId(Long productId);
	ProductEntity findByProductName(String productName);
	int deleteByProductId(Long productId);
}
