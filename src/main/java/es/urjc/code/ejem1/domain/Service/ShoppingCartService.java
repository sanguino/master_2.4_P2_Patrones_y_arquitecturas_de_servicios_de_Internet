package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;

import java.util.UUID;

public interface ShoppingCartService {

	FullShoppingCartDTO createShoppingCart();

	FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO);

	FullShoppingCartDTO deleteShoppingCart(UUID id);

	FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int nProducts);

	FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO, int quantity);

	FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct);
}
