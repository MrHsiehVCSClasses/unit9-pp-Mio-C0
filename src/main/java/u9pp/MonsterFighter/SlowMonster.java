package u9pp.MonsterFighter;

class SlowMonster extends Monster{
  private int turn = 0;
  
  public SlowMonster(String name, int maxHealth, int attack, int xp){
    super(name, maxHealth, attack, xp);
    turn = 0;
  }
      public String takeTurn(Combatant target){
        turn++;
        if(turn % 2 == 0){
        return super.takeTurn(target);
            
        }
        return this.getName() + " is too slow";
      }
}


