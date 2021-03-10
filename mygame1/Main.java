package mygame1;
import java.util.*;

public class Main {
  public static void main(String[] args){
    boolean heroStatus=true;
    boolean archerStatus=true;
    boolean wizaedStatus=true;
    boolean dancerStatus=true;
    System.out.println("ドラエフの世界へようこそ！");
    System.out.println("");

    System.out.print("勇者の名前を入力してね:");
    String name1=new Scanner(System.in).nextLine();
    // Hero hero = new Hero(name1);
    System.out.println("");

    System.out.print("魔法使いの名前を入力してね:");
    String name2=new Scanner(System.in).nextLine();
    // Wizard wizard = new Wizard(name2);
    System.out.println("");

    System.out.print("踊り子の名前を入力してね:");
    String name3=new Scanner(System.in).nextLine();
    // Dancer dancer = new Dancer(name3);
    System.out.println("");

    System.out.print("弓使いの名前を入力してね:");
    String name4=new Scanner(System.in).nextLine();
    // Archer archer = new Archer(name4);
    System.out.println("");
    Character[] characters = new Character[4];
    characters[0]=new Hero(name1);
    characters[1]=new Wizard(name2);
    characters[2]=new Dancer(name3);
    characters[3]=new Archer(name4);
    Hero hero = (Hero)characters[0];
    Wizard wizard = (Wizard)characters[1];
    Dancer dancer = (Dancer)characters[2];
    Archer archer = (Archer)characters[3];

    try{
      Thread.sleep(2000);
    }catch(InterruptedException e){
    }

    System.out.println("では戦闘を開始する");

    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
    }

