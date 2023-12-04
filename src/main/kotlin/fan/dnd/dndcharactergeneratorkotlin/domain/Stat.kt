package fan.dnd.dndcharactergeneratorkotlin.domain


abstract class Stat(val value: Int = 0, val name: StatName) {

    class Strength(value: Int) : Stat(value, StatName.STRENGTH)
    class Dexterity(value: Int) : Stat(value, StatName.DEXTERITY)
    class Constitution(value: Int) : Stat(value, StatName.CONSTITUTION)
    class Intelligence(value: Int) : Stat(value, StatName.INTELLIGENCE)
    class Wisdom(value: Int) : Stat(value, StatName.WISDOM)
    class Charisma(value: Int) : Stat(value, StatName.CHARISMA)
}
