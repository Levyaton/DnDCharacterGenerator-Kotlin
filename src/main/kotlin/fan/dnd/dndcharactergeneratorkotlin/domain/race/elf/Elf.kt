package fan.dnd.dndcharactergeneratorkotlin.domain.race.elf

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeName
import fan.dnd.dndcharactergeneratorkotlin.domain.Language
import fan.dnd.dndcharactergeneratorkotlin.domain.Skill
import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.FeyAncestry
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.Nightvision
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.Trance
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace

@JsonTypeName("elf")
@JsonSubTypes(
   JsonSubTypes.Type(
        value = HighElf::class,
        name = "highElf"
    ),
    JsonSubTypes.Type(value = WoodElf::class, name = "drow"),
    JsonSubTypes.Type(value = DarkElfDrow::class, name = "woodElf")
)
abstract class Elf : AbstractRace() {
    override fun dexterity(): Stat = Stat.Dexterity(2)
    override fun genericAbilities(): Set<Ability> = setOf(Nightvision(), FeyAncestry(), Trance())
    override fun languages(): Set<Language> = setOf(Language.ELVISH) + super.languages()
    override fun proficiencies(): Set<Skill> = setOf(Skill.PERCEPTION)
}
