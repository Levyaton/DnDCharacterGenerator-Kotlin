package fan.dnd.dndcharactergeneratorkotlin.domain.race.dragonborn

import com.fasterxml.jackson.annotation.JsonTypeName
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.DamageType
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.DiceType
import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.StatName
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.attack.Dragonbreath
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Distance
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

@JsonTypeName("dragonborn")
class Dragonborn internal constructor(private val color: Color) : AbstractRace() {
    override fun raceName(): Race = Race.DRAGONBORN

    private val damageType: DamageType = when (color) {
        Color.BLACK -> DamageType.ACID
        Color.BLUE -> DamageType.LIGHTNING
        Color.BRASS -> DamageType.FIRE
        Color.BRONZE -> DamageType.LIGHTNING
        Color.COPPER -> DamageType.ACID
        Color.GOLD -> DamageType.FIRE
        Color.GREEN -> DamageType.POISON
        Color.RED -> DamageType.FIRE
        Color.SILVER -> DamageType.COLD
        Color.WHITE -> DamageType.COLD
    }
    private val statName: StatName = when (color) {
        Color.BLACK, Color.COPPER, Color.BRASS, Color.GOLD, Color.RED, Color.BLUE, Color.BRONZE -> StatName.DEXTERITY
        Color.GREEN, Color.SILVER, Color.WHITE -> StatName.CONSTITUTION
    }

    enum class Color {
        BLACK,
        BLUE,
        BRASS,
        BRONZE,
        COPPER,
        GOLD,
        GREEN,
        RED,
        SILVER,
        WHITE
    }


    override fun strength(): Stat {
        return Stat.Strength(2)
    }

    override fun charisma(): Stat {
        return Stat.Charisma(1)
    }

    override fun otherTraits(): String {
        return color.name + " Dragonborn"
    }

    override fun damageAbilities(): Set<AttackAbility> {
        return setOf(Dragonbreath(
            savingThrow = statName,
            damageType = damageType,
            distance = when (color) {
                Color.BLACK, Color.BLUE, Color.BRASS, Color.BRONZE, Color.COPPER -> Distance.FIVE_BY_THIRTY_FEET_LINE
                Color.GOLD, Color.GREEN, Color.RED, Color.SILVER, Color.WHITE -> Distance.FIFTEEN_FEET_CONE
            }
        )) + super.damageAbilities()
    }

}
