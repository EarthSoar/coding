package hash;

/**
 * @author Willing
 * @date 2019/2/17
 */

import java.util.HashMap;

/**
     设计RandomPool结构
     【题目】 设计一种结构，在该结构中有如下三个功能：
     insert(key)：将某个key加入到该结构，做到不重复加入。
     delete(key)：将原本在结构中的某个key移除。
     getRandom()：等概率随机返回结构中的任何一个key。
     【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)
 */
public class RandomPool {
    public static class Pool{
        private HashMap<String,Integer> keyIndexMap;//key: 元素值  value: 元素加入索引
        private HashMap<Integer,String> indexKeyMap;//key: 元素加入索引  value:元素值
        private int size;//结果中元素的个数
        public Pool(){
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }
        /**
         * 插入一个元素
         * @param key
         */
        public void insert(String key){
            if(!keyIndexMap.containsKey(key)){//若结构中不存在该元素,直接加入到两个map中
                keyIndexMap.put(key,size);
                indexKeyMap.put(size,key);
                size++;
            }
        }

        /**
         * 删除一个元素.保证删除之后此结构还可以是等概论返回元素
         * @param key
         */
        public void delete(String key){
            //得到需要删除元素的 索引位置
            Integer deleteIndex = keyIndexMap.get(key);
            Integer lastIndex = --size;

            //把索引为 size - 1 处的元素放在 deleteIndex 位置
            String value = indexKeyMap.get(lastIndex);
            keyIndexMap.put(value,deleteIndex);
            indexKeyMap.put(deleteIndex,value);

            //然后删除索引为 size - 1 处的元素
            keyIndexMap.remove(key);
            indexKeyMap.remove(lastIndex);
        }

        /**
         * 等概率从结构中获取一个元素
         */
        public String getRandom(){
            if(size == 0){
                return null;
            }
            //得到[0,size)范围内的随机数作为indexKeyMap的key得到value
            int indexKey = (int)(Math.random() * size);
            return indexKeyMap.get(indexKey);
        }
    }

    //test
    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.insert("spring");
        pool.insert("hibernate");
        pool.insert("spring");
        pool.insert("struts");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        pool.delete("spring");
        System.out.println(pool.getRandom());
    }
}
