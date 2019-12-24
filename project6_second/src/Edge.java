

public class Edge implements EdgeInterface,Comparable<Edge>{


    Point source;
    Point dest;
    Array<Triangle> neighbourTriangles=new Array<>();
    float distance;
    /* private PointInterface[] pointInterfaces=new PointInterface[2];*/

    Edge(Point point1, Point point2){
        this.source=point1;
        this.dest=point2;
        distance=Euclidean_distance(source,dest);
       /* pointInterfaces[0]=point1;
        pointInterfaces[1]=point2;*/

    }
    public PointInterface[] edgeEndPoints() {
        return new PointInterface[]{source,dest};
    }


    @Override
    public boolean equals(Object obj) {
        if(obj==null && obj.getClass()!=this.getClass()){
            return false;
        }
        Edge edge=(Edge)obj;
        if((edge.source.equals(source) && edge.dest.equals(dest)) || edge.source.equals(dest) && edge.dest.equals(source) ){

            return true;
        }else{
            return false;
        }

    }

    @Override
    public int compareTo(Edge o) {
        if(o.source.compareTo(this.source)==0){
            if(o.dest.compareTo(this.dest)==0){
                return 0;
            }else{
                if(o.dest.compareTo(this.dest)>0){
                    return 1;
                }else{
                    return -1;
                }
            }
        }else{
            if(o.source.compareTo(this.source)>0){
                return 1;
            }else{
                return -1;
            }
        }

    }

    @Override
    public String toString() {
        return "["+ source.toString()+"," +dest.toString()+"]";
    }

    private  float square(float a){
        return a*a;
    }

    private float Euclidean_distance(Point point1, Point point2){

        return ((float)(Math.sqrt(square(point1.x-point2.x)+ square(point1.y-point2.y)+ square(point1.z-point2.z))));

    }


    public int compare(Edge o) {

        if (Euclidean_distance(o.source, o.dest) == 0) {
            return 0;
        } else {
            if (Euclidean_distance(o.source, o.dest) > this.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    }


}
