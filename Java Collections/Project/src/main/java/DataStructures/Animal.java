package DataStructures;


public class Animal {




    public String ID;
    public String Name;
    public String Type;

    public String random_types[] = {"Lion", "Tiger", "Elephant", "Giraffe", "Hippo", "Zebra", "Crocodile", "Snake", "Lion", "Tiger", "Elephant", "Giraffe", "Hippo", "Zebra", "Crocodile", "Snake"};
    public String random_names[] = {"Agust", "Jhosh", "Star", "Garfield", "Zaboo", "Nati", "Diego", "Gogi", "Lincon", "Asgard", "Tor", "Tony", "Rita", "Flofy", "Snop", "Floyd"};

    public Animal(String ID, String Name, String Type) 
    {
        this.ID = ID;;
        this.Name = Name;
        this.Type = Type;
    }

    // Overriding hashCode()
    @Override public int hashCode() { return Integer.parseInt(this.ID);}

    public void PrintAnimal(){
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.Name);
        System.out.println("Type: "+this.Type);
        System.out.println("");
    }

    public void UpdateAnimal()
    {
        String OldName = this.Name;
        String OldType = this.Type;

        int min = 0;
        int max = random_names.length - 1;
            
        int index_one = (int)Math.floor(Math.random()*(max-min+1)+min);
        int index_two = (int)Math.floor(Math.random()*(max-min+1)+min);

        this.Name = random_names[index_one];
        this.Type = random_types[index_two];

        System.out.println("ID: "+this.ID);
        System.out.println("Old Name: "+this.Name+" -> New Name: "+OldName);
        System.out.println("Old Type: "+this.Type+" -> New Type: "+OldType);
        System.out.println("");
    }

    

    public Animal(){

        int min = 0;
        int max = random_names.length - 1;
            

        int index_one = (int)Math.floor(Math.random()*(max-min+1)+min);
        int index_two = (int)Math.floor(Math.random()*(max-min+1)+min);

        this.ID = Integer.toString(index_one);
        this.Name = random_names[index_one];
        this.Type = random_types[index_two];

        /*
        System.out.println("Enter the Animal ID: ");
        Scanner sc = new Scanner(System.in);
        String ID = sc. nextLine();

        System.out.println("Enter the Animal Name: ");
        String Name = sc. nextLine();

        System.out.println("Enter the Animal Type: ");
        String Type = sc. nextLine();

        Animal tmp = new Animal(ID, Name, Type);
        */
    }
}
