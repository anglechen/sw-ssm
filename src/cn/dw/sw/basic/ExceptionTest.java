/**
 *
 */
package cn.dw.sw.basic;

/**
 * @author aubrey
 * @date  下午12:59:49
 * 
 */
public class ExceptionTest {
	public static void main(String[] args) {
		
		try {
			test(1,1);
			test(1,0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*直接抛出异常到上层方法处理*/
	public static void test(int a , int b) throws ArithmeticException{
		int i = 0;
		try {
			i = a/b;
//			System.out.println("释放资源");
		} catch (Exception e) {
			e.printStackTrace();
			
			//手动抛出异常
			throw new ArithmeticException("除数不能为0");
		}finally {
			/*确保代码一点执行*/
			System.out.println("释放资源");
		}
		
		
		
	}
}
