//* 1. 定义泛型类 SimpleList<T>：
//        *    - 内部使用 Object[] 数组存储数据 (初始容量 10)
// *    - 属性：size (当前元素个数)
// *
// * 2. 实现核心方法：
//        *    - boolean add(T element): 添加元素，若数组满则扩容 (新数组 = 旧数组 * 1.5)
// *    - T get(int index): 获取元素 (需检查索引越界)
// *    - int size(): 返回当前元素个数
// *    - void remove(int index): 删除元素，后续元素前移
public class SimpleList<T> {
    private int size;
    private Object[] elementData;

    public SimpleList(){
        elementData = new Object[10];
        size = 0;
    }

    public boolean add(T element){
        if(size == elementData.length){
            expandCapacity();
        }
        elementData[size++] = element;
        return true;
    }

    public void expandCapacity(){
        int newLen = elementData.length + elementData.length/2;
        Object[] newArr = new Object[newLen];
        System.arraycopy(elementData, 0, newArr, 0, elementData.length);
        elementData = newArr;
    }

    public T get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        } else {
            return (T) elementData[index];
        }
    }

    public int size(){
        return size;
    }

    public void remove(int index){
        if(index > elementData.length){
            throw new IndexOutOfBoundsException();
        } else {
            for(int i= index;i<size-1;i++){
                elementData[i]=elementData[i+1];
            }
            elementData[ size-1 ] = null;
            size--;
        }
    }

    @Override
    public String toString (){
        String tem = "";
        for(int i=0;i<size ;i++){
            tem = tem + elementData[i] +" ";
        }
        return "the list is:" + tem;
    }
}