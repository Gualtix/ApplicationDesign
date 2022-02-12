package DataStructures;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class DataEx 
{
    LinkedList<Animal> AnimaLinkedList = new LinkedList<>();
    ArrayList<Animal> AnimaArrayList  = new ArrayList<>();
    Vector<Animal> AnimaVector     = new Vector<>();
    HashMap<String, Animal> AnimaHashMap = new HashMap<>();
    Hashtable<String, Animal> AnimaHashTable = new Hashtable<>();
    LinkedHashMap<String, Animal> AnimaLinkedHashMap = new LinkedHashMap<>();
    TreeMap<String, Animal> AnimaTreeMap = new TreeMap<>();
    HashSet<Animal> AnimaHashSet = new HashSet<>();
    LinkedHashSet<Animal> AnimaLinkedHashSet = new LinkedHashSet<>();
    TreeSet<Animal> AnimaTreeSet = new TreeSet<>();
    PriorityQueue<Animal> AnimaPriorityQueue = new PriorityQueue<>();


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
            case "LINKEDLIST":
                return this.AnimaLinkedList;
            case "ARRAYLIST":
                return this.AnimaArrayList;
            case "VECTOR":
                return this.AnimaVector;
            case "HASHTABLE":
                return this.AnimaHashTable;
            case "HASHMAP":
                return this.AnimaHashMap;
            case "LINKEDHASHMAP":
                return this.AnimaLinkedHashMap;
            case "TREEMAP":
                return this.AnimaTreeMap;
            case "HASHSET":
                return this.AnimaHashSet;
            case "LINKEDHASHSET":
                return this.AnimaLinkedHashSet;
            case "TREESET":
                return this.AnimaTreeSet;
            case "PRIORITYQUEUE":
                return this.AnimaPriorityQueue;
            
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

        switch(this.CollectionType)
        {
            case("LINKEDLIST"):
            case("ARRAYLIST"):
            case("VECTOR"): CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.add(obj, tmp); break;

            case("HASHMAP"):
            case("HASHTABLE"):
            case("LINKEDHASHMAP"):
            case("TREEMAP"): CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP_TREEMAP.add(obj, tmp); break;

            case("HASHSET"):
            case("LINKEDHASHSET"):
            case("TREESET"):CrudOperation.HASHSET_LINKEDHASHSET_TREESET.add(obj, tmp); break;

            case("PRIORITYQUEUE"): CrudOperation.PRIORITYQUEUE.add(obj, tmp); break;
        }
        tmp.PrintAnimal();
        End("add");
    }

    public void remove() throws IOException 
    {
        Object obj = getCollection();
        Start("remove");

        switch(this.CollectionType)
        {
            case("LINKEDLIST"):
            case("ARRAYLIST"):
            case("VECTOR"): CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.remove(obj, 0); break;

            case("HASHMAP"):
            case("HASHTABLE"):
            case("LINKEDHASHMAP"):
            case("TREEMAP"): CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP_TREEMAP.remove(obj, 0); break;

            case("HASHSET"):
            case("LINKEDHASHSET"):
            case("TREESET"): CrudOperation.HASHSET_LINKEDHASHSET_TREESET.remove(obj, 0); break;

            case("PRIORITYQUEUE"): CrudOperation.PRIORITYQUEUE.remove(obj, 0); break;
        }
        End("remove");
    }

    public void update() throws IOException {
        Object obj = getCollection();
        Start("update");
        Animal tmp = new Animal();

        switch(this.CollectionType)
        {
            case("LINKEDLIST"):
            case("ARRAYLIST"):
            case("VECTOR"): CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.update(obj, tmp); break;

            case("HASHMAP"):
            case("HASHTABLE"):
            case("LINKEDHASHMAP"):
            case("TREEMAP"): CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP_TREEMAP.update(obj, tmp); break;

            case("HASHSET"):
            case("LINKEDHASHSET"):
            case("TREESET"): CrudOperation.HASHSET_LINKEDHASHSET_TREESET.update(obj, tmp); break; 

            case("PRIORITYQUEUE"): CrudOperation.PRIORITYQUEUE.update(obj, tmp); break;
        }
        End("update");
    }

    public void iterate() throws IOException {
        Object obj = getCollection();
        Start("iterate");

        switch(this.CollectionType)
        {
            case("LINKEDLIST"):
            case("ARRAYLIST"):
            case("VECTOR"): CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.iterate(obj); break;

            case("HASHMAP"):
            case("HASHTABLE"):
            case("LINKEDHASHMAP"):
            case("TREEMAP"): CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP_TREEMAP.iterate(obj); break;

            case("HASHSET"):
            case("LINKEDHASHSET"):
            case("TREESET"): CrudOperation.HASHSET_LINKEDHASHSET_TREESET.iterate(obj); break;  

            case("PRIORITYQUEUE"): CrudOperation.PRIORITYQUEUE.iterate(obj); break;
        }

        End("iterate");
    }
}
