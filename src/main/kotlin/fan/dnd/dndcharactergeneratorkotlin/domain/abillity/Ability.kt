package fan.dnd.dndcharactergeneratorkotlin.domain.abillity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import org.apache.commons.lang3.builder.HashCodeBuilder

@Embeddable
open class Ability protected constructor(
    var name: String,
    @Column(columnDefinition = "TEXT")
    var description: String,
    var useCount: Int,
    @Enumerated(EnumType.STRING)
    var refreshRate: SkillRefreshRate
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

    override fun equals(other: Any?): Boolean = this.hashCode() == other.hashCode()


    override fun hashCode(): Int =
       HashCodeBuilder()
            .append(name)
            .append(description)
            .append(useCount)
            .append(refreshRate)
            .toHashCode()

}
