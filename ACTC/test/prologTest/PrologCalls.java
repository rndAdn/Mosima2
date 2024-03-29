package prologTest;//package prologTest;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Random;

import org.jpl7.Query;

public class PrologCalls {

	public static int succesRate=20;
	
//	public prologTest.PrologCalls(){
//		super();
//		System.out.println("Instance created!");
//	};
	
	public static void test(){
		System.out.println("PointInteret called :)");
	}
	
	/**
	 * 
	 * @param fisherman Name of the fisherman
	 * @param fish Name of the fish
	 * @return true if the fisherman hooked the fish. 
	 */
	public static boolean hooked(String fisherman,String fish){
		Random r=new Random();
		//theoretically, the function should check in the environment that the conditions for the fish to be hooked are met.  
		int x=r.nextInt(100);
		System.out.println("Hooked function triggered; succesRate = "+succesRate+"; v= "+x);
		return (x<succesRate) ? true: false;
	}
	
	public static void main(String []args){
		ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println(url.getFile());
        }
	 
		System.out.println("Trigerring Java-JPL-Java loop");
		//System.out.println(""+System.getProperty("user.dir"));
		
		//unexplicit loading of the file
		String query = "consult('./ressources/prolog/test/fishing.pl')";
		System.out.println(query+" ?: "+Query.hasSolution(query));
		
		System.out.println("**PointInteret 1**");
		query="fish(tom)";
		System.out.println(query+" ?: "+Query.hasSolution(query));
		
		System.out.println("**PointInteret 2**");
		query="fish(maurice)";
		System.out.println(query+" ?: "+Query.hasSolution(query));
		
		System.out.println("**PointInteret 3**");
		query="caught(maurice,tom)";
		System.out.println(query+" ?: "+Query.hasSolution(query));
		
		System.out.println("**PointInteret 4**");
		query="caught(tom,maurice)";
		System.out.println(query+" ?: "+Query.hasSolution(query));
		
		System.out.println("passed");
	}
//
//		
//		Query q1 =
//	            new Query(
//	                "consult",
//	                new Term[] {new Atom("test.pl")}
//	            );
//	    
//	    
//	}    
	
}
