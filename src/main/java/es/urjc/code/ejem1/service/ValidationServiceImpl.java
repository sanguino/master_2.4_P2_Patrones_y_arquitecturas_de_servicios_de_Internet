package es.urjc.code.ejem1.service;

import es.urjc.code.ejem1.domain.Service.ValidationService;
import es.urjc.code.ejem1.domain.model.ShoppingCartItem;

import java.util.List;
import java.util.Random;

public class ValidationServiceImpl implements ValidationService {

	@Override
	public boolean validate(List<ShoppingCartItem> items) {
		Random rnd = new Random();

		return rnd.nextBoolean();
	}


}
