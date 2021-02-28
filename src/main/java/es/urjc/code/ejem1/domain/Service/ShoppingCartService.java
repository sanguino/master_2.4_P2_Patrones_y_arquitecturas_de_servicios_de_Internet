package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;

import java.util.UUID;

public interface ShoppingCartService {

	FullShoppingCartDTO createShoppingCart();

	FullShoppingCartDTO updateShoppingCart(FullShoppingCartDTO fullShoppingCartDTO, ShoppingCartDTO shoppingCartDTO);

	FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO, int quantity);

	FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct);
}
