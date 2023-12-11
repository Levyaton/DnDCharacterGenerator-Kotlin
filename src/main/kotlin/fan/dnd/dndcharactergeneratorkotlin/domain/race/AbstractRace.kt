package fan.dnd.dndcharactergeneratorkotlin.domain.race

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import fan.dnd.dndcharactergeneratorkotlin.domain.*
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import fan.dnd.dndcharactergeneratorkotlin.domain.race.dragonborn.Dragonborn
import fan.dnd.dndcharactergeneratorkotlin.domain.race.elf.Elf
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceDao
import org.apache.commons.lang3.builder.HashCodeBuilder


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = Elf::class, name = "highElf"),
    JsonSubTypes.Type(value = Dragonborn::class, name = "dragonborn")
)
abstract class AbstractRace{
    abstract fun raceName(): Race
    fun otherTraits(): String = ""

    fun speed(): Int = 30 // Default speed

    fun cantrips(): Set<Int> = emptySet()

    fun spells(): Set<Int> = emptySet()


    fun genericAbilities(): Set<Ability> = emptySet()

    fun damageAbilities(): Set<AttackAbility> = emptySet()

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

    override fun equals(other: Any?): Boolean = this.hashCode() == other.hashCode()

    override fun hashCode(): Int =
        HashCodeBuilder()
            .append(raceName())
            .append(otherTraits())
            .append(speed())
            .append(cantrips())
            .append(spells())
            .append(genericAbilities())
            .append(damageAbilities())
            .append(proficiencies())
            .append(languages())
            .append(armourProficiencies())
            .append(weaponProficiencies())
            .append(strength())
            .append(dexterity())
            .append(constitution())
            .append(intelligence())
            .append(wisdom())
            .append(charisma())
            .append(raceName())
            .append(otherTraits())
            .append(speed())
            .append(cantrips())
            .append(spells())
            .append(genericAbilities())
            .append(damageAbilities())
            .append(proficiencies())
            .append(languages())
            .append(armourProficiencies())
            .append(weaponProficiencies())
            .toHashCode()
}