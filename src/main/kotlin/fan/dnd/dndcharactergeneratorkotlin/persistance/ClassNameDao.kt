package fan.dnd.dndcharactergeneratorkotlin.persistance

import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.ClassName
import jakarta.persistence.*

@Entity
class ClassNameDao(
    @Enumerated(EnumType.STRING)
    val name: ClassName
): IdAncestor()