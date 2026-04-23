import java.util.Objects;

//* 1. 定义 Product 类:
//        *    - 属性: id(int), name(String), price(double)
// *    - 构造器: 全参构造
// *    - 重写: toString(), equals(), hashCode()（以 id 为唯一标识）
public class Product {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "the product's id: "+ id +", the name is: "+ name + ", the price is: "+ price;
    }

    @Override
    public boolean equals(Object o){
        // 1. 自反性检查：如果是同一个对象引用，直接返回 true
        if(this == o) return true;

        // 2. 空值检查和类型检查：如果 o 为 null 或类不同，返回 false
        // getClass() != o.getClass() 保证了子类对象不会与父类对象相等（严格对称性）
        if(o == null || getClass() != o.getClass()) return false;

        // 3. 类型转换
        Product object = (Product) o;

        // 4. 逐字段比较
        // Objects.equals 内部已处理 null 情况，安全且简洁
        return id == object.id &&
                Objects.equals(name, object.name) &&
                Objects.equals(price, object.price);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, price);
    }
}
