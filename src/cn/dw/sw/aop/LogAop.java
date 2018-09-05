/**
 *
 */
package cn.dw.sw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author aubrey
 * @date  上午10:46:59
 * aop的配置类
 */
@Component  //托管到spring容器
@Aspect  //识别aop注解类
public class LogAop {
	
	/*定义切入点*/
	//@Pointcut("execution(* cn.dw.sw.controller.ProductController.add(..))")

	@Pointcut("execution(* cn.dw.sw.controller.*.*(..))")
	public void point() {
		
	}
	
	@Before("point()")
	public void before(JoinPoint poinPoint) {
		System.out.println("方法调用开始=========");
	}
	
	
	@After("point()")
	public void after(JoinPoint poinPoint) {
		System.out.println("方法调用结束=========");
	}
	
	
	
	
	
	
	
	

}
