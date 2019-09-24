import org.scalatest._
import Character.Character
class TestLevelUp extends FunSuite{
  test("check experience points are incresed after an attack"){

    var character1: Character = new Character(10,5,20,3,100,100)
    var character2: Character = new Character(20,3,10,5,100,100)

    character1.physicalAttack(character2)
    assert(character1.experience_points == 1,"\n" + character1 + "\n" + character2)


  }

  test("check level up and stats increase"){

    var character1: Character = new Character(10,5,20,3,100,100)
    var character2: Character = new Character(20,3,10,5,100,100)

    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    character1.physicalAttack(character2)
    assert(character1.experience_points == 0,"\n" + character1)
    assert(character1.level== 2,"\n" + character1 )
    assert(character1.Attack_power== 11,"\n" + character1 )
    assert(character1.Defense == 6,"\n" + character1 )
    assert(character1.Magical_attack == 22,"\n" + character1 )
    assert(character1.Magical_defense == 4,"\n" + character1 )
    assert(character1.Max_hp == 110,"\n" + character1 )
    assert(character1.Max_mp == 110,"\n" + character1 )
  }

  test("2 levels up"){

    var character1: Character = new Character(10,5,20,3,100,100)
    var character2: Character = new Character(20,3,10,5,100,100)

    character1.handleExperiencePoints(20)


    assert(character1.level == 3,"\n" + character1 + "\n" + character2)


  }

  test("when character 2 is dead"){

    var character1: Character = new Character(10,5,20,3,100,100)
    var character2: Character = new Character(20,3,10,5,100,100)

    character2.experience_points = 9
    character2.alive = false
    character1.physicalAttack(character2)


    assert(character1.experience_points == 3.25,"\n" + character1 + "\n" + character2)


  }
}