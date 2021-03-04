package mygame1;
import java.util.*;

public class Wizard extends Character{
  public Wizard(String name){
    super(name);
    this.mp=500;
  }

  public void attack(Monster[] m){
    System.out.print("誰に攻撃する？[0:ダークドレアム,1:オルゴ・デミーラ]:");
    int selectAttack=new Scanner(System.in).nextInt();  
    System.out.println("魔法使い"+this.name+"の通常攻撃");
    int a = new java.util.Random().nextInt(50)+1;//1から50ダメ
    System.out.println(m[selectAttack].name+"に"+a+"ダメージ与えた");
    m[selectAttack].hp-=a;
    System.out.println("");
  }

  public void magic(Monster[] m){
    System.out.print("どの魔法を使いますか？[1:天の鎖(50MP),2:ラムセウス・テンティリス(150MP),3:バイバイン,4:ラリホーマ(15MP)]:");
    int num= new Scanner(System.in).nextInt();
    System.out.println("魔法使い"+this.name+"の魔法攻撃");
    switch(num){
      case 1:
        if(this.mp<50){
          say();
          break;
        }
        System.out.println("天の鎖！");//全体に固定400ダメ
        System.out.println("50MP消費して"+m[0].name+"達に400ダメージ与えた！");
        for(int i=0; i<m.length; i++){
          m[i].hp-=400;
        }
        this.mp-=50;
        break;

      case 2:
        if(this.mp<150){
          say();
          break;
        }
        System.out.print("誰に攻撃する？[0:ダークドレアム,1:オルゴ・デミーラ]:");
        int selectramuseusu=new Scanner(System.in).nextInt(); 
        System.out.println("ラムセウス・テンティリス！");//単体に固定1000ダメージ
        System.out.println("150MP消費して"+m[selectramuseusu].name+"に1000ダメージ与えた!");
        m[selectramuseusu].hp-=1000;
        this.mp-=150;
        break;

      case 3:
        System.out.println("バイバイン！");
        if(this.mp>250){
          this.mp=500;
        }
        else{
          this.mp*=2;
        }
        System.out.println("MPが倍になった！");
        System.out.println(this.name+"の現在のMPは"+this.mp+"です");
        break;

      case 4:
        if(this.mp<15){
          say();
          break;
        }
        System.out.println("ラリホーマ！");
        int a= new Random().nextInt(5);
        if(a==0){
          System.out.println("成功！");
          System.out.println("15MP消費して"+m[0].name+"達を眠らせた！");
          for(int i=0; i<m.length; i++){
            m[i].sleep=true;
          }
        }
        else{
          System.out.println("失敗…");
          System.out.println("15MP消費した");
        }
        this.mp-=15;
        break;
    }
    System.out.println("");
  }
}
