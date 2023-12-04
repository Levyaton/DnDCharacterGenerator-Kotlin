package fan.dnd.dndcharactergeneratorkotlin.domain
data class DnDCharacter(
    val name: String,
    val race: String,
    val characterClass: String,
    val level: Int,
    val alignment: String,
    val background: String,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val hitPoints: Int,
    val armorClass: Int,
    val initiative: Int,
    val speed: Int
) {
    // Additional methods for character functionality
    // ...
    // You can still add custom methods or override the default ones if needed
}
