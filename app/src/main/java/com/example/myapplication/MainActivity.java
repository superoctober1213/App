package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {


    TextView editIDGender;
    TextView editIDBirth;
    TextView editIDNumber;
    TextView editIDName;
    private Button search;
    private Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (Button) findViewById(R.id.searchD);
        read = (Button) findViewById(R.id.readD);
        editIDName = findViewById(R.id.IDName);
        editIDGender = findViewById(R.id.IDGender);
        editIDBirth = findViewById(R.id.IDBirth);
        editIDNumber = findViewById(R.id.IDNumber);


//        final Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!Thread.interrupted()) {
//                    try {
//                        Thread.sleep(100);  // 每隔0.1秒尝试连接
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    try {
                        Class.forName("com.mysql.jdbc.Driver");//动态加载类
                        String url = "jdbc:mysql://192.168.1.231:3306/zjht";
                        Connection conn = DriverManager.getConnection(url, "root", "rz@123");
                        //使用 DriverManger.getConnection链接数据库  第一个参数为连接地址 第二个参数为用户名 第三个参数为连接密码  返回一个Connection对象
                        if (conn != null) { //判断 如果返回不为空则说明链接成功 如果为null的话则连接失败 请检查你的 mysql服务器地址是否可用 以及数据库名是否正确 并且 用户名跟密码是否正确
                            Log.d("调试", "连接成功");
                            Statement stmt = conn.createStatement(); //根据返回的Connection对象创建 Statement对象
                            String sql = "SELECT * FROM CustomerInfo WHERE CustomerGuid='1'"; //要执行的sql语句
                            //                    PreparedStatement ps = conn.prepareStatement(sql);

                            ResultSet rs = stmt.executeQuery(sql);
                            int count = rs.getMetaData().getColumnCount();
                            Log.e("DBUtils", "列总数：" + count);

                            rs.next();
                            String name = rs.getString("CustomerName");
                            String birth = rs.getString("CustomerBirthday");
                            String gender = rs.getString("CustomerGender");
                            String idNumber = rs.getString("CardIdNo");

                            editIDName.setText(name);
                            editIDGender.setText(gender);
                            editIDBirth.setText(birth);
                            editIDNumber.setText(idNumber);

                            DBService.closeAll(stmt, conn, rs);


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                }
//            }
//        });
//        thread.start();





        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, IdentityCard.class);
                startActivity(intent);
            }
        });
    }

}