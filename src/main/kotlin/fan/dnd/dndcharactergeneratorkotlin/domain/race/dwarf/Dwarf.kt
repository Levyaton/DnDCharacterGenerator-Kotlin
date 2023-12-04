package fan.dnd.dndcharactergeneratorkotlin.domain.race.dwarf

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace

abstract class Dwarf : AbstractRace() {
    override fun constitution(): Stat = Stat.Constitution(2)
}
