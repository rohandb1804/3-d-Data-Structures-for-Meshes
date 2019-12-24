
public class Shape implements ShapeInterface {

    AVLTree<Point> pointAVLTree=new AVLTree<>();
    AVLTree<Edge> edgeAVLTree=new AVLTree<>();
    AVLTree<Triangle> triangleAVLTree=new AVLTree<>();
    Array<Triangle> shapeTriangles = new Array<>();
    Array<Point> pointArray = new Array<>();
    Array<Edge> edgeArray = new Array<>();
    Array<Component> componentArray = new Array<>();
    int idcount = 0;


    private Point[] sort(Point[] arr){
        if (arr[1].compareTo(arr[0])>0) {
            Point tmp=arr[0];
            arr[0]=arr[1];
            arr[1]=tmp;
        }
        // Insert arr[2]
        if (arr[2].compareTo(arr[1])>0)
        {

            Point tmp=arr[1];
            arr[1]=arr[2];
            arr[2]=tmp;
            if (arr[1].compareTo(arr[0])>0) {
                Point tmp1=arr[1];
                arr[1]=arr[0];
                arr[0]=tmp1;
            }
        }
        return arr;

    }
    public boolean ADD_TRIANGLE(float[] triangle_coord) {
        float x1 = triangle_coord[0], y1 = triangle_coord[1], z1 = triangle_coord[2];
        float x2 = triangle_coord[3], y2 = triangle_coord[4], z2 = triangle_coord[5];
        float x3 = triangle_coord[6], y3 = triangle_coord[7], z3 = triangle_coord[8];

        if (((((y2 - y1) * (z3 - z1)) - ((y3 - y1) * (z2 - z1))) == 0) &&
                ((((x3 - x1) * (z2 - z1)) - ((x2 - x1) * (z3 - z1))) == 0) &&
                ((((x2 - x1) * (y3 - y1)) - ((x3 - x1) * (y2 - y1))) == 0)) {
            // System.out.println("dhdh");
            return false;

        }



        //boolean flag1 = false, flag2 = false, flag3 = false;

        Point point1 = new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
        Point point2 = new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
        Point point3 = new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
        Point[] arrayofpoints=new Point[]{point1,point2,point3};
        arrayofpoints=sort(arrayofpoints);
        point1=arrayofpoints[0];
        point2=arrayofpoints[1];
        point3=arrayofpoints[2];


       /* for (int i = 0; i < pointArray.size; i++) {
            if (pointArray.get(i).equals(point1)) {
                flag1 = true;
                point1 = pointArray.get(i);
            }
            if (pointArray.get(i).equals(point2)) {
                flag2 = true;
                point2 = pointArray.get(i);
            }
            if (pointArray.get(i).equals(point3)) {
                flag3 = true;
                point3 = pointArray.get(i);
            }

        }
        if (flag1 == false) {
            pointArray.add(point1);
        }
        if (flag2 == false) {
            pointArray.add(point2);
        }
        if (flag3 == false) {
            pointArray.add(point3);
        }
*/

        if(pointAVLTree.get(point1)!=null){
            point1=pointAVLTree.get(point1);
        }else {
            //  System.out.println(point1);
            pointAVLTree.insert(point1);
            pointArray.add(point1);
        }
        if(pointAVLTree.get(point2)!=null){
            point2=pointAVLTree.get(point2);
        }else{
            //   System.out.println(point2);
            pointAVLTree.insert(point2);
            pointArray.add(point2);
        }
        if(pointAVLTree.get(point3)!=null){
            point3=pointAVLTree.get(point3);
        }else{
            //   System.out.println(point3);
            pointAVLTree.insert(point3);
            pointArray.add(point3);
        }



        Edge edge1 = new Edge(point1, point2);
        Edge edge2 = new Edge(point2, point3);
        Edge edge3 = new Edge(point1, point3);

     /*   boolean flag_edge1 = false, flag_edge2 = false, flag_edge3 = false;
       for (int i = 0; i < edgeArray.size; i++) {
            if (edgeArray.get(i).equals(edge1)) {
                flag_edge1 = true;
                edge1 = edgeArray.get(i);
            }
            if (edgeArray.get(i).equals(edge2)) {
                flag_edge2 = true;
                edge2 = edgeArray.get(i);
            }
            if (edgeArray.get(i).equals(edge3)) {
                flag_edge3 = true;
                edge3 = edgeArray.get(i);
            }

        }
        if (flag_edge1 == false) {
            edgeArray.add(edge1);
        }
        if (flag_edge2 == false) {
            edgeArray.add(edge2);
        }
        if (flag_edge3 == false) {
            edgeArray.add(edge3);
        }*/

        if(edgeAVLTree.get(edge1)!=null){
            edge1=edgeAVLTree.get(edge1);
        }else {
            //System.out.println(edge1);
            edgeAVLTree.insert(edge1);
            edgeArray.add(edge1);
        }

        if(edgeAVLTree.get(edge2)!=null){
            edge2=edgeAVLTree.get(edge2);
        }else{
            // System.out.println(edge2);
            edgeAVLTree.insert(edge2);
            edgeArray.add(edge2);
        }
        if(edgeAVLTree.get(edge3)!=null){
            edge3=edgeAVLTree.get(edge3);
        }else{
            edgeAVLTree.insert(edge3);
            edgeArray.add(edge3);
            // System.out.println(edge3);
        }



        boolean point1flag1 = false, point1flag2 = false;
        for (int i = 0; i < point1.edgeneigbours.size; i++) {
            if (point1.edgeneigbours.get(i).compareTo(edge1)==0) {
                point1flag1 = true;
            }
            if (point1.edgeneigbours.get(i).compareTo(edge3)==0) {
                point1flag2 = true;
            }

        }

        if (!point1flag1) {
            point1.edgeneigbours.add(edge1); //point1,point2
        }
        if (!point1flag2) {
            point1.edgeneigbours.add(edge3);  //point3,point1
        }


        boolean point2flag1 = false, point2flag2 = false;
        for (int i = 0; i < point2.edgeneigbours.size; i++) {
            if (point2.edgeneigbours.get(i).compareTo(edge2)==0) {
                point2flag1 = true;
            }
            if (point2.edgeneigbours.get(i).compareTo(edge1)==0) {
                point2flag2 = true;
            }

        }

        if (!point2flag1) {
            point2.edgeneigbours.add(edge2);  //point2, point3
        }
        if (!point2flag2) {
            point2.edgeneigbours.add(edge1); //point1,point2
        }


        boolean point3flag1 = false, point3flag2 = false;
        for (int i = 0; i < point3.edgeneigbours.size; i++) {
            if (point3.edgeneigbours.get(i).compareTo(edge2)==0) {
                point3flag1 = true;
            }
            if (point3.edgeneigbours.get(i).compareTo(edge3)==0) {
                point3flag2 = true;
            }

        }

        if (!point3flag1) {
            point3.edgeneigbours.add(edge2);
        }
        if (!point3flag2) {
            point3.edgeneigbours.add(edge3);
        }




        Triangle triangle = new Triangle(point1, point2, point3);
        triangle.id = idcount;
        idcount++;
        triangle.triangle_edges[0] = edge1;
        triangle.triangle_edges[1] = edge2;
        triangle.triangle_edges[2] = edge3;
        edge1.neighbourTriangles.add(triangle);
        edge2.neighbourTriangles.add(triangle);
        edge3.neighbourTriangles.add(triangle);
        point1.neighbourTriangles.add(triangle);
        point2.neighbourTriangles.add(triangle);
        point3.neighbourTriangles.add(triangle);
        shapeTriangles.add(triangle);
        triangleAVLTree.insert(triangle);
        if(componentArray.size!=0){
            componentArray=new Array<>();
        }
        // System.out.println(pointArray.size);
        //  Array<Component> componentArray=new Array<>();
        return true;
    }

