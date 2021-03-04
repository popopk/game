package mygame1;
import java.util.*;


public class Hero extends Character{
  public Hero(String name){
    super(name);
  }

  public void attack(Monster[] m){
    System.out.print("誰に攻撃する？[0:ダークドレアム,1:オルゴ・デミーラ]");
    int selectAttack=new Scanner(System.in).nextInt();
    System.out.println("勇者"+this.name+"の通常攻撃");
    int a = new Random().nextInt(26)+100;//100～125ダメ
    System.out.println(m[selectAttack].name+"に"+a+"ダメージ与えた");
    m[selectAttack].hp-=a;
    System.out.println("");
  }

  public void magic(Monster[] m,Character[] ch){
    System.out.print("どの魔法を使いますか？[1:メラゾーマ(20MP),2:イオナズン(25MP),3:ベホイミ(5MP),4:ベホマラー(15MP)]:");
    int num= new Scanner(System.in).nextInt();
    System.out.println("勇者"+this.name+"の魔法攻撃");
    switch (num){
      case 1:
        if(this.mp<20){
          say();
          break;
        }
        System.out.print("誰に攻撃する？[0:ダークドレアム,1:オルゴ・デミーラ]:");
        int selectmerazoma = new Scanner(System.in).nextInt();
        System.out.println("メラゾーマ！");
        int a = new Random().nextInt(101)+200;//単体200～300ダメ
        System.out.println("20MP消費して"+m[selectmerazoma].name+"に"+a+"ダメージ与えた！");
        m[selectmerazoma].hp-=a;
        this.mp-=20;
        break;
        
      case 2:
        if(this.mp<25){
          say();
          break;
        }
        System.out.println("イオナズン！");
        int b = new Random().nextInt(51)+150;//全体150～200ダメ
        System.out.println("25MP消費して"+m[0].name+"達に"+b+"ダメージ与えた！");
        for(int i=0; i<m.length; i++){
          m[i].hp-=b;
        }
        this.mp-=25;
        break;

      case 3:
        if(this.mp<5){
          say();
          break;
        }
        System.out.print("誰を回復させる？[0:勇者,1:魔法使い,2:踊り子,3:弓使い]:");
        int selectbehoimi = new Scanner(System.in).nextInt();
        System.out.println("ベホイミ！");
        System.out.println("5MP消費して"+ch[selectbehoimi].name+"は500回復した");
        if(ch[selectbehoimi].hp+500>1000){
          ch[selectbehoimi].hp=1000;
        }
        else{
          ch[selectbehoimi].hp+=500;
        }
        this.mp-=5;
        break;

      case 4:
        if(this.mp<15){
          say();
          break;
        }
        System.out.println("ベホマラー！");
        System.out.println("15MP消費して"+this.name+"達は400回復した");
        for(int i=0; i<ch.length; i++){
          if(ch[i].hp+400>1000){
            ch[i].hp=1000;
          }
          else{
            ch[i].hp+=400;
          }
        }
        this.mp-=15;
        break;
    }
    System.out.println("");
  }
}
