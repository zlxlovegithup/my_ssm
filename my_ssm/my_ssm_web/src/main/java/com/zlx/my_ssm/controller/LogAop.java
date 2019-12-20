package com.zlx.my_ssm.controller;

import com.zlx.my_ssm.domain.SysLog;
import com.zlx.my_ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component //不是dao,service,domain这三类
@Aspect //这是一个切面类
public class LogAop {

//    private Date visitTime;//访问时间 √
//    private String visitTimeStr;//字符串类型(方便在页面上展示)
//    private String username;//操作者用户名 √
//    private String ip;//访问IP √
//    private String url;//访问资源URL √
//    private Long executionTime;//执行时长 √
//    private String method;//访问方法 √

    private Date startTime;//访问时间
    private Class executionClass;//访问的类
    private Method executionMethod;//访问的方法

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

        //获取访问时间,访问的类,访问的方法
        @Before("execution(* com.zlx.my_ssm.controller.*.*(..))")
        public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException,SecurityException{
        startTime = new Date();//获取访问时间
        executionClass = joinPoint.getTarget().getClass(); //获取访问的类

        String methodName = joinPoint.getSignature().getName();//获取访问的方法的名称

        Object[] args = joinPoint.getArgs(); //获取访问方法的参数
        if(args == null || args.length == 0){
            executionMethod = executionClass.getMethod(methodName);//获取访问的方法(注意：这行代码只能获取无参数的方法)
        }else{
            Class[] classArgs = new Class[args.length]; //有参数，就将args中的所有元素遍历,获取对应的Class,装入到一个Class[]
            for(int i = 0 ; i<args.length;i++){
                classArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName, classArgs);//获取访问的方法(注意：这行代码可以获取参数的方法)
        }
        }

        /**
        * 获取日志中的其他的信息 时长、IP、URL、操作者用户名
        * @param joinPoint
        */
        @After("execution(* com.zlx.my_ssm.controller.*.*(..))")
        public void doAfter(JoinPoint joinPoint) throws Exception {

        //1 获取类上的@RequestMapping对象 --> @RequestMapping("/sysLog") --> /sysLog
        if(executionClass!= SysLogController.class){
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            //2 获取方法上的@RequestMapping对象 --> @RequestMapping("/save.do") --> /save.do
            if(classAnnotation != null){
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null){
                    String url = "";//值为类上的@RequestMapping的value + 方法上的@RequestMapping的value
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0]; //获取访问路径

                    Long executionTime = new Date().getTime() - startTime.getTime(); //获取执行时长

                    String ip = request.getRemoteAddr(); //获取IP

                    //方法一：通过securityContext获取当前的操作者
                    SecurityContext securityContext = SecurityContextHolder.getContext(); //获取securityContext对象
                    String username = ((User) (securityContext.getAuthentication().getPrincipal())).getUsername(); //获取当前操作者

//                    //方法二：通过request.getSession中获取
//                    SecurityContext spring_security_context = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//                    String username = ((User)(securityContext.getAuthentication().getPrincipal())).getUsername();

                    //将获取到的 时长、IP、URL、操作者用户名 封装进入JavaBean对象中
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    sysLog.setIp(ip);
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名]"+executionClass.getName() + "[方法名]" + executionMethod.getName());
                    sysLog.setVisitTime(startTime);

                    //调用service 调用dao将sysLog insert数据库
                    sysLogService.save(sysLog);
                }
            }
        }
    }


}
