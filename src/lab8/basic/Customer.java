package lab8.basic;
/**
 * This class encodes a Customer which has a name and dni
 * (institutional identification number)
 * 
 * @author julia
 * 
 */
public class Customer {
  

    private String name; 
    private String dni; 
   
    

    public Customer(String n, String dni) {
        this.name = n;
        this.dni = dni;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    @Override
    public String toString(){
        return "name: " + this.name + "( dni: " + this.dni + " )";
    }
    
    
}
