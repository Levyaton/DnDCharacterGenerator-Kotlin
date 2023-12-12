package fan.dnd.dndcharactergeneratorkotlin.domain.race.dwarf

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

class MountainDwarf : Dwarf() {
    override fun raceName(): Race = Race.MOUNTAIN_DWARF

    override fun wisdom(): Stat = Stat.Wisdom(1)

}
