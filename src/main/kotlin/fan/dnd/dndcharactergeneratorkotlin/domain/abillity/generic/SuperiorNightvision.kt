package fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic

class SuperiorNightvision : Nightvision() {
    init {
        name = "Superior Nightvision"
        description = super.description.replace("60", "120")
    }
}
