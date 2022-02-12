package DataStructures;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

enum CrudOperation {
    LINKEDLIST_ARRAYLIST_VECTOR {
        @Override
        public void add(Object Structure, Animal tmp) {
            List Dt = (List) Structure;
            int cnt = Dt.size() + 1;
            tmp.ID = Integer.toString(cnt);
            Dt.add(tmp);
        }

        @Override
        public void remove(Object tmp, int index) {
            List Dt = (List) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            Animal Rm = (Animal) Dt.get(0);
            Rm.PrintAnimal();
            Dt.remove(index);
        }

        @Override
        public void update(Object Structure, Animal tmp) {
            List Dt = (List) Structure;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            Animal Rm = (Animal) Dt.get(0);
            tmp.ShowOld(Rm);
            Dt.set(0, tmp);
        }

        @Override
        public void iterate(Object tmp) {
            List Dt = (List) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            for (Object Obj : Dt) {
                Animal An = (Animal) Obj;
                An.PrintAnimal();
            }
        }
    },

    HASHTABLE_HASHMAP_LINKEDHASHMAP_TREEMAP {
        @Override
        public void add(Object Structure, Animal tmp) {
            Map Dt = (Map) Structure;
            Dt.put(tmp.hashCode(), tmp);
        }

        @Override
        public void remove(Object tmp, int index) {
            Map Dt = (Map) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            Animal Rm = (Animal) Dt.get(0);
            Rm.PrintAnimal();
            Dt.remove(index);
        }

        @Override
        public void update(Object Structure, Animal tmp) {
            Map Dt = (Map) Structure;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            tmp.PrintAnimal();
            Dt.put(tmp.hashCode(), tmp);
        }

        @Override
        public void iterate(Object tmp) {
            Map Dt = (Map) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            for (Object Obj : Dt.values()) {
                Animal An = (Animal) Obj;
                An.PrintAnimal();
            }
        }
    },

    HASHSET_LINKEDHASHSET_TREESET {
        @Override
        public void add(Object Structure, Animal tmp) {
            Set Dt = (Set) Structure;
            int cnt = Dt.size();
            tmp.ID = Integer.toString(cnt);
            Dt.add(tmp);
        }

        @Override
        public void remove(Object tmp, int index) {
            Set Dt = (Set) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            Animal Rm = (Animal) Dt.iterator().next();
            Rm.PrintAnimal();
            Dt.remove(index);
        }

        @Override
        public void update(Object Structure, Animal tmp) {
            Set Dt = (Set) Structure;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            tmp.PrintAnimal();
            Dt.add(tmp);
        }

        @Override
        public void iterate(Object tmp) {
            Set Dt = (Set) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            for (Object Obj : Dt) {
                Animal An = (Animal) Obj;
                An.PrintAnimal();
            }
        }
    },
    PRIORITYQUEUE {
        @Override
        public void add(Object Structure, Animal tmp) {
            PriorityQueue Dt = (PriorityQueue) Structure;
            Dt.add(tmp);
        }

        @Override
        public void remove(Object tmp, int index) {
            PriorityQueue Dt = (PriorityQueue) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            Animal Rm = (Animal) Dt.iterator().next();
            Rm.PrintAnimal();
            Dt.remove(index);
        }

        @Override
        public void update(Object Structure, Animal tmp) {
            PriorityQueue Dt = (PriorityQueue) Structure;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            tmp.PrintAnimal();
            Dt.add(tmp);
        }

        @Override
        public void iterate(Object tmp) {
            PriorityQueue Dt = (PriorityQueue) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            for (Object Obj : Dt) {
                Animal An = (Animal) Obj;
                An.PrintAnimal();
            }
        }
    };

    public abstract void add(Object Structure, Animal tmp);
    public abstract void remove(Object tmp, int index);
    public abstract void update(Object Structure, Animal tmp);
    public abstract void iterate(Object Structure);
}