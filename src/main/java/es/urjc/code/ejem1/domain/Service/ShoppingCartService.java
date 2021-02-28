package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;

import java.util.UUID;

public interface ShoppingCartService {
	public FullShoppingCartDTO getShoppingCart(UUID id);

	public FullShoppingCartDTO createShoppingCart();

	public FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO);

	public FullShoppingCartDTO deleteShoppingCart(UUID id);

	public FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int nProducts);

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
                                        int quantity);

	public FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct);
}
