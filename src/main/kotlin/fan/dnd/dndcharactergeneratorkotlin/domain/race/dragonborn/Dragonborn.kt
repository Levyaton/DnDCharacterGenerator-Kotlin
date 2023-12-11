package fan.dnd.dndcharactergeneratorkotlin.domain.race.dragonborn

import com.fasterxml.jackson.annotation.JsonTypeName
import fan.dnd.dndcharactergeneratorkotlin.domain.DamageType
import fan.dnd.dndcharactergeneratorkotlin.domain.DiceType
import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.StatName
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

@JsonTypeName("dragonborn")
class Dragonborn internal constructor(private val color: Color) : AbstractRace() {

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

    private val dragonBreath: Ability = AttackAbility(
        name = "Dragon Breath",
        description = "You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation. When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6 at 16th level. After you use your breath weapon, you can’t use it again until you complete a short or long rest.",
        useCount =  1,
        refreshRate = Ability.SkillRefreshRate.SHORT_REST,
        distance = "5 by 30 ft. line",
        savingThrow = statName,
        damageType = damageType,
        damageDice = DiceType.D6,
        difficultyDice = DiceType.D8,
        throwModifier = StatName.CONSTITUTION,
        addProficiencyBonus = true
    )

    override fun strength(): Stat {
        return Stat.Strength(2)
    }

    override fun charisma(): Stat {
        return Stat.Charisma(1)
    }

    override fun raceName(): Race = Race.DRAGONBORN

    override fun otherTraits(): String {
        return color.name + " Dragonborn"
    }

    override fun damageAbilities(): Set<Ability> {
        return setOf(dragonBreath) + super.damageAbilities()
    }

}
