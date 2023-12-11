package fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic

import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability

class DrowMagic : Ability(
    "Drow Magic",
    "You know the dancing lights cantrip. When you reach 3rd level, you can cast the faerie fire spell once per day. When you reach 5th level, you can also cast the darkness spell once per day. Charisma is your spellcasting ability for these spells.",
    1,
    SkillRefreshRate.DAY
)
