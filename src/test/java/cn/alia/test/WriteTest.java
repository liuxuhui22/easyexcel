package cn.alia.test;

import cn.alia.dto.User;
import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteTest {
    @Test
    public void test01(){
        String filename = "user1.xlsx";

        List<User> userList = new ArrayList<>();
        User user = new User(1001,"李磊","男",8385.12,new Date());
        for(int i = 0;i < 4;i ++){
            userList.add(user);
        }

        EasyExcel.write(filename,User.class).sheet("用户信息").doWrite(userList);

    }




}
