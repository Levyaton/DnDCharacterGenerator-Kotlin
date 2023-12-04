package fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic

class SuperiorNightvision : Nightvision() {
    init {
        val description: String = super.description.replace("60", "120")
    }
}
