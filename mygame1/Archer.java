package mygame1;
import java.util.*;


public class Archer extends Character{
  public Archer(String name){
    super(name);
  }

  public void attack(Monster[] m){
    System.out.print("誰に攻撃する？[0:ダークドレアム,1:オルゴ・デミーラ]:");
    int selectAttack=new Scanner(System.in).nextInt();
    System.out.println("弓使い"+this.name+"の通常攻撃");
    int a = new Random().nextInt(21)+80;//80から100ダメ
    System.out.println(m[selectAttack].name+"に"+a+"ダメージ与えた");
    m[selectAttack].hp-=a;
    System.out.println("");
  }

  public void magic(Monster[] m){
    System.out.print("どの魔法を使いますか？[1:雷の矢(15MP),2:エヌマ・エリシュ(15MP),3:毒の雨(5MP)]:");
    int num= new Scanner(System.in).nextInt();
    System.out.println("弓使い"+this.name+"の魔法攻撃");
    switch(num){
      case 1:
        if(this.mp<15){
          say();
          break;
        }
        System.out.println("雷の矢！");
        int a = new Random().nextInt(10);
        if(a==7){
          System.out.println("大成功！");
          int damage1_1=m[0].hp/3;
          int damage1_2=m[1].hp/3;
          System.out.println("15MP消費して"+m[0].name+"に"+damage1_1+"ダメージ、"+m[1].name+"に"+damage1_2+"ダメージ与えた！");
          m[0].hp-=damage1_1;
          m[1].hp-=damage1_2;
        }
        else if(a==6){
          System.out.println("成功！");
          int damage2_1=m[0].hp/3;
          int damage2_2=m[1].hp/3;
          System.out.println("15MP消費して"+m[0].name+"に"+damage2_1+"ダメージ、"+m[1].name+"に"+damage2_2+"ダメージ与えた！");
          m[0].hp-=damage2_1;
          m[1].hp-=damage2_2;
        }
        else{
          System.out.println("失敗…");
          System.out.println("15MP消費した");
        }
        this.mp-=15;
        break;
        
      case 2:
        if(this.mp<15){
          say();
          break;
        }
        System.out.println("エヌマ・エリシュ！");
        int damage3= new Random().nextInt(301)+100;//全体100～400ダメ
        System.out.println("15MP消費して"+m[0].name+"達に"+damage3+"ダメージ与えた！");
        for(int i=0; i<m.length; i++){
          m[i].hp-=damage3;
        }
        this.mp-=15;
        break;

      case 3:
        if(this.mp<5){
          say();
          break;
        }
        System.out.println("毒の雨！");
        System.out.println("5MP消費して相手を毒状態にした！");
        for(int i=0; i<m.length; i++){
          m[i].poison=true;
        }
        this.mp-=5;
        break;

    }
    System.out.println("");
  }
}

