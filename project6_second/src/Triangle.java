

public class Triangle implements TriangleInterface,Comparable<Triangle> {


    Edge[] triangle_edges;
    Point[] pointInterface;
    int id;
    Triangle(Point point1, Point point2, Point point3){

        id=0;
        triangle_edges=new Edge[3];
        pointInterface=new Point[]{point1,point2,point3};


    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || obj.getClass()!=this.getClass()){
            return true;
        }
        Triangle triangle=(Triangle)obj;
     /*   return (pointInt erface[0].equals(triangle.pointInterface[0]) && pointInterface[1].equals(triangle.pointInterface[1]) &&
                pointInterface[2].equals(triangle.pointInterface[2]));*/
        //System.out.println(triangle);
        //  System.out.println(this.toString());
        //   System.out.println();
        if(pointInterface[0].equals(triangle.pointInterface[0])){

            if(pointInterface[1].equals(triangle.pointInterface[1])){

                if(pointInterface[2].equals(triangle.pointInterface[2])){
                    return true;
                }else{

                    return false;
                }
            }
            else if(pointInterface[1].equals(triangle.pointInterface[2])){

                if(pointInterface[2].equals(triangle.pointInterface[1])){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else if(pointInterface[0].equals(triangle.pointInterface[1])){

            if(pointInterface[1].equals(triangle.pointInterface[0])){
                if(pointInterface[2].equals(triangle.pointInterface[2])){
                    return true;
                }else{
                    return false;
                }
            }
            else if(pointInterface[1].equals(triangle.pointInterface[2])){
                if(pointInterface[2].equals(triangle.pointInterface[0])){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;
            }

        }

        else if(pointInterface[0].equals(triangle.pointInterface[2])){
            if(pointInterface[1].equals(triangle.pointInterface[0])){
                if(pointInterface[2].equals(triangle.pointInterface[1])){
                    return true;
                }else{
                    return false;
                }
            }
            else if(pointInterface[1].equals(triangle.pointInterface[1])){
                if(pointInterface[2].equals(pointInterface[0])){
                    return true;
                }else{
                    return false;
                }
            }

            else{
                return false;
            }
        }
        else{
            return false;
        }
    }


    void BFS(Triangle triangle, boolean[] visited){

        Queue<Triangle> triangleQueue=new Queue<>();
        visited[triangle.id]=true;
        triangleQueue.enqueue(triangle);
        while (!triangleQueue.isEmpty()){
            Triangle triangle1=triangleQueue.dequeue();
            //  System.out.println(triangle1);
            Array<Triangle> neighbors_edge1=triangle1.triangle_edges[0].neighbourTriangles;
            for(int i=0;i<neighbors_edge1.size;i++){
                Triangle triangle2=neighbors_edge1.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    triangleQueue.enqueue(triangle2);
                }

            }
            Array<Triangle> neighbors_edge2=triangle1.triangle_edges[1].neighbourTriangles;
            for(int i=0;i<neighbors_edge2.size;i++){
                Triangle triangle2=neighbors_edge2.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    triangleQueue.enqueue(triangle2);
                }

            }

            Array<Triangle> neighbors_edge3=triangle1.triangle_edges[2].neighbourTriangles;
            for(int i=0;i<neighbors_edge3.size;i++){
                Triangle triangle2=neighbors_edge3.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    triangleQueue.enqueue(triangle2);
                }

            }
        }

    }



