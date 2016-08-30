package Solutions;

public class Test {
	  public static void main(String[] args) {  
	        new Test();
			// TODO Auto-generated method stub  
	        System.out.println(Test.test());;  
	    }  
	    static int test()  
	    {  
	        int x = 1;  
	        try  
	        {  
	            return x;  
	        }  
	        finally  
	        {  
	        	System.out.println("finally");
	        }  
	    }  
}
