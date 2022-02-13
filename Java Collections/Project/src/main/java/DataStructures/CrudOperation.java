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
            index = Dt.size() - 1;
            Animal Rm = (Animal) Dt.get(index);
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
            int cnt = Dt.size() + 1;
            tmp.ID = Integer.toString(cnt);
            Dt.put(tmp.ID, tmp);
        }

        @Override
        public void remove(Object tmp, int index) {
            Map Dt = (Map) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            
            String Key = Integer.toString(Dt.size());
            Animal Rm = (Animal) Dt.get(Key);
            Rm.PrintAnimal();
            Dt.remove(Key);
        }

        @Override
        public void update(Object Structure, Animal tmp) {
            Map Dt = (Map) Structure;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            Animal OldAni = (Animal) Dt.get("1");
            tmp.ID = OldAni.ID;
            tmp.ShowOld(OldAni);
            Dt.put(tmp.ID, tmp);
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
                System.out.println("HashCode: " + An.hashCode());
                An.PrintAnimal();
            }
        }
    },

    HASHSET_LINKEDHASHSET_TREESET {
        @Override
        public void add(Object Structure, Animal tmp) {
            Set Dt = (Set) Structure;
            int cnt = Dt.size() + 1;
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

            String Key = Integer.toString(Dt.size());
            Animal An = null;
            for(Object Obj : Dt){

                An = (Animal) Obj;
                if(An.ID.equals(Key)){
                    An.PrintAnimal();
                    break;
                }
            }
            Dt.remove(An);
        }

        @Override
        public void update(Object Structure, Animal tmp) {
            Set Dt = (Set) Structure;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }

            String Key = Integer.toString(1);
            Animal OldAnimal = null;
            for(Object Obj : Dt){

                OldAnimal = (Animal) Obj;
                if(OldAnimal.ID.equals(Key)){
                    break;
                }
            }
            tmp.ShowOld(OldAnimal);
            tmp.ID = OldAnimal.ID;
            Dt.remove(OldAnimal);
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
            int cnt = Dt.size() + 1;
            tmp.ID = Integer.toString(cnt);
            Dt.add(tmp);
        }

        @Override
        public void remove(Object tmp, int index) {
            PriorityQueue Dt = (PriorityQueue) tmp;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
            Animal Rm = (Animal) Dt.poll();
            Rm.PrintAnimal();

        }

        @Override
        public void update(Object Structure, Animal tmp) {
            PriorityQueue Dt = (PriorityQueue) Structure;
            if (Dt.size() == 0) {
                System.out.println("Collection is empty!");
                return;
            }
   
            Animal Rm = (Animal) Dt.poll();
            Rm.ShowOld(tmp);
            tmp.ID = Rm.ID;
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