    int hoplength(int p, int k){
        boolean[] visited=new boolean[p];
     /*     for(int i=0;i<visited.length;i++){
             visited[i]=false;
        }*/

        int[] distance=new int[p];
       /* for(int i=0;i<distance.length;i++){
            distance[i]=0;
        }*/
        // long start=System.nanoTime();
        Queue<Triangle> triangleQueue=new Queue<>();
        visited[this.id]=true;
        triangleQueue.enqueue(this);
        while (!triangleQueue.isEmpty()){
            Triangle triangle1=triangleQueue.dequeue();
            /*if(triangle1.equals(triangle)){
                return count;
            }*/
            // System.out.println(triangle1);
            Array<Triangle> neighbors_edge1=triangle1.triangle_edges[0].neighbourTriangles;
            for(int i=0;i<neighbors_edge1.size;i++){
                Triangle triangle2=neighbors_edge1.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    distance[triangle2.id]=distance[triangle1.id]+1;
                    triangleQueue.enqueue(triangle2);

                }

            }
            Array<Triangle> neighbors_edge2=triangle1.triangle_edges[1].neighbourTriangles;
            for(int i=0;i<neighbors_edge2.size;i++){
                Triangle triangle2=neighbors_edge2.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    distance[triangle2.id]=distance[triangle1.id]+1;
                    triangleQueue.enqueue(triangle2);

                }

            }

            Array<Triangle> neighbors_edge3=triangle1.triangle_edges[2].neighbourTriangles;
            for(int i=0;i<neighbors_edge3.size;i++){
                Triangle triangle2=neighbors_edge3.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    distance[triangle2.id]=distance[triangle1.id]+1;
                    triangleQueue.enqueue(triangle2);

                }

            }
            //        max=max(p1,p2,p3);

        }





        int maxd=0;
        for(int i=0;i<distance.length;i++){
            if(distance[i]>maxd){
                maxd=distance[i];
                if(maxd==k){
                    return k;
                }
            }
        }

        // System.out.println(integerAVLTree.root.height);
        //integerAVLTree.inOrder(integerAVLTree.root);
        // Integer maxd=integerAVLTree.getMax();
        // long end=System.nanoTime();
        //  System.out.println(start-end);



        return maxd;

    }





    boolean isConnected(Triangle neighborTriangle, boolean[] visited){
        Queue<Triangle> triangleQueue=new Queue<>();
        visited[this.id]=true;
        triangleQueue.enqueue(this);
        while (!triangleQueue.isEmpty()){
            Triangle triangle1=triangleQueue.dequeue();
            if(triangle1.compareTo(neighborTriangle)==0){
                return true;
            }
            // System.out.println(triangle1);
            Array<Triangle> neighbors_edge1=triangle1.triangle_edges[0].neighbourTriangles;
            for(int i=0;i<neighbors_edge1.size;i++){
                Triangle triangle2=neighbors_edge1.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    triangleQueue.enqueue(triangle2);
                }

            }
            Array<Triangle> neighbors_edge2=triangle1.triangle_edges[1].neighbourTriangles;
            for(int i=0;i<neighbors_edge2.size;i++){
                Triangle triangle2=neighbors_edge2.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    triangleQueue.enqueue(triangle2);
                }

            }

            Array<Triangle> neighbors_edge3=triangle1.triangle_edges[2].neighbourTriangles;
            for(int i=0;i<neighbors_edge3.size;i++){
                Triangle triangle2=neighbors_edge3.get(i);
                if(!visited[triangle2.id]){
                    visited[triangle2.id]=true;
                    triangleQueue.enqueue(triangle2);
                }

            }
        }
        return false;
    }


    @Override
    public PointInterface[] triangle_coord() {
        return pointInterface;
    }

    @Override
    public String toString() {
        return "["+ pointInterface[0] + ","+ pointInterface[1] + ","+ pointInterface[2]+ "]";
    }

    @Override
    public int compareTo(Triangle o) {
        if(pointInterface[0].compareTo(o.pointInterface[0])==0){
            if(pointInterface[1].compareTo(o.pointInterface[1])==0){
                if(pointInterface[2].compareTo(o.pointInterface[2])==0){
                    return 0;
                }else{
                    if(o.pointInterface[2].compareTo(this.pointInterface[2])>0){
                        return 1;

                    }else{
                        return -1;
                    }
                }
            }else{
                if(o.pointInterface[1].compareTo(this.pointInterface[1])>0){
                    return 1;
                }else {
                    return -1;
                }
            }
        }else{
            if(o.pointInterface[0].compareTo(this.pointInterface[0])>0){
                return 1;
            }else {
                return -1;
            }
        }
    }
}
