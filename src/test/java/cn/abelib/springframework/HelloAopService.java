package cn.abelib.springframework;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/10 下午 11:30
 */
public class HelloAopService implements IHelloService {
    private String name;

    public HelloAopService() {}

    public HelloAopService(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello " + name);
    }

    @Override
    public String hello() {
        return "Hello " + name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
