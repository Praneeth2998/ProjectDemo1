package Character

class Character(var Attack_power: Int,var Defense:Int,var Magical_attack:Int,
                var Magical_defense:Int,var Max_hp:Int,var Max_mp:Int) {

  var alive: Boolean = true;
  var experience_points:Double = 0.0;
  var level:Int = 1;

  def takeDamage(damage:Int):Unit = {
    this.Max_hp = this.Max_hp - damage
    if(this.Max_hp <=0){
      this.alive = false
    }
  }

  def handleDeath():Unit = {
    experience_points = 0.0;
    level = 0;
  }

  def physicalAttack(dTaker: Character):Unit={
    var damage: Int = this.Attack_power - dTaker.Defense
    dTaker.takeDamage(damage)
    var points:Double = 1
    if(!dTaker.alive){
      var exp = (dTaker.level -1)*10 + dTaker.experience_points
      points += (exp*25)/100
      dTaker.handleDeath()
    }
    handleExperiencePoints(points)
  }

  def handleExperiencePoints(points:Double):Unit = {

    experience_points += points

    if (experience_points/10>0){
      level += experience_points.toInt/10
      handleLevelUp(experience_points.toInt/10)
      experience_points = experience_points%10
    }
  }

  def handleLevelUp(levels:Int): Unit ={
   Attack_power += Math.ceil((Attack_power.toDouble*levels*10)/100).toInt
    Defense += Math.ceil((Defense.toDouble*levels*10)/100).toInt

    Magical_attack += Math.ceil((Magical_attack.toDouble*levels*10)/100).toInt
    Magical_defense += Math.ceil((Magical_defense.toDouble*levels*10)/100).toInt
    Max_hp += Math.ceil((Max_hp.toDouble*levels*10)/100).toInt
    Max_mp += Math.ceil((Max_mp.toDouble*levels*10)/100).toInt
  }

  def magicalAttack(dTaker: Character):Unit = {

    if(this.Max_mp >0){
      var damage:Int = this.Magical_attack - dTaker.Magical_defense
      dTaker.takeDamage(damage)
      this.Max_mp = this.Max_mp-1
      var points:Double = 1
      if(!dTaker.alive){
        var exp = (dTaker.level -1)*10 + dTaker.experience_points
       points += (exp*25)/100
        dTaker.handleDeath()
      }
      handleExperiencePoints(points)
    }
  }
}

