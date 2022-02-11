package com.mycompany.project;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import DataStructures.Animal;

public class Demo {

    LinkedList <Animal> AnimaLinkedList = new LinkedList<>();
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
        "2- LinkedHashSet",
        "3- TreeSet",
        "4- ArrayList",
        "5- Vector",
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

    public Animal CreateNewAnimal(){
        System.out.println("Enter the Animal ID: ");
        Scanner sc = new Scanner(System.in);
        String ID = sc. nextLine();

        System.out.println("Enter the Animal Name: ");
        String Name = sc. nextLine();

        System.out.println("Enter the Animal Type: ");
        String Type = sc. nextLine();

        Animal tmp = new Animal(ID, Name, Type);
        return tmp;
    }

    // CRUD
    public void add() throws IOException{
        clearScreen();
        System.out.println("--- Add ---");
        System.out.println("");
        Animal tmp = CreateNewAnimal();
        
        if(this.CollectionType.equals("LinkedList")){
            this.AnimaLinkedList.add(tmp);
        }

        System.out.println("");
        System.out.println(this.CollectionType+": New Animal Successfully Added!");
        System.in.read();
        Menu(crud_options,"crud");
    }

    public void remove() throws IOException{
        clearScreen();
        System.out.println("--- Remove ---");
        System.out.println("");
        if(this.CollectionType.equals("LinkedList")){
            this.AnimaLinkedList.removeLast();
        }

        System.out.println("");
        System.out.println(this.CollectionType+": Animal Successfully Removed!");
        System.in.read();
        Menu(crud_options,"crud");
    }

    public void update() throws IOException{
        clearScreen();
        System.out.println("--- Remove ---");
        System.out.println("");

        if(this.CollectionType.equals("LinkedList")){
            Animal tmp = null;
            System.out.println("Enter the Animal ID: ");
            Scanner sc = new Scanner(System.in);
            String ID = sc. nextLine();

            for(Animal a : this.AnimaLinkedList){
                if(a.ID.equals(ID)){
                    tmp = a;
                }
            }

            if(tmp == null){
                System.out.println("Animal not found!");
                System.in.read();
                Menu(crud_options,"crud");
            }

            
            System.out.println("Enter the New Animal Name: ");
            String Name = sc. nextLine();
            tmp.Name = Name;
        }

        System.out.println("");
        System.out.println(this.CollectionType+": Animal Successfully Updated!");
        System.in.read();
        Menu(crud_options,"crud");
    }

    public void iterate() throws IOException{
        clearScreen();
        System.out.println("--- Iterate ---");
        System.out.println("");

        if(this.CollectionType.equals("LinkedList")){
            for(Animal tmp : AnimaLinkedList){
                System.out.println("Name: " + tmp.Name + " ID: " + tmp.ID + " Type: " + tmp.Type);
            }
        }

        System.out.println("");
        System.out.println(this.CollectionType+": Successfully Iterated!");
        System.in.read();
        Menu(crud_options,"crud");
    }

    public Demo(){
    }

    public void PrintMenu(String[] opt){
        System.out.println("Java Collections Project Demostration, Select an option:");
        for(String s: opt){
            System.out.println(s);
        }
    }

    public void ExitDemo(){
        System.out.println("Exiting Demo...");
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
                if(scope.equals("collection")){
                    this.CollectionType = menu_options[option-1];
                    this.CollectionType = this.CollectionType.substring(3);
                }
                option = scanner.nextInt();
                switch (option){
                    case 1: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if (scope.equals("crud")){add();}
                        break;

                    case 2: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if(scope.equals("crud")){remove();}
                    break;

                    case 3: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if(scope.equals("crud")){update();}
                    break;

                    case 4: 
                        if(scope.equals("collection")){Menu(crud_options,"crud");}
                        if(scope.equals("crud")){iterate();}
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
