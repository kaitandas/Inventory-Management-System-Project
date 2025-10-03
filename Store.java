package store;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    Scanner s = new Scanner(System.in);
    
    // Attributs of class Store
    public String name;
    public String Address;
    Manager m = new Manager("kaitandas", "kaitan1234", 3002,"kaitan", "kaitan@gmail.com" );  // object of Manager                                                                                           
    ArrayList <SalesMan> sm_list= new ArrayList<>();  // object of SalesPerson
    ArrayList <Customer> custm_list = new ArrayList<>(); // object of customer
    ArrayList <Stock> stock_list = new ArrayList<>();  // object of Stock

    public Store(String name, String Address) {
        this.name = name;
        this.Address = Address;
    }
    
private abstract class Employee {
    
    Scanner em = new Scanner(System.in);
    
    private int Id;
    private String Name;
    private String email_Id;

        public Employee(int Id, String Name, String email_Id) {
            this.Id = Id;
            this.Name = Name;
            this.email_Id = email_Id;
        }
    
    

        public Employee() {
        }

        public int getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }

        public String getEmail_Id() {
            return email_Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public void setEmail_Id(String email_Id) {
            this.email_Id = email_Id;
        }
    
        abstract boolean login();
  
    }
    
private class Manager extends Employee{

    Scanner ad = new Scanner(System.in);
    
    private String user_name;
    private String password;
    private boolean Access;

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setAccess(boolean Access) {
            this.Access = Access;
        }

        public String getUser_name() {
            return user_name;
        }

        public String getPassword() {
            return password;
        }

        public boolean isAccess() {
            return Access;
        }
    
        public Manager(String user_name, String password, int Id, String Name, String email_Id) {
            super(Id, Name, email_Id);
            this.user_name = user_name;
            this.password = password;
        }

    @Override
    boolean login(){
        // Input
        System.out.println("Enter your Username:");
        String U_N = ad.next();
        System.out.println("Enter your Password:");
        String Pass = ad.next();
        
        // Verification
        Access = user_name.equals(U_N) && password.equals(Pass);
        if(Access == true){
            System.out.println("you have successfully logged in.\nAccess granted!");
            return true;
        }
        else{
            System.out.println("Invalid username or password.\nAccess denied!");
            return false;
        }
    }

    void Change_username(){
        System.out.println("Enter new Username:");
        String new_U_N = ad.next();
        setUser_name(new_U_N);
        System.out.println("Your username has been successfully updated.");
    }

    
    void Change_Password(){
        System.out.println("Enter your currenr password:");
        String Pass_Curr = ad.next();
        if(Pass_Curr.equals(password)){
        System.out.println("Enter new Password:");
        String new_Pass = ad.next();
        setPassword(new_Pass);
        System.out.println("Your password has been successfully updated.");
        }
        else{
            System.out.println("Sorry! please enter your correct password.");
        }
    }
    
