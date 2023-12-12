package fan.dnd.dndcharactergeneratorkotlin.domain.race.changling

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race
import fan.dnd.dndcharactergeneratorkotlin.domain.race.RaceCreator
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceDao


class Changeling internal constructor(selectedStat: ModifierInput) : AbstractRace() {
    override fun raceName() = Race.CHANGELING

    private var dexMod = 0
    private var intMod = 0

    init {
        when(selectedStat){
            ModifierInput.DEXTERITY -> dexMod = 1
            ModifierInput.INTELLIGENCE -> intMod = 1
        }
    }
    override fun dexterity(): Stat = Stat.Dexterity(dexMod)
    override fun intelligence(): Stat = Stat.Intelligence(intMod)
    override fun charisma(): Stat = Stat.Charisma(2)

    enum class ModifierInput {
        DEXTERITY,
        INTELLIGENCE
    }
}
