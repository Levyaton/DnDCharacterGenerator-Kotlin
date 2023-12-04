package fan.dnd.dndcharactergeneratorkotlin.domain.abillity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Embeddable
open class Ability protected constructor(
    val name: String,
    @Column(columnDefinition = "TEXT")
    var description: String,
    val useCount: Int,
    @Enumerated(EnumType.STRING)
    val refreshRate: SkillRefreshRate
) {
    enum class SkillRefreshRate {
        SHORT_REST,
        LONG_REST,
        DAY,
        UNLIMITED
    } // Additional methods and logic...

    companion object {
        const val UNLIMITED_USE_CONSTANT = 999999
    }
}
