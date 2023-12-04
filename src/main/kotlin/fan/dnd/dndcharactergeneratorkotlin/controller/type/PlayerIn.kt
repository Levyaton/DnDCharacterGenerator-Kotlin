package fan.dnd.dndcharactergeneratorkotlin.controller.type

import fan.dnd.dndcharactergeneratorkotlin.domain.StatName
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import kotlin.random.Random

data class PlayerIn(
    val name: String,
    val race: AbstractRace,
    var rolledIntelligence: Int,
    var rolledWisdom: Int,
    var rolledCharisma: Int,
    var rolledStrength: Int,
    var rolledDexterity: Int,
    var rolledConstitution: Int
) {
    constructor(
        name: String,
        race: AbstractRace,
        strongestStat: StatName,
        secondStrongestStat: StatName,
        thirdStrongestStat: StatName,
        fourthStrongestStat: StatName,
        fifthStrongestStat: StatName,
        sixthStrongestStat: StatName
    ) : this(
        name = name,
        race = race,
        rolledIntelligence = 0,
        rolledWisdom = 0,
        rolledCharisma = 0,
        rolledStrength = 0,
        rolledDexterity = 0,
        rolledConstitution = 0
    ) {
        if (setOf(
                strongestStat,
                secondStrongestStat,
                thirdStrongestStat,
                fourthStrongestStat,
                fifthStrongestStat,
                sixthStrongestStat
            ).size != StatName.entries.size
        ) {
            throw IllegalArgumentException("All stats must be present and given in the order of priority. Required stats are: ${StatName.entries.map { it.name }}")
        }
        assignStats(
            strongestStat,
            secondStrongestStat,
            thirdStrongestStat,
            fourthStrongestStat,
            fifthStrongestStat,
            sixthStrongestStat
        )
    }

    private fun rollStat(): Int {
        val rolls = List(4) { Random.nextInt(1, 7) } // Roll 4d6
        val sum = rolls.sorted().takeLast(3).sum() // Sort and sum the top 3
        return sum
    }

    private fun assignStats(
        strongestStat: StatName,
        secondStrongestStat: StatName,
        thirdStrongestStat: StatName,
        fourthStrongestStat: StatName,
        fifthStrongestStat: StatName,
        sixthStrongestStat: StatName
    ) {

        val rolledStats = mutableListOf(
            rollStat(),
            rollStat(),
            rollStat(),
            rollStat(),
            rollStat(),
            rollStat()
        ).sortedDescending()

        val statMap = mapOf(
            strongestStat to rolledStats[0],
            secondStrongestStat to rolledStats[1],
            thirdStrongestStat to rolledStats[2],
            fourthStrongestStat to rolledStats[3],
            fifthStrongestStat to rolledStats[4],
            sixthStrongestStat to rolledStats[5]
        )

        this.rolledIntelligence = statMap[StatName.INTELLIGENCE]!!
        this.rolledWisdom = statMap[StatName.WISDOM]!!
        this.rolledCharisma = statMap[StatName.CHARISMA]!!
        this.rolledStrength = statMap[StatName.STRENGTH]!!
        this.rolledDexterity = statMap[StatName.DEXTERITY]!!
        this.rolledConstitution = statMap[StatName.CONSTITUTION]!!
    }

}