package com.example.basicmatchshopping.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;

import com.example.basicmatchshopping.dto.CategoryDTO;
import com.example.basicmatchshopping.dto.OrderDTO;
import com.example.basicmatchshopping.dto.ProductDTO;
import com.example.basicmatchshopping.dto.ShoppingCartDTO;
import com.example.basicmatchshopping.dto.ShoppingCartItemDTO;
import com.example.basicmatchshopping.dto.SubProductDTO;
import com.example.basicmatchshopping.dto.UserDTO;
import com.example.basicmatchshopping.entity.Category;
import com.example.basicmatchshopping.entity.Order;
import com.example.basicmatchshopping.entity.Product;
import com.example.basicmatchshopping.entity.ShoppingCart;
import com.example.basicmatchshopping.entity.ShoppingCartItem;
import com.example.basicmatchshopping.entity.SubProduct;
import com.example.basicmatchshopping.entity.User;

public class MapperUtil {

	private static ModelMapper modelMapper = new ModelMapper();

	public static Category convertToCategory(CategoryDTO categoryDTO) {
		return modelMapper.map(categoryDTO, Category.class);
	}

	public static Order convertToOrder(OrderDTO orderDTO) {
		return modelMapper.map(orderDTO, Order.class);
	}

	public static Product convertToProduct(ProductDTO productDTO) {
		return modelMapper.map(productDTO, Product.class);
	}

	public static ShoppingCart convertToShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		return modelMapper.map(shoppingCartDTO, ShoppingCart.class);
	}

	public static ShoppingCartItem convertToShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO) {
		return modelMapper.map(shoppingCartItemDTO, ShoppingCartItem.class);
	}

	public static SubProduct convertToSubProduct(SubProductDTO subProductDTO) {
		return modelMapper.map(subProductDTO, SubProduct.class);
	}

	public static User convertToUser(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}

	public static CategoryDTO convertToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}

	public static OrderDTO convertToOrderDTO(Order order) {
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		orderDTO.setShoppingCartDTO(convertToShoppingCartDTO(order.getShoppingCart()));
		orderDTO.setUserDTO(convertToUserDTO(order.getUser()));
		return orderDTO;
	}

	public static ProductDTO convertToProductDTO(Product product) {
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		productDTO.setCategoryDTO(convertToCategoryDTO(product.getCategory()));
		productDTO.setSubProductDTOs(convertToSubProductDTOs(product.getSubProducts()));
		return productDTO;
	}

	public static ShoppingCartDTO convertToShoppingCartDTO(ShoppingCart shoppingCart) {
		ShoppingCartDTO shoppingCartDTO = modelMapper.map(shoppingCart, ShoppingCartDTO.class);
		shoppingCartDTO.setShoppingCartItemDTOs(convertToShoppingCartItemDTOs(shoppingCart.getShoppingCartItems()));
		shoppingCartDTO.setUserDTO(convertToUserDTO(shoppingCart.getUser()));
		return shoppingCartDTO;
	}

	public static ShoppingCartItemDTO convertToShoppingCartItemDTO(ShoppingCartItem shoppingCartItem) {
		ShoppingCartItemDTO shoppingCartItemDTO = modelMapper.map(shoppingCartItem, ShoppingCartItemDTO.class);
		shoppingCartItemDTO.setSubProductDTO(convertToSubProductDTO(shoppingCartItem.getSubProduct()));
		return shoppingCartItemDTO;
	}

	public static SubProductDTO convertToSubProductDTO(SubProduct subProduct) {
		SubProductDTO subProductDTO = modelMapper.map(subProduct, SubProductDTO.class);
		return subProductDTO;
	}

	public static UserDTO convertToUserDTO(User user) {
		UserDTO userDTO = user != null ? modelMapper.map(user, UserDTO.class) : new UserDTO();
		return userDTO;
	}

	public static List<CategoryDTO> convertToCategoryDTOs(Iterable<Category> categories) {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for (Category category : categories) {
			CategoryDTO categoryDTO = convertToCategoryDTO(category);
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

	public static List<OrderDTO> convertToOrderDTOs(Iterable<Order> orders) {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for (Order order : orders) {
			OrderDTO orderDTO = convertToOrderDTO(order);
			orderDTO.setShoppingCartDTO(convertToShoppingCartDTO(order.getShoppingCart()));
			orderDTO.setUserDTO(convertToUserDTO(order.getUser()));
			orderDTOs.add(orderDTO);
		}
		return orderDTOs;
	}

	public static List<ProductDTO> convertToProductDTOs(Iterable<Product> products) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Product product : products) {
			ProductDTO productDTO = convertToProductDTO(product);
			productDTO.setCategoryDTO(convertToCategoryDTO(product.getCategory()));
			productDTO.setSubProductDTOs(convertToSubProductDTOs(product.getSubProducts()));
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	public static List<ShoppingCartDTO> convertToShoppingCartDTOs(Iterable<ShoppingCart> shoppingCarts) {
		List<ShoppingCartDTO> shoppingCartDTOs = new ArrayList<>();
		for (ShoppingCart shoppingCart : shoppingCarts) {
			ShoppingCartDTO shoppingCartDTO = convertToShoppingCartDTO(shoppingCart);
			shoppingCartDTO.setShoppingCartItemDTOs(convertToShoppingCartItemDTOs(shoppingCart.getShoppingCartItems()));
			shoppingCartDTO.setUserDTO(convertToUserDTO(shoppingCart.getUser()));
			shoppingCartDTOs.add(shoppingCartDTO);
		}
		return shoppingCartDTOs;
	}

	public static List<ShoppingCartItemDTO> convertToShoppingCartItemDTOs(List<ShoppingCartItem> shoppingCartItems) {
		List<ShoppingCartItemDTO> shoppingCartItemDTOs = new ArrayList<>();
		if (!CollectionUtils.isEmpty(shoppingCartItems)) {
			for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
				ShoppingCartItemDTO shoppingCartItemDTO = convertToShoppingCartItemDTO(shoppingCartItem);
				SubProductDTO subProductDTO = modelMapper.map(shoppingCartItem.getSubProduct(), SubProductDTO.class);
				ProductDTO productDTO = modelMapper.map(shoppingCartItem.getSubProduct().getProduct(),
						ProductDTO.class);
				subProductDTO.setProductDTO(productDTO);
				shoppingCartItemDTO.setSubProductDTO(subProductDTO);
				shoppingCartItemDTOs.add(shoppingCartItemDTO);
			}
		}
		return shoppingCartItemDTOs;
	}

	public static List<SubProductDTO> convertToSubProductDTOs(Iterable<SubProduct> subProducts) {
		List<SubProductDTO> subProductDTOs = new ArrayList<>();
		for (SubProduct subProduct : subProducts) {
			SubProductDTO subProductDTO = convertToSubProductDTO(subProduct);
			subProductDTOs.add(subProductDTO);
		}
		return subProductDTOs;
	}

	public static List<UserDTO> convertToUserDTOs(Iterable<User> users) {
		List<UserDTO> userDTOs = new ArrayList<>();
		for (User user : users) {
			UserDTO userDTO = convertToUserDTO(user);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

}
