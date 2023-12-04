package fan.dnd.dndcharactergeneratorkotlin.persistance

import jakarta.persistence.*

@MappedSuperclass
class IdAncestor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}