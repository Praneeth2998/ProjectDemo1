package Character


class Party(var characters: List[Character]) {

  def defeatParty(party: Party):Unit = {
    var exps = 0.0
    party.characters.foreach(ch =>{
      exps += (ch.level -1)*10 + ch.experience_points
    })

    var alive_players = this.characters.filter(ch=>ch.alive)
    this.characters.filter(ch=>ch.alive).foreach(ch=>{
      ch.handleExperiencePoints(exps/alive_players.length)
    })
  }
}
