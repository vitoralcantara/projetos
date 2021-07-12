package examples;

import org.jcsp.lang.*;

public class BCI implements CSProcess {

	public void run() {
		One2OneChannelInt in = Channel.one2oneInt();	
		One2OneChannelInt out = Channel.one2oneInt();
		
		ClienteBInc c 	= new ClienteBInc(in.out(),out.in());
		BufferInc b = new BufferInc(in.in(),out.out());
		
		Parallel bci = new Parallel(new CSProcess[]{c,b}); 
		bci.run();
	}

	public static void main(String[] args) {
		System.out.println("INICIO");
		(new BCI()).run();
		System.out.println("FIM");
	}
	
}
