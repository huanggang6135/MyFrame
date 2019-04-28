package spi;
import java.util.ServiceLoader;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/15 14:51
 * @Desc
 * @Version 1.0
 **/
public class SpiDemo {
 public class BloackDocServiceImpl implements DogService {

     @Override
     public void sleep() {
         System.out.println("黑狗");
     }
 }
 public class WhiltDogServiceImpl implements DogService{

     @Override
     public void sleep() {
         System.out.println("白狗");
     }
 }

    public static void main(String[] args) {
        ServiceLoader<DogService> loads = ServiceLoader.load(DogService.class);
        for (DogService load : loads) {
            load.sleep();
        }

    }
}