    System.out.println(3);

    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
    }

    System.out.println(2);

    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
    }

    System.out.println(1);

    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
    }

    // System.out.println("戦闘開始！！！！！");
    System.out.println("");

    try{
      Thread.sleep(1500);
    }catch(InterruptedException e){
    }

    System.out.println("-------------------------------------------------");//format文日本語入力のときはバグるため、使わないor字数で余白計算
    System.out.println(String.format("%s %-31s %2s","|","ダークドレアムがあらわれた!","|"));
    System.out.println(String.format("%s %-30s %2s","|","オルゴ・デミーラがあらわれた!","|"));
    System.out.println("-------------------------------------------------");
    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
    }
    Monster[] monsters=new Monster[2];
    monsters[0]=new DarkDream();
    monsters[1]=new Orgodemila();
    System.out.println("");

    //逃げるか戦うか
    boolean fight=false;

    while(!fight){
      //勇者の行動ターン
      while(heroStatus&&!characters[0].noalive){
        System.out.print("勇者は何をしますか？[１：攻撃　２：魔法攻撃　３：逃げる　４：ステータスを見る]：");
        int heroturn = new Scanner(System.in).nextInt();
        /*関数化の例
        関数f(boolean a(heroturn),Character b(hero),Monsters[] c(monsters),Characters[] d(characters),boolean e(heroStatus),boolean f(fight)){
          while(e&&d[0].allive){
            switch(a){
              case 1:
                b.attack(c);
                e=false;
                die(c);
                break;
              case 2:
                b.magic(c,d);
                e=false;
                die(c);
                break;
              case 3:
                b.run();
                f=true;  必要ならreturnで返す
                e=false;
                break;
            }
          }
        }
        */
        switch (heroturn){
          case 1:
            hero.attack(monsters);
            heroStatus=false;
            die(monsters);
            break;
          
          case 2:
            hero.magic(monsters,characters);
            heroStatus=false;
            die(monsters);
            break;
  
          case 3:
            hero.run();
            fight=true;
            heroStatus=false;
            break;
  
          case 4:
            hero.status();
            System.out.print("見終わったら1を入力してください:");
            int statusNum=new Scanner(System.in).nextInt();
            System.out.println("");
            break;
        }
      }
      heroStatus=true;
      if(annihilatedMonster(monsters)){
        break;
      }
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
      }
      
      //魔法使いの行動ターン
      while(wizaedStatus&&!fight&&!characters[1].noalive){
        System.out.print("魔法使いは何をしますか？[１：攻撃　２：魔法攻撃　３：逃げる　４：ステータスを見る]：");
        int wizaradturn = new Scanner(System.in).nextInt();
        switch (wizaradturn){
          case 1:
            wizard.attack(monsters);
            wizaedStatus=false;
            die(monsters);
            break;
          
          case 2:
            wizard.magic(monsters);
            wizaedStatus=false;
            die(monsters);
            break;
  
          case 3:
            wizard.run();
            fight=true;
            wizaedStatus=false;
            break;
  
          case 4:
            wizard.status();
            System.out.print("見終わったら1を入力してください:");
            int statusNum=new Scanner(System.in).nextInt();
            System.out.println("");
            break;
        }
      }
      wizaedStatus=true;
      if(annihilatedMonster(monsters)){
        break;
      }
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
      }

      //踊り子の行動ターン
      while(dancerStatus&&!fight&&!characters[2].noalive){
        System.out.print("踊り子は何をしますか？[１：攻撃　２：踊り　３：逃げる　４：ステータスを見る]：");
        int dancerturn = new Scanner(System.in).nextInt();
        switch (dancerturn){
          case 1:
            dancer.attack(monsters);
            dancerStatus=false;
            die(monsters);
            break;
          
          case 2:
            dancer.dance(monsters,characters);
            dancerStatus=false;
            die(monsters);
            break;
  
          case 3:
            dancer.run();
            fight=true;
            dancerStatus=false;
            break;
  
          case 4:
            dancer.status();
            System.out.print("見終わったら1を入力してください:");
            int statusNum=new Scanner(System.in).nextInt();
            System.out.println("");
            break;
        }
      }
      dancerStatus=true;
      if(annihilatedMonster(monsters)){
        break;
      }
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
      }

      //弓使いの行動ターン
      while(archerStatus&&!fight&&!characters[3].noalive){
        System.out.print("弓使いは何をしますか？[１：攻撃　２：魔法攻撃　３：逃げる　４：ステータスを見る]：");
        int archerturn = new Scanner(System.in).nextInt();
        switch (archerturn){
          case 1:
            archer.attack(monsters);
            archerStatus=false;
            die(monsters);
            break;
          
          case 2:
            archer.magic(monsters);
            archerStatus=false;
            die(monsters);
            break;
  
          case 3:
            archer.run();
            fight=true;
            archerStatus=false;
            break;
  
          case 4:
            archer.status();
            System.out.print("見終わったら1を入力してください:");
            int statusNum=new Scanner(System.in).nextInt();
            System.out.println("");
            break;
        }
      }
      archerStatus=true;
      if(annihilatedMonster(monsters)){
        break;
      }
      try{
        Thread.sleep(2000);
      }catch(InterruptedException e){
      }

      //敵の行動ターン
      if(!fight){
        //ダークドレアム
        if(!monsters[0].sleep&&!monsters[0].noalive){
          monsters[0].attack(characters);
          die(characters);
        }
        else if(monsters[0].noalive){
        }
        else{
          int sleepDark=new Random().nextInt(3);
          if(sleepDark==0){
            monsters[0].sleep=false;
            System.out.println(monsters[0].name+"は目を覚ました");
            System.out.println("");
          }
          else{
            System.out.println(monsters[0].name+"はぐうぐう眠っている");
            System.out.println("");
          }
        }
        if(annihilatedCharacter(characters)){
          break;
        }
        try{
          Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        
        //オルゴ・デミーラ
        if(!monsters[1].sleep&&!monsters[1].noalive){
          monsters[1].attack(characters);
          die(characters);
        }
        else if(monsters[1].noalive){
        }
        else{
          int sleepOrgo=new Random().nextInt(3);
          if(sleepOrgo==0){
            monsters[1].sleep=false;
            System.out.println(monsters[1].name+"は目を覚ました");
            System.out.println("");
          }
          else{
            System.out.println(monsters[1].name+"はぐうぐう眠っている");
            System.out.println("");
          }
        }
        if(annihilatedCharacter(characters)){
          break;
        }
      }
    }
    System.out.println("戦闘を終了します");
  }

  public static void die(Monster[] m){
    for(int i=0; i<m.length; i++){
      if(m[i].hp<=0){
        m[i].noalive=true;
        System.out.println(m[i].name+"はご臨終です");
      }
    }
  }

  public static void die(Character[] ch){
    for(int i=0; i<ch.length; i++){
      if(ch[i].hp<=0){
        ch[i].noalive=true;
        System.out.println(ch[i].name+"はご臨終です");
      }
    }
  }

  public static boolean annihilatedCharacter(Character[] ch){
    int count=0;
    for(Character cnt:ch){
      if(cnt.noalive){
        count++;
      }
    }
    if(count==ch.length){
      System.out.println("パーティーは全滅した…");
      return true;
    }
    else{
      return false;
    }
  }
  public static boolean annihilatedMonster(Monster[] mon){
    int count=0;
    for(Monster cnt:mon){
      if(cnt.noalive){
        count++;
      }
    }
    if(count==mon.length){
      System.out.println("敵を全滅させた！");
      return true;
    }
    else{
      return false;
    }
  }
}
