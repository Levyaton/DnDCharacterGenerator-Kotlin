package fan.dnd.dndcharactergeneratorkotlin.domain.race.dwarf

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat

class MountainDwarf : Dwarf() {
    override fun wisdom(): Stat = Stat.Wisdom(1)

}
