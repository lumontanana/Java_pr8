package lab8.basic;

import java.io.*;
import java.util.Arrays;

/**
 * A tester program that can be used to demonstrate the CustomerFinder class
 */
public class CFTester {

    /**
     * The entry point of the application
     *
     * @param args The command-line arguments (not used)
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader console;
        Customer customer;
        CustomerFinder finder;
        String prompt, input;
        Integer id = null;

        //Note: to check the correct output you should have a look at the file
        //"customers.txt"
        finder = new CustomerFinder();
        
        //julia
        //System.out.println(Arrays.toString(finder.ids).replaceAll(",", "\n"));
        
        
        prompt = "Enter the id of a customer: ";
        console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Press only 'Enter' key for end");
        System.out.println(prompt);

        input = console.readLine().trim();
        if (input.length() > 0) {
            id = Integer.parseInt(input);
        }
        
        System.out.println("id read is "  + id );
        
        while (id != null && input.length() > 0) {
            try {
                System.out.println("entering in try");
                customer = finder.getCustomer(id);
            } catch (NoCustomerFound ncf) {
                System.out.println("Exception: " + ncf);
                customer = null;
            }
            if (customer != null) {
                System.out.println(id + ": " + customer + "\n");
            }
            System.out.println(prompt);
            input = console.readLine().trim();
            if (input.length() > 0) {
                id = Integer.parseInt(input);
            }
        }
    }
}
