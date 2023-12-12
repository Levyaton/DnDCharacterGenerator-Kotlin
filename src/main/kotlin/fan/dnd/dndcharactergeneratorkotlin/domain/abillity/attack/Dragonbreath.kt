package fan.dnd.dndcharactergeneratorkotlin.domain.abillity.attack

import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.DamageType
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.DiceType
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Distance
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.StatName
import fan.dnd.dndcharactergeneratorkotlin.domain.race.dragonborn.Dragonborn

class Dragonbreath(
    savingThrow: StatName,
    damageType: DamageType,
    distance: Distance,
) : AttackAbility(
    name = "Dragon Breath",
    description = "You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation. When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6 at 16th level. After you use your breath weapon, you can’t use it again until you complete a short or long rest.",
    useCount =  1,
    refreshRate = Ability.SkillRefreshRate.SHORT_REST,
    distance = distance,
    savingThrow = savingThrow,
    damageType = damageType,
    damageDice = DiceType.D6,
    difficultyDice = DiceType.D8,
    throwModifier = StatName.CONSTITUTION,
    addProficiencyBonus = true
)