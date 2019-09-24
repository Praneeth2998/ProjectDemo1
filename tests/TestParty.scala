import org.scalatest._
import Character.{Character, Party}
class TestParty extends FunSuite{
  test("check experience points are incresed after an attack"){

    var character1: Character = new Character(10,5,20,3,100,100)
    var character2: Character = new Character(20,3,10,5,100,100)
    var character3: Character = new Character(25,3,5,1,100,100)
    character1.handleExperiencePoints(30)
    character2.handleExperiencePoints(30)
    character3.handleExperiencePoints(30)



    var character4: Character = new Character(10,5,20,3,100,100)
    var character5: Character = new Character(20,3,10,5,100,100)
    var character6: Character = new Character(25,3,5,1,100,100)
    character6.alive= false
    character5.handleExperiencePoints(10)


    var party1:Party = new Party( List(character1,character2,character3))
    var party2:Party = new Party(List(character4,character5,character6))
    party2.defeatParty(party1)
    assert(character4.level == 5,"\n" + character4)
    assert(character4.experience_points == 5,"\n" + character4)
    assert(character5.level == 6,"\n" + character4)
    assert(character5.experience_points == 5,"\n" + character4)

  }

}