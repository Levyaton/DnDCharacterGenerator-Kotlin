package fan.dnd.dndcharactergeneratorkotlin.domain.race.dwarf

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat

class HillDwarf : Dwarf() {
    override fun strength(): Stat = Stat.Strength(2)

}
