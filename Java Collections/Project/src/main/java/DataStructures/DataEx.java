package DataStructures;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class DataEx 
{
    LinkedList<Animal> AnimaLinkedList = new LinkedList<>();
    ArrayList<Animal> AnimaArrayList  = new ArrayList<>();
    Vector<Animal> AnimaVector     = new Vector<>();
    Hashtable<String, Animal> AnimaHashTable = new Hashtable<>();
    HashMap<String, Animal> AnimaHashMap = new HashMap<>();
    LinkedHashMap<String, Animal> AnimaLinkedHashMap = new LinkedHashMap<>();

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
            default:
                return null;
        }
    }


    enum CrudOperation
    {
        LINKEDLIST_ARRAYLIST_VECTOR
        {
            @Override
            public void add(Object Structure, Animal tmp) 
            {
                List Dt = (List) Structure; 
                Dt.add(tmp);
            }

            @Override
            public void remove(Object tmp,int index) 
            {
                List Dt = (List) tmp; 
                if(Dt.size() == 0)
                {
                    System.out.println("Collection is empty!");
                    return;
                }
                Animal Rm = (Animal) Dt.get(0);
                Rm.PrintAnimal();
                Dt.remove(index);
            }

            @Override 
            public void update(Object Structure, Animal tmp) 
            {
                List Dt = (List) Structure; 
                if(Dt.size() == 0)
                {
                    System.out.println("Collection is empty!");
                    return;
                }
                tmp.PrintAnimal();
                Dt.set(0, tmp);
            }

            @Override
            public void iterate(Object tmp) 
            {
                List Dt = (List) tmp;
                if(Dt.size() == 0)
                {
                    System.out.println("Collection is empty!");
                    return;
                }
                for (Object Obj : Dt) 
                {
                    Animal An = (Animal) Obj;
                    An.PrintAnimal();
                }
            }            
        },
        HASHTABLE_HASHMAP_LINKEDHASHMAP
        {
            @Override
            public void add(Object Structure, Animal tmp) 
            {
                Map Dt = (Map) Structure; 
                Dt.put(tmp.hashCode(), tmp);
            }

            @Override
            public void remove(Object tmp,int index) 
            {
                Map Dt = (Map) tmp; 
                if(Dt.size() == 0)
                {
                    System.out.println("Collection is empty!");
                    return;
                }
                Animal Rm = (Animal) Dt.get(0);
                Rm.PrintAnimal();
                Dt.remove(index);
            }

            @Override 
            public void update(Object Structure, Animal tmp) 
            {
                Map Dt = (Map) Structure; 
                if(Dt.size() == 0)
                {
                    System.out.println("Collection is empty!");
                    return;
                }
                tmp.PrintAnimal();
                Dt.put(tmp.hashCode(), tmp);
            }

            @Override
            public void iterate(Object tmp) 
            {
                Map Dt = (Map) tmp;
                if(Dt.size() == 0)
                {
                    System.out.println("Collection is empty!");
                    return;
                }
                for (Object Obj : Dt.values()) 
                {
                    Animal An = (Animal) Obj;
                    An.PrintAnimal();
                }
            }            
        };

    
        public abstract void add(Object Structure, Animal tmp);
        public abstract void remove(Object tmp,int index);
        public abstract void update(Object Structure, Animal tmp);
        public abstract void iterate(Object Structure);
    }

    // CRUD
    public void add() throws IOException 
    {
        Object obj = getCollection();
        Animal tmp = new Animal();
        Start("add");
        if(this.CollectionType.matches("LINKEDLIST|ARRAYLIST|VECTOR"))
        {
            CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.add(obj, tmp);
        }
        if(this.CollectionType.matches("HASHTABLE|HASHMAP|LINKEDHASHMAP"))
        {
            CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP.add(obj, tmp);
        }
        else
        {
            CrudOperation.valueOf(this.CollectionType).add(obj, tmp);
        }
        End("add");
        CrudOperation.valueOf(this.CollectionType).add(obj, tmp);
        tmp.PrintAnimal();
        End("add");
    }

    public void remove() throws IOException 
    {
        Object obj = getCollection();
        Start("remove");
        if(this.CollectionType.matches("LINKEDLIST|ARRAYLIST|VECTOR"))
        {
            CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.remove(obj, 0);
        }
        if(this.CollectionType.matches("HASHTABLE|HASHMAP|LINKEDHASHMAP"))
        {
            CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP.remove(obj, 0);
        }
        else
        {
            CrudOperation.valueOf(this.CollectionType).remove(obj, 0);
        }
        End("remove");
    }

    public void update() throws IOException {
        Object obj = getCollection();
        Start("update");
        Animal tmp = new Animal();
        if(this.CollectionType.matches("LINKEDLIST|ARRAYLIST|VECTOR"))
        {
            CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.update(obj, tmp);
        }
        if(this.CollectionType.matches("HASHTABLE|HASHMAP|LINKEDHASHMAP"))
        {
            CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP.update(obj, tmp);
        }
        else
        {
            CrudOperation.valueOf(this.CollectionType).update(obj, tmp);
        }
        End("update");
    }

    public void iterate() throws IOException {
        Object obj = getCollection();
        Start("iterate");
        if(this.CollectionType.matches("LINKEDLIST|ARRAYLIST|VECTOR"))
        {
            CrudOperation.LINKEDLIST_ARRAYLIST_VECTOR.iterate(obj);
        }
        if(this.CollectionType.matches("HASHTABLE|HASHMAP|LINKEDHASHMAP"))
        {
            CrudOperation.HASHTABLE_HASHMAP_LINKEDHASHMAP.iterate(obj);
        }
        else
        {
            CrudOperation.valueOf(this.CollectionType).iterate(obj);
        }
        End("iterate");
    }
}
