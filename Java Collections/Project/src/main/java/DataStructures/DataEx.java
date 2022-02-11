package DataStructures;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class DataEx 
{
    LinkedList<Animal> AnimaLinkedList = new LinkedList<>();
    ArrayList<Animal>  AnimaArrayList  = new ArrayList<>();
    Vector<Animal>     AnimaVector     = new Vector<>();

    public String CollectionType = "";

    public static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void Start(String Op) 
    {
        clearScreen();
        System.out.println("--- " + Op + " ---");
        System.out.println("");
    }

    public void End(String Op) throws IOException {
        System.out.println("");
        System.out.println(this.CollectionType + ": " + Op + " Done!");
        System.in.read();
    }

    public Object getCollection()
    {
        switch(this.CollectionType)
        {
            case "LinkedList":
                return this.AnimaLinkedList;
            case "ArrayList":
                return this.AnimaArrayList;
            case "Vector":
                return this.AnimaVector;
            default:
                return null;
        }
    }

    // CRUD
    public void add() throws IOException 
    {
        
        Object obj = getCollection();
        Animal tmp = new Animal();
        Start("add");

        if(this.CollectionType.matches("LinkedList|ArrayList|Vector")){
            List test = (List) obj;
            test.add(tmp);
        }

        tmp.PrintAnimal();
        End("add");
    }

    public void remove() throws IOException 
    {
        Object obj = getCollection();
        Start("remove");
        if (this.CollectionType.equals("LinkedList") || this.CollectionType.equals("ArrayList") || this.CollectionType.equals("Vector")) 
        {
            List test = (List) obj;
            test.remove(0);
            //this.AnimaLinkedList.remove(0);
        }
        End("remove");
    }

    public void update() throws IOException {
        Object obj = getCollection();
        Start("update");
        if (this.CollectionType.equals("LinkedList") || this.CollectionType.equals("ArrayList") || this.CollectionType.equals("Vector"))  
        {
            List test = (List) obj;
            Animal tmp = (Animal)test.get(0);
            tmp.UpdateAnimal();
            //this.AnimaLinkedList.get(0).UpdateAnimal();
        }
        End("update");
    }

    public void iterate() throws IOException {
        Object obj = getCollection();
        Start("iterate");
        if (this.CollectionType.equals("LinkedList") || this.CollectionType.equals("ArrayList") || this.CollectionType.equals("Vector")) 
        {
            List test = (List) obj;
            for (Object tmp : test) 
            {
                Animal tmp2 = (Animal)tmp;
                tmp2.PrintAnimal();
            }
        }
        End("iterate");
    }
}
