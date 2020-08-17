package lab8.basic;


import java.io.*;
import java.util.Scanner;


/**
 * A class that can be used to retrieve Customer objects
 * by id (we assume this id is representative to an external
 * application as a commercial business, and distinct from dni
 * in Customer)
 */
public class CustomerFinder
{
    //Array to keep the customers
    private Customer[]  customers;       
    
    //Array to keep the ids for customers, same index as the previous one to 
    //"connect" both
    private  Integer[]   ids;
    
    //We know customers.txzt has 1500 registers, it would be better
    //programming practice to make this general and receive values as
    //command line arguments
    public static final int NUM_CUSTOMERS = 1500;
    public static final String nameFile = "customers.txt";

    /**
     * Default Constructor
     */
    public CustomerFinder() throws IOException
    {
       //id will be the key, focused on the "application"
       Integer        key;
       //Customer will be the value associated to the key 
       Customer       value;       
       
       //Used for reading the file
       Scanner        in;
       
       //intermediate variables to process the reading of the file
       String         name;
       String         dni; 
       String         line, sId;
       int            posI, posE;
       
       
       //initialization of the arrays
       customers = new Customer[NUM_CUSTOMERS];
       ids  = new Integer[NUM_CUSTOMERS];
       
       //opening the file for reading via a Scanner object
       //Notice it could also be done with BufferedReader
       in = new Scanner(new File(nameFile));

       //we assume the info is like this: one customer per line, fields
       //separated by spaces or tabs
       //first: id (number)
       //second: name, surrounded by inverted commas (")
       //third: dni (letter+ 6 digit number) --> String
       for (int i=0; in.hasNext(); i++)
       {
          //read file line by line
          line       = in.nextLine(); 
          
          //extract id (until space)
          line = line.trim();
          posE = line.indexOf(' ');             
          sId = line.substring(0, posE);
          //notice the use of Integer and not int
          //Have alook at Wrapper classes and autoboxing features
          //(https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)
          key = new Integer(sId);
          
          //take key out of line
          //see how Strings doesn't change and output has to be assigned
          line = line.substring(posE, line.length());
          line = line.trim();
          
         
          //now the name, remember it is into inverted commas or quotation marks
          //so posI is the initial position with ", and posE the ending one
          posI = line.indexOf("\"");
          posE = line.lastIndexOf("\"");
          name = line.substring(posI+1, posE).trim();
          
                  
          //take name out of line
          line = line.substring(posE+1, line.length());
          
          //read the dni
          line = line.trim();
          dni = line;
          
          //we can't now create/instantiate the customer
          value     = new Customer(name, dni);          

          //both elements in the arrays ints and customers get the right value
          ids[i]  = key;
          customers[i] = value;    
          //System.out.println("key = " + key + "; value = " + value);
         
       }
    }


    /**
     * Get the Coustomer with the given identifier
     *
     * @param   id  The identifier of the Customer
     * @return  The Customer (or throws an instance of Exception
     * NoCustomerFound if the customer doesn't exist)
     */
    public Customer getCustomer(Integer id) throws NoCustomerFound
    {
       Customer  result = null;  
       //** Parts 3.2, 3.3 a nd 3.4, generate one method per each
       //saving CustomerFinder with the names indicated
       //Then, with generics -type safe -- you'll do the versions for 4.1 & 4.2       
       //Add your code here
       //HINT:  Loop through the array of customers until you find the appropriate index.
       //remember to throw the exception if necessary
       
	   //Your code here
        //my code is here
      
                    
        
       return result;       
    }
 
    
  
}
