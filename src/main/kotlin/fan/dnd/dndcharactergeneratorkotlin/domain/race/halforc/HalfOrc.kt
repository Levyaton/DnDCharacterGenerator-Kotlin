package fan.dnd.dndcharactergeneratorkotlin.domain.race.halforc

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace

class HalfOrc : AbstractRace() {
    override fun strength(): Stat = Stat.Strength(2) // Orcs have +2 Strength


    override fun constitution(): Stat = Stat.Constitution(1) // Orcs have +1 Constitution

}
