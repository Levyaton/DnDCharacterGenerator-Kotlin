package fan.dnd.dndcharactergeneratorkotlin.domain.race

import fan.dnd.dndcharactergeneratorkotlin.domain.Language
import fan.dnd.dndcharactergeneratorkotlin.domain.race.changling.Changeling
import fan.dnd.dndcharactergeneratorkotlin.domain.race.dragonborn.Dragonborn
import fan.dnd.dndcharactergeneratorkotlin.domain.race.dwarf.HillDwarf
import fan.dnd.dndcharactergeneratorkotlin.domain.race.dwarf.MountainDwarf
import fan.dnd.dndcharactergeneratorkotlin.domain.race.elf.DarkElfDrow
import fan.dnd.dndcharactergeneratorkotlin.domain.race.elf.HighElf
import fan.dnd.dndcharactergeneratorkotlin.domain.race.elf.WoodElf
import fan.dnd.dndcharactergeneratorkotlin.domain.race.gnome.Gnome
import fan.dnd.dndcharactergeneratorkotlin.domain.race.halfelf.HalfElf
import fan.dnd.dndcharactergeneratorkotlin.domain.race.halfling.Halfling
import fan.dnd.dndcharactergeneratorkotlin.domain.race.halforc.HalfOrc
import fan.dnd.dndcharactergeneratorkotlin.domain.race.human.Human
import fan.dnd.dndcharactergeneratorkotlin.domain.race.tiefling.Tiefling
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.SpellBook
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceDao

class RaceCreator {
   companion object{
       fun build(raceDao: RaceDao): AbstractRace = when(raceDao.raceName){
               Race.HIGH_ELF -> buildHighElf(raceDao)
               Race.WOOD_ELF -> buildWoodElf()
               Race.DARK_ELF -> buildDarkElf()
               Race.CHANGELING -> buildChangeling(raceDao)
               Race.DRAGONBORN -> buildDragonborn(raceDao)
               Race.HILL_DWARF -> buildHillDwarf(raceDao)
               Race.MOUNTAIN_DWARF -> buildMountainDwarf(raceDao)
               Race.GNOME -> buildGnome(raceDao)
               Race.HALF_ELF -> buildHalfElf(raceDao)
               Race.HALF_ORC -> buildHalfOrc(raceDao)
               Race.HALFLING -> buildHalfling(raceDao)
               Race.HUMAN -> buildHuman(raceDao)
               Race.TIEFLING -> buildTiefling(raceDao)
           }


       private fun buildHighElf(raceDao: RaceDao): HighElf = HighElf(
               cantrip = SpellBook.findWizardCantrip(raceDao.cantrips.first().spellId) ?: throw IllegalStateException("High Elf must have cantrips that directly map to the wizard cantrop ids!"),
               extraLanguage = raceDao.languages.first { !listOf(Language.ELVISH, Language.COMMON).contains(it) })


       private fun buildWoodElf(): WoodElf = WoodElf()


       private fun buildDarkElf(): DarkElfDrow = DarkElfDrow()


         private fun buildChangeling(raceDao: RaceDao): Changeling =Changeling(if(raceDao.dexterity > raceDao.intelligence) Changeling.ModifierInput.DEXTERITY else Changeling.ModifierInput.INTELLIGENCE)


            private fun buildDragonborn(raceDao: RaceDao): Dragonborn =
                "\\b(\\w+)\\s+Dragonborn\\b".toRegex().find(raceDao.otherTraits)?.let{
                    Dragonborn(Dragonborn.Color.valueOf(it.groupValues[1]))
                } ?: throw IllegalStateException("Dragonborn must have a color in the other traits field")

            private fun buildHillDwarf(raceDao: RaceDao): HillDwarf {
                return HillDwarf()
            }

            private fun buildMountainDwarf(raceDao: RaceDao): MountainDwarf {
                return MountainDwarf()
            }

            private fun buildGnome(raceDao: RaceDao): Gnome {
                return Gnome()
            }

            private fun buildHalfElf(raceDao: RaceDao): HalfElf {
                return HalfElf()
            }

            private fun buildHalfOrc(raceDao: RaceDao): HalfOrc {
                return HalfOrc()
            }

            private fun buildHalfling(raceDao: RaceDao): Halfling {
                return Halfling()
            }

            private fun buildHuman(raceDao: RaceDao): Human {
                return Human()
            }

            private fun buildTiefling(raceDao: RaceDao): Tiefling {
                return Tiefling()
            }

   }
}