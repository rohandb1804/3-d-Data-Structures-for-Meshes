

public class Point implements PointInterface, Comparable<Point>{


    public float x;
    public float y;
    public float z;
    //float[] xyzcooridnate;
    Array<Triangle> neighbourTriangles;
    Array<Edge> edgeneigbours;
    Point(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
      /*  xyzcooridnate = new float[3];
        xyzcooridnate[0] = x;
        xyzcooridnate[1] = y;
        xyzcooridnate[2] = z;*/
        neighbourTriangles = new Array<>();
        edgeneigbours = new Array<>();
    }
    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }

    @Override
    public float[] getXYZcoordinate() {


        return new float[]{x,y,z};
    }

    public String XYZtoString(){
        return "("+ x+ ","+y +","+ z+ ")";
    }

    @Override
    public String toString() {
        return "("+ x+ ","+y +","+ z+ ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || obj.getClass()!=this.getClass()){
            return false;
        }
        Point point =(Point)obj;
        if(point.x==this.x && point.y == this.y && point.z==this.z){
            return  true;
        }else{
            return false;
        }

    }


    @Override
    public int compareTo(Point o) {
        if(this.x==o.x){
            if(this.y==o.y){
                if(this.z==o.z){
                    return 0;
                }else{
                    if(o.z>this.z){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }else{
                if(o.y>this.y){
                    return 1;
                }else{
                    return -1;
                }

            }

        }else{
            if(o.x>this.x){
                return 1;
            }else{
                return -1;
            }
        }


    }

}
