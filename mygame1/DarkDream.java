package mygame1;
import java.util.*;


public class DarkDream extends Monster {
  public DarkDream(){
    super("ダークドレアム");
    if(this.poison){
      this.hp-=100;
    }
  }

  public void attack(Character[] ch){
    int num=new Random().nextInt(4)+1;
    switch(num){
      case 1:
        System.out.println(this.name+"のギガデイン！");
        int damage1=new Random().nextInt(101)+100;//全体に100～200ダメージ
        System.out.println(ch[0].name+"達に"+damage1+"ダメージ与えた");
        for(int i=0; i<ch.length; i++){
          ch[i].hp-=damage1;
        }
        break;

      case 2:
        System.out.println(this.name+"のかがやくいき！");
        System.out.println(ch[0].name+"達に160ダメージ与えた");//全体に固定160ダメージ
        for(int i=0; i<ch.length; i++){
          ch[i].hp-=160;
        }
        break;

      case 3:
        System.out.println(this.name+"のレラジェ！");
        int damage2=new Random().nextInt(101)+50;//単体に50～150ダメージ
        int selectreraje=new Random().nextInt(4);
        System.out.println(ch[selectreraje].name+"に"+damage2+"ダメージ与えた");
        ch[selectreraje].hp-=damage2;
        break;

      case 4:
        System.out.println(this.name+"のスーパーノヴァ");
        int nova=new Random().nextInt(10);
        if(nova==7&&this.poison){
          System.out.println("即死攻撃だ！");
          int selectnova=new Random().nextInt(4);
          System.out.println(ch[selectnova].name+"は即死した");
        }
        else{
          System.out.println("しかし何も起こらなかった");
        }
        break;
    }
    System.out.println("");
  }
}
