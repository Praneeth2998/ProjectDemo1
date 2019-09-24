import org.scalatest._
import Character.Character
class TestDamage extends FunSuite{
  test("current HP was reduced by proper amount"){

    var character: Character = new Character(10,10,10,10,100,100)

    character.takeDamage(10)
    assert(character.Max_hp == 90,character)

  }

  test("non-lethal damage and alive"){

    var character: Character = new Character(10,10,10,10,100,100)

    character.takeDamage(50)
    assert(character.alive,character)

  }

  test("lethal damage and dead"){

    var character: Character = new Character(10,10,10,10,100,100)

    character.takeDamage(100)
    assert(!character.alive,character)

  }
}