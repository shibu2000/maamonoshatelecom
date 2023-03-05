package com.maamonoshatelecom.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.CategoryEntity;
import com.maamonoshatelecom.Entity.ProductEntity;
import com.maamonoshatelecom.Repo.CategoryRepo;
import com.maamonoshatelecom.Repo.ProductRepo;
import com.maamonoshatelecom.model.ProductModel;
import com.maamonoshatelecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public ResponseEntity<?> saveProduct(ProductModel productModel) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductName(productModel.getProductName());
		productEntity.setProductPrice(productModel.getProductPrice());
		productEntity.setProductDesc(productModel.getProductDesc());

		Optional<CategoryEntity> findById = this.categoryRepo.findById(productModel.getCategoryId());
		if (findById.isPresent()) {
			productEntity.setCategoryEntity(findById.get());
			ProductEntity save = this.productRepo.save(productEntity);
			return new ResponseEntity<ProductEntity>(save, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<List<ProductModel>> getProduct() {
		List<ProductEntity> findAll = this.productRepo.findAll();
		List<ProductModel> productList = new ArrayList<ProductModel>();
		findAll.forEach(product -> {
			ProductModel productModel = new ProductModel();
			productModel.setId(product.getId());
			productModel.setProductName(product.getProductName());
			productModel.setProductPrice(product.getProductPrice());
			productModel.setProductDesc(product.getProductDesc());
			productModel.setCategoryId(product.getCategoryEntity().getId());
			productModel.setCategoryname(product.getCategoryEntity().getCategoryname());
			productList.add(productModel);
		});

		return new ResponseEntity<List<ProductModel>>(productList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> putProduct(int id, ProductModel productModel) {
		Optional<CategoryEntity> checkCategory = this.categoryRepo.findById(productModel.getCategoryId());
		if (checkCategory.isPresent()) {
			Optional<ProductEntity> findById = this.productRepo.findById(id);
			if (findById.isPresent()) {
				ProductEntity productEntity = new ProductEntity();
				productEntity.setId(id);
				productEntity.setProductName(productModel.getProductName());
				productEntity.setProductPrice(productModel.getProductPrice());
				productEntity.setProductDesc(productModel.getProductDesc());

				productEntity.setCategoryEntity(checkCategory.get());

				ProductEntity save = this.productRepo.save(productEntity);

				productModel.setId(save.getId());
				productModel.setProductName(save.getProductName());
				productModel.setProductPrice(save.getProductPrice());
				productModel.setProductDesc(save.getProductDesc());
				productModel.setCategoryId(save.getCategoryEntity().getId());
				productModel.setCategoryname(save.getCategoryEntity().getCategoryname());

				return new ResponseEntity<ProductModel>(productModel, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<String>("Product Not Found", HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<String>("Category Not Found", HttpStatus.NOT_FOUND);
		}

	}

}
