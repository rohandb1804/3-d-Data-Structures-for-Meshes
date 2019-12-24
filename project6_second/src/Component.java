public class Component {

    Array<Triangle> Triangles_in_component;
    AVLTree<Point> points_in_component;

    Component(){
        Triangles_in_component=new Array<>();
        points_in_component=new AVLTree<>();
    }
}
