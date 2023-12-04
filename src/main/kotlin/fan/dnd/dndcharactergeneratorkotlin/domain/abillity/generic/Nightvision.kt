package fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic

import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
open class Nightvision : Ability(
    "Nightvision",
    "You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.",
    999999,
    SkillRefreshRate.UNLIMITED
)
