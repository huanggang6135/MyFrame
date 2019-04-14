/**
 * @Author hg
 * @Date 2019/3/31 13:55
 * @Version 1.0
 **/
public class UserServiceImpl implements IUserService {
    @Override
    public void add(String s) {
        System.out.println("向数据库中插入"+s);
    }
}
