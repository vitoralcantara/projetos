//
// Programa: InsertionOfExistingItemException.java
//

//
// Definição da classe InsertionOfExistingItemException.
//

public class InsertionOfExistingItemException extends RuntimeException 
{
    // Construtor sem argumento.
    public InsertionOfExistingItemException()
    {
	// Chama construtor de superclasse.
	super( "Item is already in the tree." );
    }

} // Fim da classe InsertionOfExistingItemException
