package rmiknolexample;
 
import java.rmi.Naming;
import java.rmi.RemoteException;
 
/**
 *
 * @author Andre
 */
public class ForumClient {
    public static void main(String[] args) {
        try {
            IForum forumObj = (IForum)Naming.lookup("rmi://localhost/forumService");
            forumObj.postMessage("autor", "Java RMI é muito legal");
            forumObj.postMessage("autor", "Nunca poste no fórum sem buscar");
            String[] posts = forumObj.readPosts();
 
            int x = 1;
            for(String s: posts)
                System.err.println(x++ + ": "+ s);
 
            int offset = 1;
            posts = forumObj.readPosts(offset);
            for(String s: posts)
                System.err.println((x++ + offset) + ": "+ s);                        
 
        } catch(RemoteException e) {
            System.err.println("Ocorreu um erro relativo ao RMI: " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        } catch(Exception e) {
            System.err.println("Ocorreu um erro desconhecido: " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }        
    }
}