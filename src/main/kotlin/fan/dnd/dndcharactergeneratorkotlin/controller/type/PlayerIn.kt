package fan.dnd.dndcharactergeneratorkotlin.controller.type

import fan.dnd.dndcharactergeneratorkotlin.domain.StatName
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import kotlin.random.Random



class PlayerIn(){

    lateinit var name: String
    lateinit var race: AbstractRace
    var rolledIntelligence: Int = 0
    var rolledWisdom: Int = 0
    var rolledCharisma: Int = 0
    var rolledStrength: Int = 0
    var rolledDexterity: Int = 0
    var rolledConstitution: Int = 0

    constructor(
        name: String,
        race: AbstractRace,
        rolledIntelligence: Int,
        rolledWisdom: Int,
        rolledCharisma: Int,
        rolledStrength: Int,
        rolledDexterity: Int,
        rolledConstitution: Int
    ): this(){
        this.name = name
        this.race = race
        this.rolledIntelligence = rolledIntelligence
        this.rolledWisdom = rolledWisdom
        this.rolledCharisma = rolledCharisma
        this.rolledStrength = rolledStrength
        this.rolledDexterity = rolledDexterity
        this.rolledConstitution = rolledConstitution
    }

    constructor(
        name: String,
        race: AbstractRace,
        strongestStat: StatName,
        secondStrongestStat: StatName,
        thirdStrongestStat: StatName,
        fourthStrongestStat: StatName,
        fifthStrongestStat: StatName,
        sixthStrongestStat: StatName
    ) : this() {
        this.name = name
        this.race = race
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