package es.urjc.code.ejem1.domain.Service;

import es.urjc.code.ejem1.domain.dto.FullProductDTO;
import es.urjc.code.ejem1.domain.dto.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.dto.ShoppingCartDTO;

public interface ShoppingCartService {
	public FullShoppingCartDTO getShoppingCart(Long id);

	public FullShoppingCartDTO createShoppingCart();

	public FullShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO);

	public FullShoppingCartDTO deleteShoppingCart(Long id);

	public FullShoppingCartDTO addProduct(Long idShoppingCart, Long idProduct, int nProducts);

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
                                        int quantity);

	public FullShoppingCartDTO deleteProduct(Long idShoppingCart, Long idProduct);
}
