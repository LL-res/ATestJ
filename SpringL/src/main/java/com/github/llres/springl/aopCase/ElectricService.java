package com.github.llres.springl.aopCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricService {
    @Autowired
    private AdminUserService adminUserService;

    public void charge() throws Exception {
        System.out.println("Electric charging ...");
        this.pay();
    }

    public void pay() throws Exception {
        adminUserService.login();
        //如果这么写，被代理的AdminUserService中的adminUser为null，一定要使用get方法
        //String payNum = adminUserService.adminUser.getPayNum();
        String payNum = adminUserService.getAdminUser().getPayNum();
        System.out.println("User pay num : " + payNum);
        System.out.println("Pay with alipay ...");
        Thread.sleep(1000);
    }
}
