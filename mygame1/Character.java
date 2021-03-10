package mygame1;

public abstract class Character {
  String name;
  int hp;
  int mp;
  boolean noalive;

  public Character(String name){
    this.name=name;
    this.hp=1000;
    this.mp=100;
    this.noalive=false;
  }
  
  public abstract void attack(Monster[] m);

  public void run(){
    System.out.println(this.name+"達は逃げ出した");
  }

  // public void status(){
  //   System.out.println("-----------------------------------");
  //   System.out.println("  "+this.name+"のステータス");
  //   System.out.println("  HP: "+this.hp);
  //   System.out.println("  MP: "+this.mp);
  //   System.out.println("-----------------------------------");
  // }
  public void status(){
    System.out.println("-----------------------------------");
    System.out.println(String.format("%-3s %-20s %4s","|",this.name+"のステータス","|"));
    System.out.println(String.format("%-3s HP:%-10d %17s","|",this.hp,"|"));
    System.out.println(String.format("%-3s MP:%-10d %17s","|",this.mp,"|"));
    System.out.println("-----------------------------------");
  }

  public void say(){
    System.out.println("MP足りねえや");
  }
}