    void add_salesMan(){
        System.out.println("how many salesman would you like to add:");
        int n = s.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Enter Salesman "+(i+1)+" Id:");
            int Id = s.nextInt();
            System.out.println("Enter Salesman "+(i+1)+" name:");
            String name = s.next();
            System.out.println("Enter salesman "+(i+1)+" Email Id:");
            String email_Id = s.next();
            System.out.println("Assign username to Salesman "+(i+1));
            String u_name = s.next();
            System.out.println("Assign password to Salesman "+(i+1));
            String pass = s.next();
                       
            sm_list.add(new SalesMan(u_name, pass, Id, name, email_Id));
        }
    }
    
    void salesMan_details(){
        System.out.println("select any one:");
            System.out.println("1.All Salesmen's details");
            System.out.println("2. Any specific Salesman's detail");
            int n = s.nextInt();
            switch(n){
                case 1:
                  for (SalesMan s : sm_list) {
                  System.out.println("ID: "+s.getId()+", Name: "+s.getName()+", email Id: "+s.getEmail_Id()+", Username: "+s.getUser_name()+", Password: "+s.getPassword());
                    } 
                    break;
                case 2:
                    System.out.println("Enter ID of Customer you wish to view:");
                    int id = s.nextInt();
                    boolean found = false;
                    for(int i = 0; i < custm_list.size(); i++){
                    if(id == custm_list.get(i).getId()){
                    System.out.println("ID: "+custm_list.get(i).getId()+", Name: "+custm_list.get(i).getName()+", phone number: "+custm_list.get(i).getPhone_Num()+", Email Id: "+custm_list.get(i).getEmail());
                    found = true;
                    break;
                    }
                    }
                    if(found == false)
                    System.out.println("Sorry no such Salesman was found having the ID "+id);
                    break;
                default:
                    System.out.println("please chose an appropriate option.");
            }
    }
    
    void remove_salesman(){
        System.out.println("Enter ID of Saleman you wish to remove:");
        int dlt_Id = s.nextInt();
        boolean found = false;
        for(int i = 0; i < sm_list.size(); i++){
            if(dlt_Id == sm_list.get(i).getId()){
                sm_list.remove(sm_list.get(i));
            System.out.println("Salesman has been successfully removed.");
            found = true;
            break;
            }
        }
        if(found == false)
            System.out.println("Sorry no Salesman was found having the  ID: "+dlt_Id);
    }
    
    void view_stock(){
        System.out.println("Select any one:");
        System.out.println("1.View all stocks");
        System.out.println("2.View any specific stock");
        int n = s.nextInt();
        
        switch(n){
            case 1:
                for (Stock st : stock_list) {
                System.out.println("ID: "+st.getStock_Id()+", Name: "+st.getStock_name()+", Category: "+st.getCategory()+", Price: "+st.getStock_price()+", Quantity: "+st.getQuantity()+", Description: "+st.getDescription());
                    }    
                break;
            case 2:
                System.out.println("Enter ID of stock you wish to view:");
                int id = s.nextInt();
                boolean found = false;
                for(int i = 0; i < stock_list.size(); i++){
                if(id == stock_list.get(i).getStock_Id()){
                System.out.println("ID: "+stock_list.get(i).getStock_Id()+", Name: "+stock_list.get(i).getStock_name()+", Category: "+stock_list.get(i).getCategory()+", Price: "+stock_list.get(i).getStock_price()+", Quantity: "+stock_list.get(i).getQuantity()+", Description: "+stock_list.get(i).getDescription());
                found = true;
                break;
                }
                }
                if(found == false)
                    System.out.println("Sorry no such stock was found having the ID "+id);
                break;
            default:
                System.out.println("please choose an appropriate option.");
        }
    }
    
    void create_stock(){
        System.out.println("How many stocks do you want to add ?");
        int num = s.nextInt();
        
        for(int i = 0; i < num; i++){
            System.out.println("Enter stock "+(i+1)+" Id:");
            int st_Id = s.nextInt();
            System.out.println("Enter stock "+(i+1)+" name:");
            String st_name = s.next();
            System.out.println("Enter stock "+(i+1)+" Category:");
            String st_categ = s.next();
            System.out.println("Enter stock "+(i+1)+" price:");
            double st_price = s.nextDouble();
            System.out.println("Enter stock "+(i+1)+" Quantity:");
            int st_quant = s.nextInt();
            System.out.println("Enter stock "+(i+1)+" Description:");
            String st_desc = s.next();
            
            stock_list.add(new Stock(st_Id, st_name, st_categ, st_price, st_quant, st_desc));
        }  
    }
    
    void add_stock(){
        System.out.println("Enter Id of stock you want to add:");
        int id = s.nextInt();
        for(int i = 0; i < stock_list.size(); i++){
            if(id == stock_list.get(i).getStock_Id()){
                System.out.println("How much Quantity would you like to add more in this stock:");
                int q = s.nextInt();
                stock_list.get(i).setQuantity(stock_list.get(i).getQuantity() + q);
                System.out.println(q+" more "+stock_list.get(i).getStock_name()+" have been added successfully.");
                break;
            }
            else{
                System.out.println("Sorry no stock found having the ID: "+id);
            }
        } 
    }
    
    void delete_stock(){
        System.out.println("Enter ID of Stock you wish to delete:");
        int dlt_Id = s.nextInt();
        boolean found = false;
        for(int i = 0; i < stock_list.size(); i++){
            if(dlt_Id == stock_list.get(i).getStock_Id()){
                stock_list.remove(stock_list.get(i));
            System.out.println("Stock has been successfully deleted.");
            found = true;
            break;
            }
        }
        if(found == false)
            System.out.println("Sorry no stock found having the  ID: "+dlt_Id);
    }
    
    void update_stock(){
        System.out.println("Enter Id of stock you wish to update:");
        int Id = s.nextInt();
        boolean found = false;
        for(int i = 0; i < stock_list.size(); i++){
            if(Id == stock_list.get(i).getStock_Id()){
                System.out.println("select any one:");
                System.out.println("1.update stock completely");;
                System.out.println("2.update stock price");
                System.out.println("3.update stock quantity");
                System.out.println("4.update stock description");
                
                int n = s.nextInt();
                int p, q;
                String d;
                
                switch(n){
                    case 1:
                        System.out.println("Enter new Price:");
                        p = s.nextInt();
                        stock_list.get(i).setStock_price(p);
                        System.out.println("Enter new Quantity:");
                        q = s.nextInt();
                        stock_list.get(i).setQuantity(q);
                        System.out.println("Enter new Description:");
                        d = s.next();
                        stock_list.get(i).setDescription(d); 
                        System.out.println("Stock has been successfully updated.");
                        break;
                    case 2:
                        System.out.println("Enter new Price:");
                        p = s.nextInt();
                        stock_list.get(i).setStock_price(p);
                        System.out.println("Stock's price has been successfully updated");
                        break;
                    case 3:
                        System.out.println("Enter new Quantity:");
                        q = s.nextInt();
                        stock_list.get(i).setQuantity(q);
                        System.out.println("Stock's quantity has been successfully updated");
                        break;
                    case 4:
                        System.out.println("Enter new Description:");
                        d = s.next();
                        stock_list.get(i).setDescription(d);
                        System.out.println("Stock's description has been successfully updated");
                        break;
                    default:
                        System.out.println("please choose an appropriate option.");
                }
                System.out.println("Stock has been successfully updated.");
                found = true;
            break;
            }
        }
        if(found == false)
            System.out.println("Sorry no stock found having the ID: "+Id);
    }
}
    
