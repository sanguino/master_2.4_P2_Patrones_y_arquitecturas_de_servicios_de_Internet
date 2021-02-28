package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;

public interface ShoppingCartService {

	FullShoppingCartDTO createShoppingCart();

	FullShoppingCartDTO updateShoppingCart(FullShoppingCartDTO fullShoppingCartDTO, ShoppingCartDTO shoppingCartDTO);

	FullShoppingCartDTO addProduct(FullShoppingCartDTO fullShoppingCartDTO, FullProductDTO fullProductDTO, int quantity);

	FullShoppingCartDTO deleteProduct(FullShoppingCartDTO fullShoppingCartDTO, FullProductDTO fullProductDTO);
}
