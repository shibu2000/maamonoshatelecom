package com.maamonoshatelecom.service.serviceImpl;

import java.util.ArrayList;
import java.util.Base64;
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
import com.maamonoshatelecom.Response.ProductResponse;
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

		if (productModel.getProductImageFile() != null) {
			// Converting Base64 format to Byte Array[]
			productEntity.setProductImageFile(Base64.getDecoder().decode(productModel.getProductImageFile()));
			productEntity.setProductImageName(productModel.getProductImageName());
		}
		Optional<CategoryEntity> findById = this.categoryRepo.findById(productModel.getCategoryId());
		if (findById.isPresent()) {
			productEntity.setCategoryEntity(findById.get());
			ProductEntity save = this.productRepo.save(productEntity);
			if (save != null) {
				return new ResponseEntity<String>("Data Inserted", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<String>("Category Not Found", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<?> getProduct() {
		List<ProductEntity> findAll = this.productRepo.findAll();
		
		List<ProductResponse> productList = new ArrayList<ProductResponse>();
		
		findAll.forEach(product -> {
			ProductResponse productResponse = new ProductResponse();
			productResponse.setId(product.getId());
			productResponse.setProductName(product.getProductName());
			productResponse.setProductPrice(product.getProductPrice());
			productResponse.setProductDesc(product.getProductDesc());

			if (product.getProductImageFile() != null) {
				// Converting Byte Array[] to Base64 format
				productResponse.setProductImageFile(Base64.getEncoder().encodeToString(product.getProductImageFile()));
				productResponse.setProductImageName(product.getProductImageName());
			}

			productList.add(productResponse);
		});

		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteProduct(int id) {
		try {
			this.productRepo.deleteById(id);
			return new ResponseEntity<String>("Product Removed", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Database Error", HttpStatus.BAD_REQUEST);
		}
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

				if (productModel.getProductImageFile() != null) {
					// Converting Base64 format to Byte Array[]
					productEntity.setProductImageFile(Base64.getDecoder().decode(productModel.getProductImageFile()));
					productEntity.setProductImageName(productModel.getProductImageName());
				}

				productEntity.setCategoryEntity(checkCategory.get());

				ProductEntity save = this.productRepo.save(productEntity);

				productModel.setProductName(save.getProductName());
				productModel.setProductPrice(save.getProductPrice());
				productModel.setProductDesc(save.getProductDesc());
				productModel.setCategoryId(save.getCategoryEntity().getId());

				return new ResponseEntity<ProductModel>(productModel, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<String>("Product Not Found", HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<String>("Category Not Found", HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<?> getProductByCatId(int id) {
		Optional<CategoryEntity> findById = this.categoryRepo.findById(id);
		if (findById.isPresent()) {
			Optional<List<ProductEntity>> findBycategoryEntity = this.productRepo.findBycategoryEntity(findById.get());

			List<ProductResponse> productResponses = new ArrayList<>();

			if (findBycategoryEntity.isPresent()) {
				findBycategoryEntity.get().forEach(product -> {
					ProductResponse productResponse = new ProductResponse();
					productResponse.setId(product.getId());
					productResponse.setProductName(product.getProductName());
					productResponse.setProductPrice(product.getProductPrice());
					productResponse.setProductDesc(product.getProductDesc());

					if (product.getProductImageFile() != null) {
						// Converting Byte Array[] to Base64 file format
						productResponse
								.setProductImageFile(Base64.getEncoder().encodeToString(product.getProductImageFile()));
						productResponse.setProductImageName(product.getProductImageName());
					}

					productResponses.add(productResponse);
				});
				return ResponseEntity.ok(productResponses);
			} else {
				return ResponseEntity.status(HttpStatus.OK).body("No Product Found");
			}
		} else {
			return ResponseEntity.ok("Category Not Found");
		}
	}

}
