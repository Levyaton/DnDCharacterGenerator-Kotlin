package fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic

import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
class SunlightSensitivity : Ability(
    "SunlightSensitivity",
    "You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely on sight when you, the target of your attack, or whatever you are trying to perceive is in direct sunlight.",
    999999,
    Ability.SkillRefreshRate.UNLIMITED
)
