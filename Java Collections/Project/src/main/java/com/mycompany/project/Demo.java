package com.mycompany.project;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import DataStructures.DataEx;

public class Demo 
{

    DataEx DT = new DataEx();

    String CollectionType = "";

    String[] crud_options = 
    {   
        "1- Add",
        "2- Remove",
        "3- Update",
        "4- Iterate",
        "5- Return to Collection Menu"
    };

    String[] collection_option = 
    {   
        "1- LinkedList",
        "2- ArrayList",
        "3- Vector",
        "4- LinkedHashSet",
        "5- TreeSet",
        "6- HashSet",
        "7- PriorityQueue",
        "8- HashTable",
        "9- HashMap",
        "10- LinkedHashMap",
        "11- TreeMap",
        "12- Exit Demo...",
    };

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public Demo()
    {

    }

    public void PrintMenu(String[] opt){
        System.out.println("Java Collections Project Demostration, Select an option:");
        for(String s: opt){
            System.out.println(s);
        }
    }

    public void ExitDemo(){
        System.out.println("Exiting Demo...");
        System.exit(0);
    }

    public void NoValidOption(String[] menu_options) throws IOException{
        System.out.println("Please enter an integer value between 1 and " + menu_options.length);
        System.in.read();
    }

    public void Menu(String[] menu_options,String scope) throws IOException{

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 12) {

            clearScreen();

            if(scope.equals("collection")){
                System.out.println("--- Collection Menu ---");
            }

            if(scope.equals("crud")){
                System.out.println("--- Crud Menu ---");
            }

            PrintMenu(menu_options);
            
            try {
                
                option = scanner.nextInt();
                if(scope.equals("collection")){
                    //this.CollectionType = menu_options[option-1];
                    //this.CollectionType = this.CollectionType.substring(3);
                    //DT.CollectionType = this.CollectionType;
                    DT.CollectionType = menu_options[option-1].substring(3);
                }
                switch (option){
                    case 1: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if (scope.equals("crud")){DT.add(); Menu(crud_options, "crud");}
                        break;

                    case 2: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if(scope.equals("crud")){DT.remove(); Menu(crud_options, "crud");}
                    break;

                    case 3: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if(scope.equals("crud")){DT.update(); Menu(crud_options, "crud");}
                    break;

                    case 4: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if(scope.equals("crud")){DT.iterate(); Menu(crud_options, "crud");}
                    break;

                    case 5: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if(scope.equals("crud")){Menu(collection_option,"collection");}
                    break;

                    case 12:
                        if(scope.equals("collection")){ExitDemo();}
                        if(scope.equals("crud")){NoValidOption(menu_options); scanner.next();}
                    break;

                    default:
                        if(option > 5 && option < 12 && scope.equals("collection")){
                            Menu(collection_option,"collection");
                        }
                        else{
                            NoValidOption(menu_options);
                        }
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and " + menu_options.length);
                System.in.read();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                System.in.read();
            }
        }
    }
    
}