private class SalesMan extends Employee {
    
    Scanner sm = new Scanner(System.in);
    
    String user_name;
    String password;
    boolean Access;

        public SalesMan(String user_name, String password, int Id, String Name, String email_Id) {
            super(Id, Name, email_Id);
            this.user_name = user_name;
            this.password = password;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setAccess(boolean Access) {
            this.Access = Access;
        }

        public String getUser_name() {
            return user_name;
        }

        public String getPassword() {
            return password;
        }

        public boolean isAccess() {
            return Access;
        }

        
        
    @Override
        boolean login(){
        // Input
        System.out.println("Enter your Username:");
        String U_N = sm.next();
        System.out.println("Enter your Password:");
        String Pass = sm.next();
        
        // Verification
        Access = user_name.equals(U_N) && password.equals(Pass);
        if(Access == true){
            System.out.println("you have successfully logged in.\nAccess granted!");
            return true;
        }
        else{
            System.out.println("Invalid username or password.\nAccess denied!");
            return false;
        }
    }

        void add_customer(){
            System.out.println("How many customers would you like to add:");
            int n = s.nextInt();
            for(int i = 0; i < n; i++){
            System.out.println("Enter Customer "+(i+1)+" name:");
            String name = s.next();
            System.out.println("Enter Customer "+(i+1)+" Id:");
            int Id = s.nextInt();
            System.out.println("Enter Customer "+(i+1)+" phone number:");
            int phn_num = s.nextInt();
            System.out.println("Enter Customer "+(i+1)+" Email Id:");
            String email_Id = s.next();
            
            custm_list.add(new Customer(name, Id, phn_num, email_Id));
            }
        }
        
        void cutomer_details(){
            System.out.println("select any one:");
            System.out.println("1.All customers' details");
            System.out.println("2. Any specific customer's detail");
            int n = s.nextInt();
            switch(n){
                case 1:
                  for (Customer c : custm_list) {
                  System.out.println("ID: "+c.getId()+", Name: "+c.getName()+", phone number: "+c.getPhone_Num()+", email Id: "+c.getEmail());
                    } 
                    break;
                case 2:
                    System.out.println("Enter ID of Customer you wish to view:");
                    int id = s.nextInt();
                    boolean found = false;
                    for(int i = 0; i < custm_list.size(); i++){
                    if(id == custm_list.get(i).getId()){
                    System.out.println("ID: "+custm_list.get(i).getId()+", Name: "+custm_list.get(i).getName()+", phone number: "+custm_list.get(i).getPhone_Num()+", Email Id: "+custm_list.get(i).getEmail());
                    found = true;
                    break;
                    }
                    }
                    if(found == false)
                    System.out.println("Sorry no such Customer was found having the ID "+id);
                    break;
                default:
                    System.out.println("please chose an appropriate option.");
            }
        }
        
        void dlt_customer(){
            System.out.println("Enter ID of Customer you wish to remove:");
            int dlt_Id = s.nextInt();
            boolean found = false;
            for(int i = 0; i < custm_list.size(); i++){
            if(dlt_Id == custm_list.get(i).getId()){
                custm_list.remove(custm_list.get(i));
                System.out.println("Customer has been successfully removed.");
                found = true;
                break;
            }
        }
        if(found == false)
            System.out.println("Sorry no Customer was found having the  ID: "+dlt_Id);
        }
        
        void sell_stock(){
            System.out.println("Enter Id of Customer who wants to purchase Stock:");
            int c_id = s.nextInt();
            boolean found1 = false;
            for(int i = 0; i < custm_list.size(); i++){
                if(c_id == custm_list.get(i).getId()){
                    found1 = true;
                    int st_id;
                    do{
                    System.out.println("Enter ID of Stock you wish to sale (press 0 to exit)");
                    st_id = s.nextInt();
                    boolean found2 = false;
                    for(int j = 0; j < stock_list.size(); j++){
                        if(st_id == stock_list.get(i).getStock_Id()){
                            found2 = true;
                            System.out.println("Enter qauntity you would like to sale to customer "+custm_list.get(i).getName());
                            int q = s.nextInt();
                            if(q <= stock_list.get(i).getQuantity()){
                                stock_list.get(i).setQuantity(stock_list.get(i).getQuantity() - q);
                                System.out.println(q+" Quantity of stock "+stock_list.get(i).getStock_name()+" has been sold to customer "+custm_list.get(i).getName());
                            }
                            else{
                                System.out.println("Sorry there is not enough quantity available of this stock.");
                            }
                        }
                        else{
                            System.out.println("Sorry stock having the Id: "+st_id+" is not found.");
                        }
                            break;
                    }
                }while(st_id != 0);
            }
            if(found1==true)
                break;
        }
    }
}
    
private class Customer {
    
