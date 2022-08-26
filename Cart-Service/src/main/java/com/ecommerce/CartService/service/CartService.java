package com.ecommerce.CartService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.CartService.entity.Cart;
import com.ecommerce.CartService.entity.CartItem;
import com.ecommerce.CartService.entity.CartItemDto;
import com.ecommerce.CartService.entity.Product;
import com.ecommerce.CartService.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepo;

	@Autowired
	private RestTemplate restTemplate;

	public String addItem(Integer cartId, CartItemDto dto) {

		Cart cart = null;

		Optional<Cart> cartOptional = cartRepo.findById(cartId);

		if (cartOptional.isPresent()) {

			cart = cartOptional.get();

		} else {

			cart = new Cart();

		}

		CartItem Ct = new CartItem();
		Ct.setCartItemId(dto.getCartItemId());
		Product product = restTemplate.getForObject("http://localhost:9093/products/" + dto.getProductId(),
				Product.class);

		Ct.setProduct(product);

		Ct.setQuantity(dto.getQuantity());

		Ct.setPrice(product.getDiscountedPrice());

		cart.setCartId(cartId);

		cart.addToCart(Ct);

		cart.getGrandTotal();

		cartRepo.save(cart);
		
		return "Cart Created Successfully";

	}
	
	
	 public String updateQuantity(Integer cartId, Integer itemId, Integer quantity) {

         Optional<Cart> cartOptional = cartRepo.findById(cartId);

         if (cartOptional.isPresent()) {

                       boolean itemfound = false;
                       Cart cart = cartOptional.get();
                       List<CartItem> cartItems = cart.getCartitems();
                       for (CartItem cartItem : cartItems) {
                                      if (cartItem.getCartItemId() == itemId) {
                                                    cartItem.setQuantity(quantity);
                                                    itemfound = true;}
                        }
                       
                       if (itemfound) {
                                      cart.setCartItems(cartItems);
                                      cartRepo.save(cart);
                                      return "updated successfully";}
                       else {
                                      return " CartItem Not Found";
                       }
         } else {

                       return "Cart not Found";

         }

       }



         public Cart getSingleCart(Integer cartId) {

         Optional<Cart> cart = cartRepo.findById(cartId);

         if (cart.isPresent()) {
                       return cart.get();
         } else {
                       throw new RuntimeException("Cart not Found");
         }

         }

         public String deleteItem(Integer cartId, Integer itemId) {

             Optional<Cart> cartOptional = cartRepo.findById(cartId);

             if (cartOptional.isPresent()) {

                           List<CartItem> newItems = new ArrayList<>();

                           Cart cart = cartOptional.get();

                           List<CartItem> cartItems = cart.getCartitems();

                           for (CartItem cartItem : cartItems) {

                                          if (cartItem.getCartItemId() == itemId) {

                                                        continue;

                                          }

                                          newItems.add(cartItem);

                           }
                           cart.setCartItems(newItems);
                           cartRepo.save(cart);
                           return "deleted";
             } else {
                           return "Cart not Found";
             }

}




}


