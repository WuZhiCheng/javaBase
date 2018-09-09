package com.example.redismonitor;

import cn.hutool.core.io.FileUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisMonitor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 19:03 2018/8/28
 * @company:北京今汇在线
 */
@Component
public class RedisMonitor {

    public RedisMonitor(){
        String file = "F:\\project\\github\\javaBase\\redismonitor\\log\\redis.log";
        BufferedWriter  writer =
                FileUtil.getWriter(file,"utf-8",true);
        Jedis jedis  =
                new Jedis("101.200.123.114", 6379);
        jedis.auth("redis_repay");
        jedis.monitor(new JedisMonitor() {
            @Override
            public void onCommand(String command) {
                System.out.println(new Date()+"command::"+command);
//                String file = "F:\\project\\github\\demo-tomcathot\\redis.log";
                try {
                    if(command.contains("com.jhzx.bfp.common.pojo.SysUser")
                    ){
                        writer.write(getTime()+"  "+command);
                        writer.newLine();
//                        id  username   password phone  email status
//                        areaCode bankCode orgId deptId
//                        companyId  orgName
                        if(!command.contains("id")||!command.contains("username")||
                                !command.contains("password")
                                ||!command.contains("phone")
                                ||!command.contains("email")
                                ||!command.contains("status")
                                ||!command.contains("areaCode")
                                ||!command.contains("bankCode")
                                ||!command.contains("orgId")
                                ||!command.contains("deptId")
                                ||!command.contains("companyId")
                                ||!command.contains("orgName")){
                            writer.write(getTime()+" ================================== ");
                            writer.newLine();
                        }
                    }

                    writer.flush();
//                    FileUtil.getWriter(file,"utf-8",true).write(command);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println("command::"+command);
//                FileUtil.appendString(command,,"utf-8");
            }
        });

    }

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    public String getTime(){
        return dateTimeFormatter.format(LocalDateTime.now());
    }




    public static void main(String[] args) {
        String file = "E:\\demo-tomcathot\\log\\redis.log";
        try {
            BufferedWriter  writer =
                    FileUtil.getWriter(file,"utf-8",true);
            writer.write("hahhaha");
            writer.newLine();
            writer.write("lllllllllllll");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
