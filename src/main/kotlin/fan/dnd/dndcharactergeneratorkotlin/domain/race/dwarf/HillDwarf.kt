package fan.dnd.dndcharactergeneratorkotlin.domain.race.dwarf

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

class HillDwarf : Dwarf() {
    override fun raceName(): Race = Race.HILL_DWARF

    override fun strength(): Stat = Stat.Strength(2)

}
