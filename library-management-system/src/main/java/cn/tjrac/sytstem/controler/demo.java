package cn.tjrac.sytstem.controler;

import org.springframework.data.annotation.Id;
import sun.rmi.runtime.NewThreadAction;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Rui3g
 * @date 2020/4/29 17:09
 */

public class demo {
    public static final String GSTIME="yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) throws InterruptedException {
       /* String w = " ";
       String date = "100";
       String k = "200";

       w=k+date;
        System.out.println(w);*/
        demo demo = new demo();
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入1号的昵称：");
        String num = scan.next();
        System.out.println("请输入2号的昵称：");
        String num1 = scan.next();
        System.out.println("请输入小号的昵称：");
        String num2 = scan.next();
      w: for (int i=0;i<20;i++) {
           int j=i+1;
           switch (j){
               case 1:
                   System.out.println("===第"+j+"回合===");
                   daiMa1770(num);
                   break;
               case 2:
                   System.out.println("===第"+j+"回合===");
                   daiMa1771(num1);
                   break;
               case 3:
                   daiMa1772(num1);
                   break;
               case 4:
                   daiMa1773(num2);
               case 5:
                   demo.daiMa2020();
               default:
                   System.out.println("===回合结束===");
                   break w;

           }
       }
    }


    public static String getTimestampDate(String timestamp){
        String str;
        SimpleDateFormat unix_time = new SimpleDateFormat(GSTIME);
        str = unix_time.format(new Date(Long.valueOf(timestamp)));
        return str;
    }

    public static void daiMa1770(String num1){
        String str = "";
        List list = new ArrayList();
        list.add("tututu~");
        list.add("啊");
        for (int i=0;i<list.size();i++){
            if (i==0){
                System.out.println(num1+"使用AK进行了射击，"+list.get(i));
            }else {
                System.out.println(num1+"被打败了并且惨叫了一声：“"+list.get(i)+"”");
            }
        }

    }
    public static void daiMa1771(String num1){
        String str = "";
        List list = new ArrayList();
        list.add("pa~~");
        list.add("手成v字");
        for (int i=0;i<list.size();i++){
            if (i==0){
                System.out.println(num1+"使用AWM进行了射击，"+list.get(i));
            }else {
                System.out.println(num1+"胜利了并摆了个poss：“"+list.get(i)+"”");
            }
        }

    }
    public static void daiMa1772(String num1){
        String str = "";
        Map map = new HashMap();
        map.put("go","to");
        map.put("to","dao");
        List<Map<String,String>> maps = new ArrayList<Map<String, String>>();
        maps.add(map);
        for (int i=0;i<maps.size();i++){
            if (i==0){
                System.out.println(num1+"ke"+maps.get(i).get("go"));
            }else {
                System.out.println(num1+"say：“"+maps.get(i).get("to")+"”");
            }
        }

    }
    public static void daiMa1773(String num1){
        System.out.println(num1+"：“hahah"+"”");
    }

    //各种常用语法
    public  static  void daiMa1774(){
        System.out.println("input");
        Scanner sc = new Scanner(System.in);
        List list = new ArrayList();
        Map map = new HashMap();
        Set set = new HashSet();
        int i = 0;
        String str = " ";
        double d = 0;
        long l = 0;
        float f = 0;
        byte b= 0;
        short s = 0;
        boolean bol = true;
        String go = "goto";

        for (int j = 0; j < 25; j++) {

        }
        if (true){
            System.out.println("take");
        }else {}

        while (true){

        }
    }

    public void daiMa2020() throws InterruptedException {
        System.out.println("=======程序开始启动=========");
        long str1 =0;
        long str =0;
        int s = 10;
        for (int i = 0;i<s+16;i++){
            long x= (str-str1)/1000;
            str = 0;
            str1 = 0;
            if (x==1){
                s-=Integer.parseInt(String.valueOf(x));
                if (s>0) {
                    System.out.println("====倒计时:" + s + "秒=====");
                }
            }else {
                str1 =new Date().getTime();
                Thread.sleep(1000);
                str =new Date().getTime();
            }
        }
        System.out.println("====程序启动成功=====");
        System.out.println("=======请开始你的表演=======");
    }

    public void daiMa20204(){
        System.out.println("====启动=====");
    }
}