    public EdgeInterface[] EDGE_NEIGHBORS_OF_POINT(float[] point_coordinates) {

        Point point = new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
        EdgeInterface[] edgeInterfaces1 = new EdgeInterface[]{};

        Point point1=pointAVLTree.get(point);
        if(point1!=null){
            edgeInterfaces1=new EdgeInterface[point1.edgeneigbours.size];
            for (int c = 0; c < point1.edgeneigbours.size; c++) {
               // System.out.println(point1.edgeneigbours.get(c));
                edgeInterfaces1[c] = point1.edgeneigbours.get(c);
            }

        }else{
            return null;
        }

        /*for(int i=0;i<edgeInterfaces1.length;i++){
            System.out.println(edgeInterfaces1[i]);
        }*/


        return edgeInterfaces1;
    }


    public PointInterface[] NEIGHBORS_OF_POINT(float[] point_coordinates) {
        PointInterface[] pointInterfaces = new PointInterface[12];
        Point point = new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
        int count = 0;
        Point point1=pointAVLTree.get(point);
        pointInterfaces=new PointInterface[point1.edgeneigbours.size];
        if(point1!=null){
            for (int j = 0; j <point1.edgeneigbours.size; j++) {

                if (point1.edgeneigbours.get(j).source.equals(point)) {
                  //  System.out.println(point1.edgeneigbours.get(j).dest);
                    pointInterfaces[count] = point1.edgeneigbours.get(j).dest;
                } else {
                    //System.out.println(point1.edgeneigbours.get(j).source);
                    pointInterfaces[count] = point1.edgeneigbours.get(j).source;
                }
                count++;
            }
        }else{
            return null;
        }

        /*for(int i=0;i<pointInterfaces.length;i++){
            System.out.println(pointInterfaces[i]);
        }*/
        return pointInterfaces;


    }