    private String name;
    private int Id;
    private int phone_Num;
    private String Email;

        public Customer(String name, int Id, int phone_Num, String Email) {
            this.name = name;
            this.Id = Id;
            this.phone_Num = phone_Num;
            this.Email = Email;
        }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setPhone_Num(int phone_Num) {
        this.phone_Num = phone_Num;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public int getPhone_Num() {
        return phone_Num;
    }

    public String getEmail() {
        return Email;
    }
    
}
 
    public static void main(String[] args) { 
        
        Scanner sc = new Scanner(System.in);
        Store s1 = new Store("ABC","221B Baker street");
        System.out.println("Welcome to "+ s1.name+" Super store");
        System.out.println("");
        int num;
        do{
        System.out.println("select any one, press 0 to exit.");
        System.out.println("1.you are a manager");
        System.out.println("2.you are a salesman");
        num = sc.nextInt();
            switch (num) {
                case 1:
                    if(s1.m.login() == true){
                        int choice;
                        do{
                        System.out.println("select any of the fllowing, press 0 to exit.");
                        System.out.println("1. View Stock");
                        System.out.println("2. Create new Stock");
                        System.out.println("3. Add Stock");
                        System.out.println("4. Update Stock");
                        System.out.println("5. Delete Stock");
                        System.out.println("6. Add Salesman");
                        System.out.println("7. view Salesman details");
                        System.out.println("8. Remove Salesman");
                        
                        choice = sc.nextInt();
                        
                        switch(choice){
                            case 1:
                                s1.m.view_stock();
                                break;
                            case 2:
                                s1.m.create_stock();
                                break;
                            case 3:
                                s1.m.add_stock();
                                break;
                            case 4:
                                s1.m.update_stock();
                                break;
                            case 5:
                                s1.m.delete_stock();
                                break;
                            case 6:
                                s1.m.add_salesMan();
                                break;
                            case 7:
                                s1.m.salesMan_details();
                                break;
                            case 8:
                                s1.m.remove_salesman();
                                break;
                            default:
                                System.out.println("Please choose a valid option.");
                    }
                    }while(choice != 0);
                }
                        break;
                case 2:
                    System.out.println("Enter your Id:");
                    int id = sc.nextInt();
                    boolean found = false;
                    for(int i = 0; i < s1.sm_list.size(); i++){
                        found = true;
                        break;
                    }       
                    if(found == true){
                        boolean check = false;
                        for(int i = 0; i < s1.sm_list.size(); i++){
                        if(id == s1.sm_list.get(i).getId()){
                             if(s1.sm_list.get(id).login()== true){
                            System.out.println("Select any one:");
                            System.out.println("1. Sale stock");
                            System.out.println("2. Add Customer");
                            System.out.println("3. View Customer Details");
                            System.out.println("4. Remove Customer");
                            int choice = sc.nextInt();
                            switch(choice){
                                case 1:
                                    s1.sm_list.get(i).sell_stock();
                                    break;
                                case 2:
                                    s1.sm_list.get(i).add_customer();
                                    break;
                                case 3:
                                    s1.sm_list.get(i).cutomer_details();
                                    break;
                                case 4:
                                    s1.sm_list.get(i).dlt_customer();
                                    break;
                                default:
                                    System.out.println("please choose an appropriate option.");
                            }
                        }
                        }
                        break;
                        }
                    }    
                    else{
                        System.out.println("Sorry Id not found.");
                    }
                    break;
                default:
                    if(num != 0){
                    System.out.println("Sorry! Invalid input.");
                       }
                    break;
            }
    }while(num != 0);
}

}

