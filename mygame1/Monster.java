package mygame1;

public abstract class Monster {
  String name;
  int hp;
  boolean poison;
  boolean sleep;
  boolean noalive;

  public Monster(String name){
    this.name=name;
    this.hp=10000;
    this.poison=false;
    this.sleep=false;
    this.noalive=false;
  }

  public abstract void attack(Character[] c);
}
