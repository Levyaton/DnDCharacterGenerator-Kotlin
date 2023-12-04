package fan.dnd.dndcharactergeneratorkotlin.domain.race


import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import fan.dnd.dndcharactergeneratorkotlin.domain.*
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.race.dragonborn.Dragonborn
import fan.dnd.dndcharactergeneratorkotlin.domain.race.elf.Elf
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.Spellbook
import fan.dnd.dndcharactergeneratorkotlin.persistance.SpellDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = Elf::class, name = "highElf"),
    JsonSubTypes.Type(value = Dragonborn::class, name = "dragonborn")
)
abstract class AbstractRace{
    @Autowired
    @JsonIgnore
    protected lateinit var spellbook: Spellbook
    fun raceName(): String = this.javaClass.simpleName
    fun otherTraits(): String = ""

    fun speed(): Int = 30 // Default speed

    fun cantrips(): Set<SpellDao> = emptySet()

    fun spells(): Set<SpellDao> = emptySet()


    fun genericAbilities(): Set<Ability> = emptySet()

    fun damageAbilities(): Set<Ability> = emptySet()

    fun proficiencies(): Set<Skill> = emptySet()

    fun languages(): Set<Language> = setOf(Language.COMMON)


    fun armourProficiencies(): Set<Armour> = emptySet()

    fun weaponProficiencies(): Set<Weapon> = emptySet()

    fun strength(): Stat = Stat.Strength(0)


    fun dexterity(): Stat = Stat.Dexterity(0)


    fun constitution(): Stat = Stat.Constitution(0)


    fun intelligence(): Stat = Stat.Intelligence(0)


    fun wisdom(): Stat = Stat.Wisdom(0)


    fun charisma(): Stat = Stat.Charisma(0)

}