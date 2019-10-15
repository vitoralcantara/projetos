//package visual;
//import java.util.ArrayList;
//
//import org.eventb.core.IMachineRoot;
//import org.eventb.core.IPOPredicate;
//import org.eventb.core.IPOPredicateSet;
//import org.eventb.core.IPORoot;
//import org.eventb.core.IPOSequent;
//import org.eventb.core.IPredicateElement;
//import org.rodinp.core.IAttributeValue;
//import org.rodinp.core.IInternalElement;
//import org.rodinp.core.IRodinElement;
//import org.rodinp.core.IRodinFile;
//import org.rodinp.core.IRodinProject;
//import org.rodinp.core.RodinCore;
//import org.rodinp.core.RodinDBException;
//
//
//public class TesteVitor {
//	
//	public static IMachineRoot[] getMachineRootChildren(IRodinProject project) throws RodinDBException {
//        ArrayList<IMachineRoot> result = new ArrayList<IMachineRoot>();
//        for (IRodinElement element : project.getChildren()) {
//              if (element instanceof IRodinFile) {
//                    IInternalElement root = ((IRodinFile) element).getRoot();
//                    if (root instanceof IMachineRoot) {
//                          result.add((IMachineRoot) root);
//                    }
//              }
//        }
//        return result.toArray(new IMachineRoot[result.size()]);
//  }	
//	
//	public static String getSomething()
//	{
//		try
//		{
//			IRodinProject rp =  RodinCore.getRodinDB().getRodinProject("BirthdayBook");
//			return rp.getElementName();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return "falhou";
//		
//		//IMachineRoot[] im = getMachineRootChildren(rp);
//		//IPORoot ro = im[0].getPORoot();
//		//IPOSequent[] sequents = ro.getSequents();
//		//IAttributeValue[] av = sequents[0].getAttributeValues();
//		//System.out.println("Imprindo Atributo:");
//		//return av[0].toString(); //System.out.println(av[0].toString());
//	}
//	
//	public TesteVitor() throws RodinDBException
//	{
//		IRodinProject rp =  RodinCore.getRodinDB().getRodinProject();
//		IMachineRoot[] im = getMachineRootChildren(rp);
//		IPORoot ro = im[0].getPORoot();
//		IPOSequent[] sequents = ro.getSequents();
//		IAttributeValue[] av = sequents[0].getAttributeValues();
//		IPOPredicateSet[] pe = sequents[0].getHypotheses();
//		IPOPredicate[] go = sequents[0].getGoals();	
//		System.out.println("Imprindo Atributo:");
//		System.out.println(av[0].toString());
//	}
//
//}
