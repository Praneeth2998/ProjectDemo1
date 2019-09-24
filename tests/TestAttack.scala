import org.scalatest._
import Character.Character
class TestAttack extends FunSuite{
  test("check HP"){

    var character1: Character = new Character(10,5,20,3,100,100)
    var character2: Character = new Character(20,3,10,5,100,100)

    character1.physicalAttack(character2)
    assert(character2.Max_hp == 93,"\n" + character1 + "\n" + character2)

    character1.magicalAttack(character2)
    assert(character2.Max_hp == 78,"\n" + character1 + "\n" + character2)

  }

  test("check MP"){

    var character1: Character = new Character(10,5,20,3,100,100)
    var character2: Character = new Character(20,3,10,5,100,100)

    character1.magicalAttack(character2)
    assert(character1.Max_mp == 99,"\n" + character1 + "\n" + character2)

  }

  test("check MP deals no damage"){

    var character1: Character = new Character(10,5,20,3,100,0)
    var character2: Character = new Character(20,3,10,5,100,100)

    character1.magicalAttack(character2)
    assert(character1.Max_hp == 100,"\n" + character1 + "\n" + character2)

  }
}