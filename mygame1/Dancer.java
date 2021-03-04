package mygame1;
import java.util.*;


public class Dancer extends Character{
  public Dancer(String name){
    super(name);
  }

  public void attack(Monster[] m){
    System.out.print("誰に攻撃する？[0:ダークドレアム,1:オルゴ・デミーラ]:");
    int selectAttack=new Scanner(System.in).nextInt(); 
    System.out.println("踊り子"+this.name+"の通常攻撃");
    int a = new java.util.Random().nextInt(21)+80;//80から100ダメ
    System.out.println(m[selectAttack].name+"に"+a+"ダメージ与えた");
    m[selectAttack].hp-=a;
    System.out.println("");
  }

  public boolean mpCount(int mp){
    if(mp<10){
      say();
      return false;
    }
    else{
      return true;
    }
  }

  public void dance(Monster[] m,Character[] ch){
    System.out.print("どの踊りを使いますか？[1:てんてこ舞い(10MP),2:ヒールの舞(10MP),3:ラッキーサンバ(10MP)]:");
    int num= new Scanner(System.in).nextInt();
    System.out.println("踊り子"+this.name+"の踊りだ！");
    switch(num){
      case 1:
        if(!mpCount(this.mp)){
          break;
        }
        System.out.println("てんてこ舞い！");
        System.out.println("とても楽しそうだ");
        this.mp-=10;
        break;

      case 2:
        if(!mpCount(this.mp)){
          break;
        }
        System.out.println("ヒールのサンバ!");
        System.out.println("10MP消費して"+this.name+"達は250回復した！");
        for(int i=0; i<ch.length; i++){
          if(ch[i].hp+250>1000){
            ch[i].hp=1000;
          }
          else{
            ch[i].hp+=250;
          }
        }
        this.mp-=10;
        break;

      case 3:
        if(!mpCount(this.mp)){
          break;
        }
        System.out.println("ラッキーサンバ！");
        double damage1_1=new Random().nextInt(600)+1*new Random().nextDouble()+0.1*new Random().nextInt(2)+1;
        double damage1_2=new Random().nextInt(600)+1*new Random().nextDouble()+0.1*new Random().nextInt(2)+1;
        System.out.println(m[0].name+"に"+(int)damage1_1+"ダーメジ与えた");
        System.out.println(m[1].name+"に"+(int)damage1_2+"ダーメジ与えた");
        m[0].hp-=(int)damage1_1;
        m[1].hp-=(int)damage1_2;
        this.mp-=10;
        break;
    }
    System.out.println("");
  }
}
