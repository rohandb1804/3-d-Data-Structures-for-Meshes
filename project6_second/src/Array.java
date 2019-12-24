public class Array<T> implements Comparable<T>{
    Object[] objects;
    int DEFAULT=10;
    int size;

    Array(){
        objects=new Object[DEFAULT];
        size=0;
    }

    public T get(int index){
        if(checkinputsize(index)){
            return (T)objects[index];
        }
        else{
            return null;
        }
    }

    public boolean contains(Object obj){
        return indexof(obj)>=0;
    }

    public int indexof(Object obj){
        if(obj!=null){
            for(int i=0;i<size;i++){

                if(((T)obj).equals(objects[i])){
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    public void add(Object o){
      /* if (this.contains(o)) {
            return;
        }*/
        if(rangecheck()==false){
            objects=(Object[])resize(objects,DEFAULT*2);
            DEFAULT=DEFAULT*2;

        }
        objects[size++]=o;



    }


    public boolean checkinputsize(int input){
        if(input<size && input>=0){
            return true;
        }
        else{
            return false;
        }

    }
    public boolean rangecheck(){
        if(size<DEFAULT){
            return true;
        }
        else{
            return false;
        }
    }

    public Object resize(Object o, int newcapacity){
        int presentsize = java.lang.reflect.Array.getLength(o);
        Class classvalue= o.getClass().getComponentType();
        Object newarray = java.lang.reflect.Array.newInstance(classvalue, newcapacity);
        int length = Math.min(presentsize, newcapacity);
        if (length > 0)
            System.arraycopy(o, 0, newarray, 0, length);
        return newarray;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
