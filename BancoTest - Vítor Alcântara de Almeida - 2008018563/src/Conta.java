
public class Conta {
	
		double saldo;
		String codigo;
		
		public Conta(String p_id, double p_saldo){
			this.saldo = p_saldo;
			this.codigo = p_id;
		}
		
		public void debitar(double valor) throws OperacaoIlegalException{
			if(valor > 0 && saldo >= valor){
				saldo = saldo - valor;
			}
			else{
				throw new OperacaoIlegalException();
			}
		}
		
		public Conta transferir(Conta c, double valor) throws OperacaoIlegalException{
			if(valor >= 0 && valor <= this.saldo){
				c.saldo = c.saldo + valor;
				this.saldo = this.saldo - valor;
				return c;
			}
			else{
				throw new OperacaoIlegalException();
			}
		}
}