    public TriangleInterface[] INCIDENT_TRIANGLES(float[] point_coordinates) {

        Point point = new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
        if(pointAVLTree.get(point)!=null){
            point=pointAVLTree.get(point);
        }else{
            return null;
        }

        TriangleInterface[] triangleInterfaces = new TriangleInterface[point.neighbourTriangles.size];
        for (int j = 0; j < point.neighbourTriangles.size; j++) {
          //  System.out.println(point.neighbourTriangles.get(j));
            triangleInterfaces[j] = point.neighbourTriangles.get(j);
        }

        /*for(int i=0;i<triangleInterfaces.length;i++){
            System.out.println(triangleInterfaces[i]);
        }*/



        return triangleInterfaces;


    }


    public EdgeInterface[] EDGE_NEIGHBOR_TRIANGLE(float[] triangle_coord) {

        EdgeInterface[] edgeInterfaces = new EdgeInterface[3];
        Triangle triangle = new Triangle(new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]),
                new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]),
                new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]));

        Point point1 = new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
        Point point2 = new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
        Point point3 = new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
        Point[] arrayofpoints=new Point[]{point1,point2,point3};
        arrayofpoints=sort(arrayofpoints);
        point1=arrayofpoints[0];
        point2=arrayofpoints[1];
        point3=arrayofpoints[2];
        triangle=new Triangle(point1,point2,point3);


      /*  for (int i = 0; i < shapeTriangles.size; i++) {
            if (shapeTriangles.get(i).equals(triangle)) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(shapeTriangles.get(i).triangle_edges[j]);
                    edgeInterfaces[j] = shapeTriangles.get(i).triangle_edges[j];

                }
            }
            break;
        }

        System.out.println();*/

        Triangle triangle1=triangleAVLTree.get(triangle);
        if(triangle1!=null){
            for (int j = 0; j < 3; j++) {
          //      System.out.println(triangle1.triangle_edges[j]);
                edgeInterfaces[j] = triangle1.triangle_edges[j];

            }
        }else{
            return null;
        }


        return edgeInterfaces;

    }


    public PointInterface[] VERTEX_NEIGHBOR_TRIANGLE(float[] triangle_coord) {

        PointInterface[] pointInterfaces = new PointInterface[3];
        Point point1 = new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
        Point point2 = new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
        Point point3 = new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
        Point[] arrayofpoints=new Point[]{point1,point2,point3};
        arrayofpoints=sort(arrayofpoints);
        point1=arrayofpoints[0];
        point2=arrayofpoints[1];
        point3=arrayofpoints[2];
        Triangle triangle=new Triangle(point1,point2,point3);


      /*  for (int i = 0; i < shapeTriangles.size; i++) {
            if (shapeTriangles.get(i).equals(triangle)) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(shapeTriangles.get(i).pointInterface[j]);
                    pointInterfaces[j] = shapeTriangles.get(i).pointInterface[j];

                }
                break;
            }
        }
        System.out.println();*/

        Triangle triangle1=triangleAVLTree.get(triangle);
        if(triangle1!=null){
            for (int j = 0; j < 3; j++) {
            //    System.out.println(triangle1.pointInterface[j]);
                pointInterfaces[j] = triangle1.pointInterface[j];

            }
        }else{
            return null;
        }
        return pointInterfaces;
    }


    public TriangleInterface[] TRIANGLE_NEIGHBOR_OF_EDGE(float[] edge_coordinates) {
        Point point1=new Point(edge_coordinates[0], edge_coordinates[1], edge_coordinates[2]);
        Point point2=new Point(edge_coordinates[3], edge_coordinates[4], edge_coordinates[5]);
        Edge edge = new Edge(point1,point2);
        int size = 0;
        TriangleInterface[] triangleInterfaces = new TriangleInterface[]{};
        int count = 0;
        boolean flag=false;
        for (int i = 0; i < edgeArray.size; i++) {
            if (edgeArray.get(i).equals(edge)) {
                flag=true;
                size = edgeArray.get(i).neighbourTriangles.size;
                triangleInterfaces = new TriangleInterface[size];
                for (int j = 0; j < edgeArray.get(i).neighbourTriangles.size; j++) {
                //    System.out.println(edgeArray.get(i).neighbourTriangles.get(count));
                    triangleInterfaces[count] = edgeArray.get(i).neighbourTriangles.get(count);
                    count++;
                }
                break;
            }
        }
        if(flag==false){
            return null;
        }
        return triangleInterfaces;

       /* Edge edge1=edgeAVLTree.get(edge);
        System.out.println(edge1);
        if(edge1!=null){
            triangleInterfaces=new TriangleInterface[edge1.neighbourTriangles.size];
            for (int j = 0; j < edge1.neighbourTriangles.size; j++) {
                System.out.println(edge1.neighbourTriangles.get(count));
                triangleInterfaces[count] = edge1.neighbourTriangles.get(count);
                count++;
            }
        }else{
            return null;
        }*/

    }


    public int COUNT_CONNECTED_COMPONENTS() {

        if(componentArray.size==0){
            createComponents();
        }
        int components = 0;
        boolean[] visited = new boolean[shapeTriangles.size];
        for (int i = 0; i < shapeTriangles.size; i++) {
            // System.out.println(shapeTriangles.get(i)+ "-");
            //  System.out.println();
            if (!visited[shapeTriangles.get(i).id]) {
                components++;
                shapeTriangles.get(i).BFS(shapeTriangles.get(i), visited);
            }
        }


        return components;

    }

    public boolean IS_CONNECTED(float[] triangle_coord_1, float[] triangle_coord_2) {
        PointInterface[] pointInterfaces = new PointInterface[3];
        Point point1 = new Point(triangle_coord_1[0], triangle_coord_1[1], triangle_coord_1[2]);
        Point point2 = new Point(triangle_coord_1[3], triangle_coord_1[4], triangle_coord_1[5]);
        Point point3 = new Point(triangle_coord_1[6], triangle_coord_1[7], triangle_coord_1[8]);
        Point[] arrayofpoints=new Point[]{point1,point2,point3};
        arrayofpoints=sort(arrayofpoints);
        point1=arrayofpoints[0];
        point2=arrayofpoints[1];
        point3=arrayofpoints[2];
        Triangle triangle1=new Triangle(point1,point2,point3);


        Point point4 = new Point(triangle_coord_2[0], triangle_coord_2[1], triangle_coord_2[2]);
        Point point5 = new Point(triangle_coord_2[3], triangle_coord_2[4], triangle_coord_2[5]);
        Point point6 = new Point(triangle_coord_2[6], triangle_coord_2[7], triangle_coord_2[8]);
        Point[] arrayofpoints1=new Point[]{point4,point5,point6};
        arrayofpoints1=sort(arrayofpoints1);
        point4=arrayofpoints1[0];
        point5=arrayofpoints1[1];
        point6=arrayofpoints1[2];
        Triangle triangle2=new Triangle(point4,point5,point6);

        // System.out.println("triangle1:"+ triangle1);
        // System.out.println("triangle2:"+ triangle2);
        if (triangleAVLTree.get(triangle1)==null || triangleAVLTree.get(triangle2)==null) {
            return false;
        }
        /*for (int i = 0; i < shapeTriangles.size; i++) {
            if (shapeTriangles.get(i).equals(triangle1)) {
                triangle1 = shapeTriangles.get(i);
            }
            if (shapeTriangles.get(i).equals(triangle2)) {
                triangle2 = shapeTriangles.get(i);
            }
        }*/

        triangle1=triangleAVLTree.get(triangle1);
        triangle2=triangleAVLTree.get(triangle2);
        boolean[] visited = new boolean[shapeTriangles.size];
        /*for (boolean b : visited) {
            b = false;
        }*/

      //  System.out.println(triangle1);
      //  System.out.println(triangle2);
        boolean p = triangle1.isConnected(triangle2, visited);
        //System.out.println(p);
        return p;
    }

    public int TYPE_MESH() {
        boolean flag = false;
        boolean flag1 = false;
        for (int i = 0; i < edgeArray.size; i++) {
            //   System.out.println(edgeArray.get(i));
            int size = edgeArray.get(i).neighbourTriangles.size;
            //  System.out.println(size);
            if (size > 2) {
                return 3;
            } else if (size == 1) {
                flag1 = true;
            }
        }
        if (flag1) {
            return 2;
        } else {
            return 1;
        }


    }



    public TriangleInterface[] FACE_NEIGHBORS_OF_POINT(float[] point_coordinates) {
        TriangleInterface[] triangleInterfaces = new TriangleInterface[]{};
        Point point = new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
        if(pointAVLTree.get(point)!=null){
            point=pointAVLTree.get(point);
        }else{
            return null;
        }

        triangleInterfaces = new TriangleInterface[point.neighbourTriangles.size];
        for (int j = 0; j < point.neighbourTriangles.size; j++) {
          // System.out.println(point.neighbourTriangles.get(j));
            triangleInterfaces[j] = point.neighbourTriangles.get(j);
        }




        return triangleInterfaces;
    }


    public TriangleInterface[] NEIGHBORS_OF_TRIANGLE(float[] triangle_coord) {

        //long start=System.nanoTime();
        PointInterface[] pointInterfaces = new PointInterface[3];
        Point point1 = new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
        Point point2 = new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
        Point point3 = new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
        Point[] arrayofpoints=new Point[]{point1,point2,point3};
        arrayofpoints=sort(arrayofpoints);
        point1=arrayofpoints[0];
        point2=arrayofpoints[1];
        point3=arrayofpoints[2];
        Triangle triangle=new Triangle(point1,point2,point3);

        Array<Triangle> triangleArray_edge1 = new Array<>();
        Array<Triangle> triangleArray_edge2 = new Array<>();
        Array<Triangle> triangleArray_edge3 = new Array<>();

        Triangle triangle1=triangleAVLTree.get(triangle);
        if(triangle1!=null) {
            for (int j = 0; j < triangle1.triangle_edges[0].neighbourTriangles.size; j++) {
                if (!triangle1.triangle_edges[0].neighbourTriangles.get(j).equals(triangle)) {
                    triangleArray_edge1.add(triangle1.triangle_edges[0].neighbourTriangles.get(j));
                }

            }
            for (int j = 0; j < triangle1.triangle_edges[1].neighbourTriangles.size; j++) {
                if (!triangle1.triangle_edges[1].neighbourTriangles.get(j).equals(triangle)) {

                    triangleArray_edge2.add(triangle1.triangle_edges[1].neighbourTriangles.get(j));
                }
            }

            for (int j = 0; j < triangle1.triangle_edges[2].neighbourTriangles.size; j++) {
                if (!triangle1.triangle_edges[2].neighbourTriangles.get(j).equals(triangle)) {

                    triangleArray_edge3.add(triangle1.triangle_edges[2].neighbourTriangles.get(j));

                }
            }
        }
        else {
            return null;
        }




        Array<Triangle> merger12=merge(triangleArray_edge1,triangleArray_edge2);
        Array<Triangle> merger123=merge(merger12,triangleArray_edge3);
        TriangleInterface[] triangleInterfaces=new TriangleInterface[merger123.size];
        for(int i=0;i<merger123.size;i++){
            triangleInterfaces[i]=merger123.get(i);
       //     System.out.println(merger123.get(i)+ " "+ merger123.get(i).id);
        }

       // long end=System.nanoTime();
       // System.out.println(end-start);
        return triangleInterfaces;

    }

    private Array<Triangle> merge(Array<Triangle> a1, Array<Triangle> a2){
        int a1_size=a1.size;
        int a2_size=a2.size;
        Array<Triangle>  triangleArray=new Array<>();
        int i=0, j=0;
        while(i<a1_size && j<a2_size){
            if(a1.get(i).id<=a2.get(j).id){
                triangleArray.add(a1.get(i));
                i++;
            }
            else{
                triangleArray.add(a2.get(j));
                j++;
            }
        }
        while(i<a1_size){
            triangleArray.add(a1.get(i));
            i++;
        }
        while(j<a2_size){
            triangleArray.add(a2.get(j));
            j++;
        }
        return triangleArray;
    }

    public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord) {
        PointInterface[] pointInterfaces = new PointInterface[3];
        Point point1 = new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
        Point point2 = new Point(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
        Point point3 = new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
        Point[] arrayofpoints=new Point[]{point1,point2,point3};
        arrayofpoints=sort(arrayofpoints);
        point1=arrayofpoints[0];
        point2=arrayofpoints[1];
        point3=arrayofpoints[2];
        Triangle triangle=new Triangle(point1,point2,point3);

        boolean[] visited=new boolean[shapeTriangles.size];
        /*for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }*/
        Array<Triangle> triangle_vertex1 = new Array<>();
        Array<Triangle> triangle_vertex2 = new Array<>();
        Array<Triangle> triangle_vertex3 = new Array<>();

        Triangle triangle1=triangleAVLTree.get(triangle);
        if(triangle1!=null) {
            for (int j = 0; j < triangle1.pointInterface[0].neighbourTriangles.size; j++) {
                Array<Triangle> triangleList = triangle1.pointInterface[0].neighbourTriangles;
                if (triangleList.get(j).compareTo(triangle)!=0) {
                    if (!visited[triangleList.get(j).id]) {
                        visited[triangleList.get(j).id] = true;
                        triangle_vertex1.add(triangleList.get(j));
                    }
                }

            }
            for (int j = 0; j < triangle1.pointInterface[1].neighbourTriangles.size; j++) {
                Array<Triangle> triangleList = triangle1.pointInterface[1].neighbourTriangles;
                if (triangleList.get(j).compareTo(triangle)!=0) {
                    if (!visited[triangleList.get(j).id]) {
                        visited[triangleList.get(j).id] = true;
                        triangle_vertex2.add(triangleList.get(j));
                    }
                }
            }
            for (int j = 0; j < triangle1.pointInterface[2].neighbourTriangles.size; j++) {
                Array<Triangle> triangleList = triangle1.pointInterface[2].neighbourTriangles;
                if (triangleList.get(j).compareTo(triangle)!=0) {
                    if (!visited[triangleList.get(j).id]) {
                        visited[triangleList.get(j).id] = true;
                        triangle_vertex3.add(triangleList.get(j));
                    }
                }
            }
        }else{
            return null;
        }


        Array<Triangle> merger12 = merge(triangle_vertex1, triangle_vertex2);
        Array<Triangle> merger123 = merge(merger12, triangle_vertex3);
        TriangleInterface[] triangleInterfaces = new TriangleInterface[merger123.size];
        for (int i = 0; i < merger123.size; i++) {
            triangleInterfaces[i] = merger123.get(i);
         //   System.out.println(merger123.get(i) + " " + merger123.get(i).id);
        }
        if(merger123.size==0){
            return null;
        }

        return triangleInterfaces;
    }


    public EdgeInterface [] BOUNDARY_EDGES(){
        int typemesh=TYPE_MESH();
        Array<Edge> boundary_edges=new Array<>();
        if(typemesh==1){
            return null;
        }
        if(typemesh==2){
            for(int i=0;i<edgeArray.size;i++){

                if(edgeArray.get(i).neighbourTriangles.size==1){
                    boundary_edges.add(edgeArray.get(i));
                }
            }

        }
        if(typemesh==3){
            return null;
        }
        Edge[] edges=new Edge[boundary_edges.size];
        for(int i=0;i<boundary_edges.size;i++){
         //   System.out.println(boundary_edges.get(i));
            edges[i]=boundary_edges.get(i);
        }
       // System.out.println(boundary_edges.size);
        QuickSortEdge(edges,0,edges.length-1);
        /*for(int i=0;i<edges.length;i++){
            System.out.println(edges[i]);
          //  edges[i]=boundary_edges.get(i);
        }*/
        return edges;

    }


    int partitionEdge(Edge[] edges, int low, int high)
    {
        Edge pivot = edges[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (edges[j].compare(pivot)>0)
            {
                i++;
                Edge temp = edges[i];
                edges[i] = edges[j];
                edges[j] = temp;
            }
        }

        Edge temp = edges[i+1];
        edges[i+1] = edges[high];
        edges[high] = temp;

        return i+1;
    }

     void QuickSortEdge(Edge[] edges, int l, int h){
         if(l<h){
             int start=partitionEdge(edges,l,h);
             QuickSortEdge(edges,l,start-1);
             QuickSortEdge(edges,start+1,h);
         }
     }


    public void createComponents() {
        boolean[] visited = new boolean[shapeTriangles.size];
        /*for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }*/
        for (int i = 0; i < shapeTriangles.size; i++) {
            if (!visited[shapeTriangles.get(i).id]) {
                Component component=new Component();
                component.Triangles_in_component=components(shapeTriangles.get(i),visited,component.points_in_component);
                componentArray.add(component);


            }
        }
    }

    Array<Triangle> components(Triangle triangle,boolean[] visited,AVLTree<Point>pointAVLTree){
        Queue<Triangle> triangleQueue=new Queue<>();
        visited[triangle.id]=true;
        Array<Triangle> array=new Array<>();
        for(int i=0;i<triangle.pointInterface.length;i++){
            pointAVLTree.insert(triangle.pointInterface[i]);
        }
        triangleQueue.enqueue(triangle);
        while (!triangleQueue.isEmpty()){

            Triangle triangle1=triangleQueue.dequeue();
            for(int i=0;i<triangle1.pointInterface.length;i++){
                pointAVLTree.insert(triangle1.pointInterface[i]);
            }
            array.add(triangle1);
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
        return array;
    }


    public int MAXIMUM_DIAMETER(){
       // long start=System.nanoTime();
        if(componentArray.size==0) {
            createComponents();
        }
        int size=0;
        for(int i=0;i<componentArray.size;i++){
            if(componentArray.get(i).Triangles_in_component.size>size){
                size=componentArray.get(i).Triangles_in_component.size;
            }
        }

        int max=0;

        for (int i=0;i<componentArray.size;i++){

            if(componentArray.get(i).Triangles_in_component.size==size){

                for(int j=0;j<componentArray.get(i).Triangles_in_component.size;j++){

                    int hoplength=componentArray.get(i).Triangles_in_component.get(j).hoplength(shapeTriangles.size,componentArray.get(i).Triangles_in_component.size-1);
                   // System.out.println(hoplength);
                    if(max<hoplength){
                        max=hoplength;
                    }
                }
                break;
            }
        }
        //System.out.println(max);
        long end=System.nanoTime();
      //  System.out.println(end-start);
        return max;

    }


    public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates){
        if(componentArray.size==0){
            createComponents();
        }
        Point point =new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);

        if(pointAVLTree.get(point)!=null){
            point=pointAVLTree.get(point);
        }else{
            return null;
        }
        Triangle triangle=point.neighbourTriangles.get(0);
        AVLTree<Point> pointAVLTree1=new AVLTree<>();


        Component component=new Component();
        for(int i=0;i<componentArray.size;i++){

            for(int j=0;j<componentArray.get(i).Triangles_in_component.size;j++) {
                if (componentArray.get(i).Triangles_in_component.get(j).compareTo(triangle) == 0) {
                    component = componentArray.get(i);
                    break;
                }

            }
        }

        for(int i=0;i<component.Triangles_in_component.size;i++){
            pointAVLTree1.insert(component.Triangles_in_component.get(i).pointInterface[0]);
            pointAVLTree1.insert(component.Triangles_in_component.get(i).pointInterface[1]);
            pointAVLTree1.insert(component.Triangles_in_component.get(i).pointInterface[2]);
        }

        double x=0, y=0, z=0;
        Array<Point> array=pointAVLTree1.inOrder(pointAVLTree1.root);
        for(int i=0;i<array.size;i++){
            x+=(array.get(i).getX());
            y+=(array.get(i).getY());
            z+=(array.get(i).getZ());
            // System.out.println(array.get(i));
        }
        Point point1=new Point(((float)x/array.size),
                ((float)y/array.size),((float)z/array.size));
        //System.out.println(point1);
        return point1;



    }


    public PointInterface [] CENTROID (){
        if(componentArray.size==0){
            createComponents();
        }
        Array<Point> array_points=new Array<>();
         Array<Point> array_centroids=new Array<>();
        Point[] pointInterfaces=new Point[componentArray.size];
        for(int i=0;i<componentArray.size;i++){
            array_points=componentArray.get(i).points_in_component.inOrder(componentArray.get(i).points_in_component.root);
            double x1=0, y1=0, z1=0;
            for(int j=0;j<array_points.size;j++){
                x1+=array_points.get(j).getX();
                //  System.out.println(array_points.get(j)+ " " +x1+ " "+array_points.get(j).getX());
                y1+=array_points.get(j).getY();
                z1+=array_points.get(j).getZ();
            }
            //  System.out.println(array_points.size+ " "+ x1);
            Point point=new Point(((float)x1/array_points.size),
                    ((float)y1/array_points.size),((float)z1/array_points.size));

             pointInterfaces[i]=point;

        }

        QuickSort(pointInterfaces,0,pointInterfaces.length-1);
      /*  for(int i=0;i<pointInterfaces.length;i++){
            System.out.println(pointInterfaces[i]);
        }*/
        return pointInterfaces;
    }

    int partition(Point[] points, int low, int high)
    {
        Point pivot = points[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (points[j].compareTo(pivot)>0)
            {
                i++;
                Point temp = points[i];
                points[i] = points[j];
                points[j] = temp;
            }
        }

        Point temp = points[i+1];
        points[i+1] = points[high];
        points[high] = temp;

        return i+1;
    }

    void QuickSort(Point[] points, int l,int h){
        if(l<h){
            int start=partition(points,l,h);
            QuickSort(points,l,start-1);
            QuickSort(points,start+1,h);
        }
    }



    float square(float a){
        return a*a;
    }

    float Euclidean_distance(Point point1, Point point2){

        return ((float)(Math.sqrt(square(point1.x-point2.x)+ square(point1.y-point2.y)+ square(point1.z-point2.z))));

    }
    public 	PointInterface [] CLOSEST_COMPONENTS(){
        if(componentArray.size==0){
            createComponents();
        }
        float dist=Float.MAX_VALUE/10;
        Point point1=null;
        Point point2=null;
        if(componentArray.size==1){
            return null;
        }
        for(int i=0;i<componentArray.size;i++){
            Array<Point> component1_points=componentArray.get(i).points_in_component.inOrder(componentArray.get(i).points_in_component.root);
            for(int j=i+1;j<componentArray.size;j++){
                Array<Point> component2_points=componentArray.get(j).points_in_component.inOrder(componentArray.get(j).points_in_component.root);
                for(int k=0;k<component1_points.size;k++){
                    //System.out.println(component1_points.size);
                    for(int l=0;l<component2_points.size;l++){
                        //System.out.println(component2_points.size);
                        float distance=Euclidean_distance(component1_points.get(k),component2_points.get(l));
                        if(distance<dist){
                            point1=component1_points.get(k);
                           // System.out.println(point1);
                            //System.out.println(point2);
                            point2=component2_points.get(l);
                            dist=distance;
                        }
                    }
                }
            }
        }
        Point[] pointInterfaces=new Point[]{point1,point2};;
      //  System.out.println(pointInterfaces[0]);
       // System.out.println(pointInterfaces[1]);
        return pointInterfaces;

    }









   /* public static void main(String[] args){
        long start=System.currentTimeMillis();
        Queue<Point> queue=new Queue<>();
        for(Integer i=0;i<2000;i++){
            queue.enqueue(new Point(i,i+1,i+2));
        }
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
        Point point=new Point(1,1,1);
        System.out.println(point.hashCode());
        Point point2=new Point(1,1,1);
        System.out.println(point2.hashCode());


        Array<Point> array=new Array<>();
        System.out.println(start-(System.currentTimeMillis()));

        boolean[] visited=new boolean[1000000];
        for(int i=0;i<1000000;i++){
            visited[i]=false;
        }

        for(int i=0;i<10000;i++){
            System.out.println("ADD_TRIANGLE "+ i +" "+ 0+ " 0"+ " "+ (i+1)+ " 0"+ " 0 "+ i+ " 1"+ " 0" );
            System.out.println("ADD_TRIANGLE "+ (i+1)+ " 0"+ " 0 "+ i+ " 1"+ " 0 "+ (i+1)+ " 1"+ " 0");
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start+ " ms");
        System.out.println(((array.get(1)).XYZtoString()));
    }*/





}





