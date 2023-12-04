package fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic

import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
class FeyAncestry : Ability(
    "Fey",
    "You have advantage on saving throws against being charmed, and magic can't put you to sleep.",
    Ability.UNLIMITED_USE_CONSTANT,
    SkillRefreshRate.UNLIMITED
)
