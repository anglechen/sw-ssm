/**
 *
 */
package cn.dw.sw.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author aubrey
 * @date  下午1:04:36
 * 
 */
public class CollectionTest {
	public static void main(String[] args) {
//		list用法
		List list = new ArrayList<>();
		list.add("123");
		list.add("234");
		list.add(123);
		System.out.println(list.get(0));
		
		for(int i = 0 ; i  < list.size() ;i++) {
			System.out.println(list.get(i));
		}
		
		for(Object obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("=======分割线 set ============");
		/*set用法*/
		
		Set set = new HashSet<>();
		set.add("123");
		set.add(123);
		set.add("123");
//		遍历
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			
			System.out.println(iterator.next());
		}
		
		
		System.out.println("=========分割线 map=============");
		Map map = new HashMap<>();
		map.put("name", "张三");
		map.put("name", "李四");
		map.put("sex", "男");
		map.put("age", 12);
		
		System.out.println(map.get("name"));
		System.out.println(map.get("sex"));
		System.out.println(map.get("age"));
		
		
		Set keySets = map.keySet();
		System.out.println("======map 遍历=========");
//		遍历
		Set<Map.Entry> entrys = map.entrySet();
		for(Map.Entry entry : entrys) {
			System.out.println(entry.getKey() +":" + entry.getValue());
		}
		
		
		
		
	}
}
