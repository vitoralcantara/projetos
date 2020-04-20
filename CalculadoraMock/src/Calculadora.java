public class Calculadora {

	MultiplicationService ms;

	Integer calculatePrice(Integer price, Integer amount, Integer reduction) {
		return ms.multiply(price, amount) - reduction;
	}

}
