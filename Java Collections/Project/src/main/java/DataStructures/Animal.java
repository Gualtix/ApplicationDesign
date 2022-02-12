package DataStructures;


public class Animal implements Comparable 
{

    public String ID;
    public String Name;
    public String Type;

    //15
    public String random_types[] = {"Lion", "Tiger", "Elephant", "Giraffe", "Hippo", "Zebra", "Crocodile", "Snake", "Lion", "Tiger", "Elephant", "Giraffe", "Hippo", "Zebra", "Crocodile"};
    public String random_names[] = {"Agust", "Jhosh", "Star", "Garfield", "Zaboo", "Nati", "Diego", "Gogi", "Lincon", "Asgard", "Tor", "Tony", "Rita", "Flofy", "Snop"};

    public int getRandomInt(int min, int max)
    {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    // Overriding hashCode()
    @Override public int hashCode() 
    { 
        int code = Integer.parseInt(this.ID);
        return code;
    }

    // Overriding equals()
    @Override public boolean equals(Object obj) 
    { 
        Animal a = (Animal) obj; 
        return (this.ID == a.ID);
    }

    // Overriding toString()
    @Override public String toString() 
    { 
        return "ID: " + this.ID + " Name: " + this.Name + " Type: " + this.Type;
    }

    // Overriding compareTo()
    @Override public int compareTo(Object o) 
    {
        Animal a = (Animal) o;
        return this.ID.compareTo(a.ID);
    }

    public void PrintAnimal(){
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.Name);
        System.out.println("Type: "+this.Type);
        System.out.println("");
    }

    public void ShowOld(Animal OldAnimal)
    {
        System.out.println("Old ID: "+OldAnimal.ID+" -> New ID: "+OldAnimal.ID);
        System.out.println("Old Name: "+OldAnimal.Name+" -> New Name: "+this.Name);
        System.out.println("Old Type: "+OldAnimal.Type+" -> New Type: "+this.Type);
        System.out.println("");
    }

    public void UpdateAnimal()
    {
        String OldName = this.Name;
        String OldType = this.Type;

        this.Name = random_names[getRandomInt(0,4)];
        this.Type = random_types[getRandomInt(0,4)];

        System.out.println("ID: "+this.ID +"(Is Inmutable)");
        System.out.println("Old Name: "+this.Name+" -> New Name: "+OldName);
        System.out.println("Old Type: "+this.Type+" -> New Type: "+OldType);
        System.out.println("");
    }

    public Animal(String ID, String Name, String Type)
    {
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
    }

    public Animal()
    {
        this.ID = Integer.toString(getRandomInt(0,4));
        this.Name = random_names[getRandomInt(0,4)];
        this.Type = random_types[getRandomInt(0,4)];
    }
}
