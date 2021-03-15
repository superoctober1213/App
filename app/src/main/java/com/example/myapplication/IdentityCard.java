package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class IdentityCard extends AppCompatActivity {

    ListView listView;
    private Handler mHandler;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identitycard);
        //       new Thread(new MyRunnable()).start();
        new MyThread().start();
        listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        setContentView(listView);

    }


    //    public class MyRunnable implements Runnable{
    public class MyThread extends Thread
    {
        @Override
        public void run()
        {
            try {
                Thread.sleep(3000);
                Class.forName("com.mysql.jdbc.Driver");//动态加载类
                String url = "jdbc:mysql://192.168.1.231:3306/zjht";
                Connection conn = DriverManager.getConnection(url, "root", "rz@123");
                //使用 DriverManger.getConnection链接数据库  第一个参数为连接地址 第二个参数为用户名 第三个参数为连接密码  返回一个Connection对象
                if (conn != null)
                { //判断 如果返回不为空则说明链接成功 如果为null的话则连接失败 请检查你的 mysql服务器地址是否可用 以及数据库名是否正确 并且 用户名跟密码是否正确
                    Log.d("调试", "连接成功");
                    Statement stmt = conn.createStatement(); //根据返回的Connection对象创建 Statement对象
                    String sql = "SELECT * FROM CustomerInfo WHERE CustomerGuid='1'"; //要执行的sql语句
                    //                    PreparedStatement ps = conn.prepareStatement(sql);

                    ResultSet rs = stmt.executeQuery(sql);
                    int count = rs.getMetaData().getColumnCount();
                    Log.e("DBUtils", "列总数：" + count);

                    rs.next();
                    String name = rs.getString("CustomerName");
                    String gender = rs.getString("CustomerGender");
                    String birth = rs.getString("CustomerBirthday");
                    String idNumber = rs.getString("CardIdNo");
                    data.add(name);
                    data.add(gender);
                    data.add(birth);

                    Thread.sleep(3000);
                   // Log.e("ds", "sdf" + getData());


//                    editIDName.setText("123435");
//                    editIDGender.setText(gender);
//                    editIDBirth.setText(birth);
//                    editIDNumber.setText(idNumber);

               //    DBService.closeAll(stmt, conn, rs);


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mHandler.sendEmptyMessage(0);
        }
    }

    private List<String> data = new ArrayList<>();

    private List<String> getData() {
        data.add("123");
        data.add("456");
        return data;
    }
}
