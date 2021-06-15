//
// Programa: DeletionOfNonExistingItemException.java
//

//
// Definição da classe DeletionOfNonExistingItemException.
//

public class DeletionOfNonExistingItemException extends RuntimeException 
{
    // Construtor sem argumento.
    public DeletionOfNonExistingItemException()
    {
	// Chama construtor de superclasse.
	super( "Item is not in the tree." );
    }

} // Fim da classe DeletionOfNonExistingItemException
