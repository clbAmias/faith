package com.learn.thread.database;

/**
 * Created by chenlongbo on 2017/6/20.
 */
import java.io.*;

import java.sql.*;

public class ToOracle {

    public static void main(String[] args) {

        int n = 10;//每个线程执行的个数

//System.out.println("start action!!!!!!");

        ToOracle ac = new ToOracle();

        ThreadRun[] testrun = new ThreadRun[21];

        for (int i = 1; i <= 21; i++) {

            testrun[i] = ac.new ThreadRun();

            testrun[i].TRun(n);

            System.out.println("线程" + i + "已经启动");

        }

//testrun[1] = ac.new ThreadRun();

//testrun[1].TRun(10);

        for (int i = 1; i <= 21; i++) {

            testrun[i].TExit();

        }

    }

    class ThreadRun {

        String blobname = "D:/eclipsetest/test1.txt"; //blob文件名

        String clobname = "D:/eclipse/test/test2.txt"; //clob文件名

        String in = "insert into ";

        String in1 = "(order_id,ric_code,siz,price,trade_datetime,status,testblob,testclob) values(9,′asdfjkl′,21,123.34567,sysdate,′nill逆耳′,?,?)";

        String tablename = "orders1";

        String sqlstr = ""; // sql 语句

        ThreadUseExtends thread = new ThreadUseExtends(blobname, clobname,

                sqlstr);

        public void TRun(int n) {

            sqlstr = in + tablename + in1;

            thread = new ThreadUseExtends(blobname, clobname, sqlstr);

//thread.start();

            thread.run(n);

/*

* int n=10; for (int i = 1; i <= 21; i++) { while(0 <n){ sqlstr[i] =

* in + tablename + in1; thread[i] = new ThreadUseExtends(blobname,

* clobname, sqlstr[i]); thread[i].start(); n--; }

* System.out.println("线程" + i + "已经启动"); }

*/

//System.out.println("线程1已经启动");

        }

        public void TExit() {

            thread.interrupt();

        }

        class ThreadUseExtends extends Thread {

            String filename1;//blob filename

            String filename2;//clob filename

            String str;

//构造函数要有（blob文件名,clob文件名,sql语句）

            public ThreadUseExtends(String name1, String name2, String sqlstr) {

                filename1 = name1;

                filename2 = name2;

                str = sqlstr;

            }

            ReadFiles r1 = new ReadFiles();

            public void run(int n) {

                while (n > 0) {

                    try {

                        String url = "jdbc:oracle:thin:@193.9.200.111:1521:ora9i";

                        String login = "system"; // use your login here

                        String password = "ti2003"; // use your password here

                        Class.forName("oracle.jdbc.driver.OracleDriver");

                        Connection con = DriverManager.getConnection(url,

                                login, password);

                        String testLong = r1.ReadFile(filename1);

                        String testLong1 = r1.ReadFile(filename2);

                        byte[] ba = testLong.getBytes();

                        System.out.println("str=" + str);

//String strSql = str; //"insert into

// orders(order_id,ric_code,siz,price,trade_datetime,status,testblob,testclob)

// values(8,′asdfjkl′,21,123.34567,sysdate,′nill逆耳′,?,?)";

                        PreparedStatement stm = con.prepareStatement(str);

                        stm.setBytes(1, ba);

                        StringReader test = new StringReader(testLong1);

                        stm.setCharacterStream(2, test, testLong.length());

                        stm.execute();

                        stm.close();

                        con.close();

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                    n--;

                }//while

            }//run

        }//ThreadUseExtends class

        // ReadFiles class for read text!
        class ReadFiles {

            public ReadFiles() {

            }

//ReadFile method,read file

            public String ReadFile(String FileName) {

                String Name = FileName;

                String File = "";

                try {

                    FileReader ReadF = new FileReader(Name);//读文件

                    BufferedReader HuanChong = new BufferedReader(ReadF);//文件读缓冲.

                    try {

                        File = HuanChong.readLine();

                    } catch (IOException e1) {

// TODO 自动生成 catch 块

                        e1.printStackTrace();

                    }

                } catch (FileNotFoundException e) {

// TODO 自动生成 catch 块

                    e.printStackTrace();

                }

//System.out.println("文件："+File);

                return File;

            }

        }//ReadFiles class

    }//ThreadRun class

}//ToOracle class