/**
 * 要求：
 * 1. 抽象类 Shape，含抽象方法 double getArea() 和具体方法 printInfo()
 * 2. 子类 Circle(radius) 实现 getArea() = πr²
 * 3. 子类 Rectangle(width, height) 实现 getArea() = w*h
 * 4. 方法 calculateTotalArea(Shape[] shapes) 计算图形数组总面积
 * 5. main方法：创建3个图形（2圆1方），调用calculateTotalArea并输出
 *
 * 交付要求：
 * - 代码文件：Shape.java, Circle.java, Rectangle.java, TestShape.java
 * - 运行截图：展示多态调用效果 + 总面积计算结果
 * - 思考题：为什么getArea()要设计为抽象方法而非返回0？
 */

public class TestShape {
    public static double calculateTotalArea(Shape[] shapes){
        int total=0;
        for(int i=0;i<shapes.length;i++){
            total += shapes[i].getArea();
        }
        return total;
    }

    public static void main(String[] args){
        Shape[] myshapes = new Shape[3];
        myshapes[0] = new Circle(5.4);
        myshapes[1] = new Circle(4.8);
        myshapes[2] = new Rectangle(3.7,8.1);

        double result = calculateTotalArea(myshapes);
        System.out.println("The sum of three shapes's area is "+result);
    }
}
