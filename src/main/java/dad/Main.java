package dad;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Main {

	public static void main(String[] args) {
		
		/*
		   Double{Boolean, String...} property es observable,
		   es decir, se puede saber en qué momento ha cambiado
		   No se puede acceder al double de dentro, para eso
		   tiene getter y setter.
		 */
		
		DoubleProperty a = new SimpleDoubleProperty(2);
		DoubleProperty b = new SimpleDoubleProperty();

		/*
		  --- [ DoubleProperty A ] ---
		 	o = Observable (a)
		 	ov = OldValue (2)
		 	nv = NewValue(4.5);
		  -----------------------------
		  
		 */
		
		a.addListener((o, ov, nv) -> {
			System.out.println("A antes valía " + ov + " y ahora vale " + nv);
		});

		a.set(4.5);
		
		// Bindeamos b a A.
		//Por tanto A = 4.5; B = 4.5 (se propaga el valor)
		
		b.bind(a); 
		
		a.set(3.1416);
		
		// Al estar bindeado b A en este momento vale 3.1416 
		// así que B es 3.1416
		
		//Quitamos el bindeo
		b.unbind();
		
		a.set(4.8);
		
		//Ahora A vale 4.8 pero B vale 3.1416, ya que 
		//le quitamos el bindeo.
		
		DoubleProperty c = new SimpleDoubleProperty();
		c.bind(a.multiply(b));
		
	}
	
}
