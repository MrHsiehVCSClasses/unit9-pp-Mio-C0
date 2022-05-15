package u9pp.MonsterFighter;

class HealingMonster extends Monster{
  private int healAmount; 
  public HealingMonster(String name, int maxHealth, int attack, int xp, int healing){
    super(name, maxHealth, attack, xp);
    healAmount = healing;
  }
    public int getHealingPerTurn(){
      return healAmount;
    }
      public String takeTurn(Combatant target){
        super.heal(this.getHealingPerTurn());
        return super.takeTurn(target) + " healed " + this.getHealingPerTurn();
      }
}
